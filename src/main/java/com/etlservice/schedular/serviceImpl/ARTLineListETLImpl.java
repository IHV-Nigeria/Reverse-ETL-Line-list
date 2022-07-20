/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.serviceImpl;

import com.etlservice.schedular.entities.ArtLinelist;
import com.etlservice.schedular.entities.Facility;
import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.ObsType;
import com.etlservice.schedular.mongorepo.postgres.ArtLineListRepository;
import com.etlservice.schedular.mongorepo.postgres.FacilityRepository;
import com.etlservice.schedular.service.ARTLineListETL;
import com.etlservice.schedular.utils.ConstantsUtils;
import com.etlservice.schedular.utils.HelperFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.etlservice.schedular.utils.ConstantsUtils.*;

/**
 *
 * @author MORRISON.I
 */
@Service
@RequiredArgsConstructor
public class ARTLineListETLImpl implements ARTLineListETL {
    private final ArtLineListRepository artLineListRepository;
    private final FacilityRepository facilityRepository;

    @Override
    public void extractData(List<Container> mongoContainers) {
        Facility facility = facilityRepository.findFacilityByDatimCode(mongoContainers.get(0).getMessageHeader().getFacilityDatimCode());
        List<ArtLinelist> allArtLine = mongoContainers.stream()
                .map(container -> mapARTLineList(container, facility))
                .filter(a -> a.getPatientUniqueId() != null)
                .collect(Collectors.toList());
        artLineListRepository.saveAll(allArtLine);
    }

    private ArtLinelist mapARTLineList(Container container, Facility facility) {

        ArtLinelist artLinelist = artLineListRepository.findByPatientUuid(container.getId())
                .orElse(new ArtLinelist());
        artLinelist.setDatimCode(container.getMessageHeader().getFacilityDatimCode());
        artLinelist.setFacilityName(container.getMessageHeader().getFacilityName());
        artLinelist.setPatientId(BigInteger.valueOf(container.getMessageData().getDemographics().getPatientId()));
        artLinelist.setPatientUuid(container.getMessageData().getDemographics().getPatientUuid());
        artLinelist.setPatientUniqueId(HelperFunctions.returnIdentifiers(4, container).orElse(null));
        artLinelist.setPatientHospitalNo(HelperFunctions.returnIdentifiers(5, container).orElse(null));
        artLinelist.setAncNoIdentifier(HelperFunctions.returnIdentifiers(6, container).orElse(null));
        Optional<ObsType> ancNoConceptID = HelperFunctions.getMaxConceptObsIdWithFormId(16,165567,container);
        ancNoConceptID.ifPresent(obsType -> artLinelist.setAncNoConceptId(obsType.getValueText()));
        artLinelist.setHtsNo(HelperFunctions.returnIdentifiers(8, container).orElse(null));
        artLinelist.setSex(container.getMessageData().getDemographics().getGender());

        Integer ageAtStartOfARTYears = HelperFunctions.getAgeAtStartOfARTYears(container);
        if (ageAtStartOfARTYears != null) {
            if (ageAtStartOfARTYears >= 5)
                artLinelist.setAgeAtStartOfArtYears(BigInteger.valueOf(ageAtStartOfARTYears));
            else
                artLinelist.setAgeAtStartOfArtMonths(BigInteger.valueOf(HelperFunctions.getAgeAtStartOfARTMonths(container)));
        }
        artLinelist.setCareEntryPoint(HelperFunctions.getObsByConceptID(160540, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setKpType(HelperFunctions.getMaxConceptObsIdWithFormId(23, 166369, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setDateTransferredIn(HelperFunctions.getObsByConceptID(160534, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setTransferInStatus(HelperFunctions.getObsByConceptID(165242, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setArtStartDate(HelperFunctions.getArtStartDate(container));
        Optional<ObsType> maxObsByConceptID = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm, 162240, container);
        maxObsByConceptID.ifPresent(obsType -> {
            artLinelist.setLastPickupDate(obsType.getObsDatetime());
            Optional<ObsType> daysOfArv = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 159368, container);
            daysOfArv.ifPresent(obsType1 -> artLinelist.setDaysOfArvRefil(obsType1.getValueNumeric().toBigInteger()));
        });
        artLinelist.setLastVisitDate(HelperFunctions.getMaxVisitDate(container).orElse(null));
        artLinelist.setMonthsOnArt(HelperFunctions.getMonthsOnArt(container, artLinelist.getLastPickupDate()));

        Optional<ObsType> maxObsByConceptID1 = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm, 166406, container);
        maxObsByConceptID1.ifPresent(obsType -> artLinelist.setPillBalance(new BigInteger(obsType.getValueText())));
//        if (maxObsByConceptID1.isPresent()) {
//            artLinelist.setPillBalance(new BigInteger(maxObsByConceptID1.map(ObsType::getValueText).orElse(null)));
//        }

        Optional<ObsType> initialRegLine = HelperFunctions.getMinObsByConceptID(ConstantsUtils.PharmacyEncounterType, 165708, container);
        initialRegLine.ifPresent(obsType -> {
            artLinelist.setInitialRegimenLine(obsType.getVariableValue());
            Optional<ObsType> initialReg = HelperFunctions.getInitialRegimen(obsType.getEncounterType(), obsType.getValueCoded(), container);
            initialReg.ifPresent(obsType1 -> artLinelist.setInitialRegimen(obsType1.getVariableValue()));
        });

        Optional<ObsType> initialCd4Opt = HelperFunctions.getMinConceptObsIdWithFormId(21, 5497, container);
        initialCd4Opt.ifPresent(obsType -> {
            artLinelist.setInitialCd4Count(obsType.getValueNumeric().toBigInteger());
            artLinelist.setInitialCd4CountDate(obsType.getObsDatetime());
        });
//        if (initialCd4Opt.isPresent()) {
//            initialCd4Opt.map(ObsType::getValueNumeric).orElse(null).toBigInteger());
//            artLinelist.setInitialCd4CountDate(initialCd4Opt.map(ObsType::getObsDatetime).orElse(null));
//        }

        Optional<ObsType> currentCd4Opt = HelperFunctions.getMaxConceptObsIdWithFormId(21, 5497, container);
        currentCd4Opt.ifPresent(obsType -> {
            artLinelist.setCurrentCd4Count(obsType.getValueNumeric().toBigInteger());
            artLinelist.setCurrentCd4CountDate(obsType.getObsDatetime());
        });
//        if (currentCd4Opt.isPresent()) {
//            currentCd4Opt.map(ObsType::getValueNumeric).orElse(null).toBigInteger());
//            artLinelist.setCurrentCd4CountDate(currentCd4Opt.map(ObsType::getObsDatetime).orElse(null));
//        }

        Optional<ObsType> currentRegimenLine = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm,165708,container);
        currentRegimenLine.ifPresent(obsType -> {
            artLinelist.setCurrentRegimenLine(obsType.getVariableValue());
            Optional<ObsType> currentRegimenType = HelperFunctions.getCurrentRegimen(obsType.getEncounterType(), obsType.getValueCoded(), container);
            currentRegimenType.ifPresent(obsType1 -> artLinelist.setCurrentRegimen(obsType1.getVariableValue()));
        });

        //Update by Tayo oyelekan

        artLinelist.setArtConfirmationDate(HelperFunctions.getObsByConceptID(160554, container).map(ObsType::getValueDatetime).orElse(null));

        Optional<ObsType> baseLineINHStartDate = HelperFunctions.getMaxObsByConceptID(ARTCommencementType,164852,container);
        baseLineINHStartDate.ifPresent(obsType -> artLinelist.setBaselineInhStartDate(obsType.getValueDatetime()));

        Optional<ObsType> baseLineINHStopDate = HelperFunctions.getMaxObsByConceptID(ARTCommencementType,166096,container);
        baseLineINHStopDate.ifPresent(obsType -> artLinelist.setBaselineInhStopDate(obsType.getValueDatetime()));

        artLinelist.setBaselineTbTreatmentStartDate(HelperFunctions.getObsByConceptID(1113, container).map(ObsType::getValueDatetime).orElse(null));

        artLinelist.setBaselineTbTreatmentStopDate(HelperFunctions.getObsByConceptID(159431, container).map(ObsType::getValueDatetime).orElse(null));

        Optional<ObsType> clinicalNextAppointment = HelperFunctions.getMaxObsByConceptID(CareCardEncounterType,5096,container);
        clinicalNextAppointment.ifPresent(obsType -> artLinelist.setClinicalNextAppointment(obsType.getValueDatetime()));

        artLinelist.setCurrentAgeYrs(HelperFunctions.getCurrentAge(container,ageTypeYear));
        artLinelist.setCurrentAgeMonths(HelperFunctions.getCurrentAge(container,ageTypeMonth));
        artLinelist.setDateOfTermination(HelperFunctions.getObsByConceptID(165469, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setDateReturnedToCare(HelperFunctions.getObsByConceptID(165775, container).map(ObsType::getValueDatetime).orElse(null));

        Optional<ObsType> patientOutCome = HelperFunctions.getMaxConceptObsIdWithFormId(13,165470,container);
        if(patientOutCome.isPresent()) {
            artLinelist.setPatientOutcome(patientOutCome.get().getVariableValue());
            artLinelist.setPatientOutcomeDate(patientOutCome.get().getObsDatetime());
        }
        String outcome = HelperFunctions.getCurrentARTStatus(
                artLinelist.getLastPickupDate(),artLinelist.getDaysOfArvRefil(),
                artLinelist.getDateOfTermination(), artLinelist.getDateReturnedToCare());
        artLinelist.setCurrentArtStatus(outcome);
//        artLinelist.setCurrentArtStatus(
//                artLinelist.getPatientOutcome() != null ? artLinelist.getPatientOutcome() : HelperFunctions.getCurrentARTStatus(artLinelist.getLastPickupDate(),artLinelist.getDaysOfArvRefil(),
//                                artLinelist.getDateOfTermination(), artLinelist.getDateReturnedToCare())
//        );

        Optional<ObsType> currentCD4 = HelperFunctions.getMaxObsByConceptID(LabEncounterType,5497,container);
        currentCD4.ifPresent(obsType -> artLinelist.setCurrentCd4Count(BigInteger.valueOf(Integer.parseInt(obsType.getVariableValue()))));

        Optional<ObsType> currentCD4Date = HelperFunctions.getMaxObsByConceptID(LabEncounterType,5497,container);
        currentCD4Date.ifPresent(obsType -> artLinelist.setCurrentCd4CountDate(obsType.getObsDatetime()));

        Optional<ObsType> currentINHOutcome = HelperFunctions.getMaxObsByConceptID(IPTType,166007,container);
        currentINHOutcome.ifPresent(obsType -> artLinelist.setCurrentInhOutcome(obsType.getVariableValue()));

        Optional<ObsType> currentINHOutcomeDate = HelperFunctions.getMaxObsByConceptID(IPTType,166008,container);
        currentINHOutcomeDate.ifPresent(obsType -> artLinelist.setCurrentInhOutcomeDate(obsType.getValueDatetime()));

        artLinelist.setBiometricCaptured(HelperFunctions.getBiometricCaptured(container));
        artLinelist.setBiometricCaptureDate(HelperFunctions.getBiometricCaptureDate(container));
        Optional<ObsType> currentINHStartDate = HelperFunctions.getMaxObsByConceptID(IPTType,165994,container);
        currentINHStartDate.ifPresent(obsType -> artLinelist.setCurrentInhStartDate(obsType.getValueDatetime()));

        Optional<ObsType> currentViralLoad = HelperFunctions.getMaxConceptObsIdWithFormId(21,856,container);
        currentViralLoad.ifPresent(obsType -> {
            artLinelist.setCurrentViralLoad(obsType.getValueNumeric().doubleValue());

            artLinelist.setViralLoadEncounterDate(obsType.getObsDatetime());

            Optional<ObsType> report = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 165414, container);
            report.ifPresent(obsType1 -> artLinelist.setViralLoadReportedDate(obsType1.getValueDatetime()));

            Optional<ObsType> viralLoadSampleCollectionDate = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(),159951,container);
            viralLoadSampleCollectionDate.ifPresent(obsType1 -> artLinelist.setViralLoadSampleCollectionDate(obsType1.getValueDatetime()));

            Optional<ObsType> resultDate = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(),166423,container);
            resultDate.ifPresent(obsType1 -> artLinelist.setResultDate(obsType1.getValueDatetime()));

            Optional<ObsType> assayDate = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(),166424,container);
            assayDate.ifPresent(obsType1 -> artLinelist.setAssayDate(obsType1.getValueDatetime()));

            Optional<ObsType> approvalDate = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(),166425,container);
            approvalDate.ifPresent(obsType1 -> artLinelist.setApprovalDate(obsType1.getValueDatetime()));

            Optional<ObsType> viralLoadIndication = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(),164980,container);
            viralLoadIndication.ifPresent(obsType1 -> artLinelist.setViralLoadIndication(obsType1.getVariableValue()));
        });

        artLinelist.setLastViralLoadSampleCollectionFormDate(HelperFunctions.getMaxEncounterDateTime(SampleCollectionForm,container));

        Optional<ObsType> currentWeight = HelperFunctions.getMaxConceptObsIdWithFormId(EnrollmentType,5089,container);
        currentWeight.ifPresent(obsType -> {
            artLinelist.setCurrentWeight(Double.parseDouble(obsType.getVariableValue()));
            artLinelist.setCurrentWeightDate(obsType.getObsDatetime());
        });

//        Optional<ObsType> currentWeightDate = HelperFunctions.getMaxConceptObsIdWithFormId(EnrollmentType,5089,container);
//        currentWeightDate.ifPresent(obsType -> );

        Date dob = container.getMessageData().getDemographics().getBirthdate();
        artLinelist.setDateOfBirth(dob);

        Optional<ObsType> dddDispensingModality = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm,162240,container);
        dddDispensingModality.ifPresent(obsType -> {
            Optional<ObsType> dddDispensingModality2 = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 166363, container);
            dddDispensingModality2.ifPresent(obsType1 -> artLinelist.setDddDispensingModality(obsType1.getVariableValue()));
        });

        Optional<ObsType> dispensingModality = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm,162240,container);
        dispensingModality.ifPresent(obsType -> {
            Optional<ObsType> dispensingModality2 = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 166148, container);
            dispensingModality2.ifPresent(obsType1 -> artLinelist.setDispensingModality(obsType1.getVariableValue()));
        });

        artLinelist.setEnrollmentDate(HelperFunctions.getMaxEncounterDateTime(EnrollmentForm,container));

        Optional<ObsType> facilityDispensingModality = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm,162240,container);
        facilityDispensingModality.ifPresent(obsType -> {
            Optional<ObsType> facilityDispensingModality2 = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 166276, container);
            facilityDispensingModality2.ifPresent(obsType1 -> artLinelist.setFacilityDispensingModality(obsType1.getVariableValue()));
        });

        Optional<Date> firstPickupDate = HelperFunctions.getMinEncounterDateTime(PharmacyForm,container);
        firstPickupDate.ifPresent(artLinelist::setFirstPickupDate);

        Optional<ObsType> initialFirstLineRegimen = HelperFunctions.getInitialRegimenLine(164506,164507,container);
        initialFirstLineRegimen.ifPresent(obsType -> artLinelist.setInitialFirstLineRegimen(obsType.getVariableValue()));

        Optional<Date> initialFirstLineRegimenDate = HelperFunctions.getInitialRegimenLineDate(164506,164507,container);
        initialFirstLineRegimenDate.ifPresent(artLinelist::setInitialFirstLineRegimenDate);

        Optional<ObsType> initialSecondLineRegimen = HelperFunctions.getInitialRegimenLine(164513,164514,container);
        initialSecondLineRegimen.ifPresent(obsType -> artLinelist.setInitialSecondLineRegimen(obsType.getVariableValue()));

        Optional<Date> initialSecondLineRegimenDate = HelperFunctions.getInitialRegimenLineDate(164513,164514,container);
        initialSecondLineRegimenDate.ifPresent(artLinelist::setInitialSecondLineRegimenDate);

        artLinelist.setLastEacDate(HelperFunctions.getMaxEncounterDateTime(69, container));

        Optional<Date> lastINHDispensedDate = HelperFunctions.getLastINHDispensedDate(165727,1679,PharmacyForm,container);
        lastINHDispensedDate.ifPresent(artLinelist::setLastInhDispensedDate);

        Optional<ObsType> lastQtyOfARVRefil = HelperFunctions.getMaxObsByConceptID(PharmacyEncounterType,1443,container);
        lastQtyOfARVRefil.ifPresent(obsType -> artLinelist.setLastQtyOfArvRefill(BigInteger.valueOf(Integer.parseInt(obsType.getVariableValue()))));

        Optional<ObsType> lastSampleTakenDate = HelperFunctions.getMaxObsByConceptID(LabEncounterType,159951,container);
        lastSampleTakenDate.ifPresent(obsType -> artLinelist.setLastSampleTakenDate(obsType.getValueDatetime()));

        artLinelist.setLgaName(facility.getLga().getLga());
        artLinelist.setState(facility.getState().getStateName());

        int deathMark = container.getMessageData().getDemographics().getDead();
        if (deathMark == 1) {
            artLinelist.setMarkAsDeceased("Dead");
            artLinelist.setMarkAsDeceasedDeathDate(container.getMessageData().getDemographics().getDeathDate());
        }

        Optional<ObsType> mmdType = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm,162240,container);
        mmdType.ifPresent(obsType -> {
            Optional<ObsType> mmdType2 = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 166278, container);
            mmdType2.ifPresent(obsType1 -> artLinelist.setMmdType(obsType1.getVariableValue()));
        });

        Optional<ObsType> nextOfKinPhoneNo = HelperFunctions.getMaxObsByConceptID(EnrollmentType,159635,container);
        nextOfKinPhoneNo.ifPresent(obsType -> artLinelist.setNextOfKinPhoneNo(obsType.getVariableValue()));

        artLinelist.setOtzEnrollmentDate(HelperFunctions.getMaxEncounterDateTime(OTZForm,container));
        Optional<ObsType> otzOutCOmeDate = HelperFunctions.getMaxObsByConceptID(PharmacyEncounterType,166008,container);
        otzOutCOmeDate.ifPresent(obsType -> artLinelist.setOtzOutcomeDate(obsType.getValueDatetime()));

        Optional<ObsType> pharmacyNextAppointment = HelperFunctions.getMaxObsByConceptID(PharmacyEncounterType,5096,container);
        pharmacyNextAppointment.ifPresent(obsType -> artLinelist.setPharmacyNextAppointment(obsType.getValueDatetime()));
        Optional<ObsType> pillBalance = HelperFunctions.getMaxObsByConceptID(PharmacyEncounterType,166406,container);
        pillBalance.ifPresent(obsType -> artLinelist.setPillBalance(BigInteger.valueOf(Integer.parseInt(obsType.getVariableValue()))));

        artLinelist.setSex(container.getMessageData().getDemographics().getGender());

        if (artLinelist.getSex() != null && artLinelist.getSex().equals("F")) {
            Optional<ObsType> pregnancyStatus = HelperFunctions.getMaxConceptObsIdWithFormId(14, 165050, container);
            pregnancyStatus.ifPresent(obsType -> {
                artLinelist.setPregnancyStatus(obsType.getVariableValue());
                artLinelist.setPregnancyStatusDate(obsType.getObsDatetime());
                artLinelist.setLastDeliveryDate(obsType.getValueDatetime());
                Optional<ObsType> edd = HelperFunctions.getMaxObsByConceptID(obsType.getEncounterId(),5596,container);
                edd.ifPresent(obsType1 -> artLinelist.setEdd(obsType1.getValueDatetime()));
                Optional<ObsType> lmp = HelperFunctions.getMaxObsByConceptID(obsType.getEncounterId(), 1427, container);
                lmp.ifPresent(obsType1 -> artLinelist.setLmp(obsType1.getValueDatetime()));
                Optional<ObsType> gestationAgeWeeks = HelperFunctions.getMaxObsByConceptID(obsType.getEncounterId(),1438,container);
                gestationAgeWeeks.ifPresent(obsType1 -> artLinelist.setGestationAgeWeeks(obsType1.getValueNumeric().toBigInteger()));
            });
        }

        Optional<ObsType> tbStatus = HelperFunctions.getMaxConceptObsIdWithFormId(EnrollmentType,1659,container);
        if(tbStatus.isPresent()) {
            artLinelist.setTbStatus(tbStatus.get().getVariableValue());
            artLinelist.setTbStatusDate(tbStatus.get().getObsDatetime());
        }

        Optional<ObsType> treatmentSupporterPhoneNo = HelperFunctions.getMaxObsByConceptID(EnrollmentType,160642,container);
        treatmentSupporterPhoneNo.ifPresent(obsType -> artLinelist.setTreatmentSupporterPhoneNo(obsType.getVariableValue()));

        artLinelist.setValidCapture(HelperFunctions.getValidCapture(container));

        Optional<ObsType> lastPickupPreviousQuarter = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm, 162240, container, LocalDate.now());
        lastPickupPreviousQuarter.ifPresent(obsType -> {
            artLinelist.setLastPickupDatePreviousQuarter(obsType.getObsDatetime());
            Optional<ObsType> drugDurationPreviousQuarter = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 159368, container);
            drugDurationPreviousQuarter.ifPresent(obsType1 -> artLinelist.setDrugDurationPreviousQuarter(obsType1.getValueNumeric()));
        });

        Optional<ObsType> patientOutcomePreviousQuarter = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyEncounterType, 165470, container, LocalDate.now());
        patientOutcomePreviousQuarter.ifPresent(obsType -> {
            artLinelist.setPatientOutcomePreviousQuarter(obsType.getVariableValue());
            artLinelist.setPatientOutcomeDatePreviousQuarter(obsType.getObsDatetime());
        });

        final BigInteger[] daysOfRefilPreviousQuarter = new BigInteger[1];
        Optional<ObsType> maxObsByConceptID2 = HelperFunctions.getMaxConceptObsIdWithFormId(PharmacyForm, 162240, container, LocalDate.now());
        maxObsByConceptID2.ifPresent(obsType -> {
            Optional<ObsType> daysOfArv = HelperFunctions.getObsByEncounterId(obsType.getEncounterId(), 159368, container, LocalDate.now());
            daysOfArv.ifPresent(obsType1 -> daysOfRefilPreviousQuarter[0] = obsType1.getValueNumeric().toBigInteger());
        });

        artLinelist.setArtStatusPreviousQuarter(
                artLinelist.getPatientOutcomePreviousQuarter() != null ? artLinelist.getArtStatusPreviousQuarter() :
                HelperFunctions.getCurrentARTStatus(artLinelist.getLastPickupDatePreviousQuarter(),
                        daysOfRefilPreviousQuarter[0], artLinelist.getDateOfTermination(), artLinelist.getDateReturnedToCare())
        );

        return artLinelist;
    }
}
