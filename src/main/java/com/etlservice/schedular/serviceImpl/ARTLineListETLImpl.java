/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.serviceImpl;

import com.etlservice.schedular.SchedularService.RadetService;
import com.etlservice.schedular.entities.ArtLinelist;
import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.ObsType;
import com.etlservice.schedular.model.Radet;
import com.etlservice.schedular.mongorepo.postgres.ArtLineListRepository;
import com.etlservice.schedular.service.ARTLineListETL;
import com.etlservice.schedular.utils.ConstantsUtils;
import com.etlservice.schedular.utils.HelperFunctions;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.etlservice.schedular.utils.ConstantsUtils.*;
import static com.etlservice.schedular.utils.Regimen.getRegimen;


/**
 *
 * @author MORRISON.I
 */
@Service
@RequiredArgsConstructor
public class ARTLineListETLImpl implements ARTLineListETL {
    private final ArtLineListRepository artLineListRepository;

    @Override
    public void extractData(List<Container> mongoContainers) {
        List<ArtLinelist> allArtLine = mongoContainers.stream()
                .map(this::mapARTLineList)
                .filter(a -> a.getPatientUniqueId() != null)
                .collect(Collectors.toList());
//
        artLineListRepository.saveAll(allArtLine);

//        List<Radet> allArtLine = mongoContainers.stream()
//                .map(RadetService::setupContainer)
//                .filter(a -> a.getPatientUniqueID() != null)
//                .collect(Collectors.toList());

        //artLineListRepository.saveAll(allArtLine);
    }

    private ArtLinelist mapARTLineList(Container container) {

        ArtLinelist artLinelist = new ArtLinelist();
        artLinelist.setDatimCode(container.getMessageHeader().getFacilityDatimCode());
        artLinelist.setFacilityName(container.getMessageHeader().getFacilityName());
        artLinelist.setPatientId(BigInteger.valueOf(container.getMessageData().getDemographics().getPatientId()));
        artLinelist.setPatientUuid(container.getMessageData().getDemographics().getPatientUuid());
        artLinelist.setPatientUniqueId(HelperFunctions.returnIdentifiers(4, container).orElse(null));
        artLinelist.setPatientHospitalNo(HelperFunctions.returnIdentifiers(5, container).orElse(null));
        //Update by Tayo oyelekan
        artLinelist.setAncNoIdentifier(HelperFunctions.returnIdentifiers(6, container).orElse(null));
        artLinelist.setSex(container.getMessageData().getDemographics().getGender());

        if (HelperFunctions.getAgeAtStartOfARTYears(container) != null) {
            artLinelist.setAgeAtStartOfArtYears(BigInteger.valueOf(HelperFunctions.getAgeAtStartOfARTYears(container)));
            artLinelist.setAgeAtStartOfArtMonths(BigInteger.valueOf(HelperFunctions.getAgeAtStartOfARTMonths(container)));
        }
        artLinelist.setCareEntryPoints(HelperFunctions.getObsbyConceptID(160540, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setKpType(HelperFunctions.getObsbyConceptID(166369, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setLastPickupDate(HelperFunctions.getMaxEncounterDateTime(27, container));

        artLinelist.setMonthsOnArt(HelperFunctions.getMonthsOnArt(container, artLinelist.getLastPickupDate()));
        artLinelist.setDateTransferredIn(HelperFunctions.getObsbyConceptID(160534, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setTransferInStatus(HelperFunctions.getObsbyConceptID(165242, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setArtStartDate(HelperFunctions.getArtStartDate(container));

        artLinelist.setLastVisitDate(HelperFunctions.getMaxVisitDate(container).orElse(null));
        Optional<ObsType> maxObsbyConceptID = HelperFunctions.getMaxObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 159368, container);
        if (maxObsbyConceptID.isPresent()) {
            artLinelist.setDaysOfArvRefil(maxObsbyConceptID.map(ObsType::getValueNumeric).get().toBigInteger());
        }

        Optional<ObsType> maxObsbyConceptID1 = HelperFunctions.getMaxObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 166406, container);

        if (maxObsbyConceptID1.isPresent()) {
            artLinelist.setPillBalance(new BigInteger(maxObsbyConceptID1.map(ObsType::getValueText).get()));
        }

        Optional<ObsType> initialRegOpt = HelperFunctions.getMinObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 165708, container);

        if (initialRegOpt.isPresent()) {
//            artLinelist.setInitialRegimen(initialRegOpt.map(ObsType::getVariableValue).get());
            String regimen = getRegimen(initialRegOpt.map(ObsType::getValueCoded).get());
            artLinelist.setInitialRegimen(regimen);
        }

        Optional<ObsType> initialRegLine = HelperFunctions.getMinObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 165708, container);

        if (initialRegLine.isPresent()) {
            artLinelist.setInitialRegimenLine(initialRegOpt.map(ObsType::getVariableValue).get());
        }

        Optional<ObsType> initialCd4Opt = HelperFunctions.getMinObsbyConceptID(LabEncounterType, 5497, container);

        if (initialCd4Opt.isPresent()) {
            artLinelist.setInitialCd4Count(initialCd4Opt.map(ObsType::getValueNumeric).get().toBigInteger());
            artLinelist.setInitialCd4CountDate(initialCd4Opt.map(ObsType::getObsDatetime).get());
        }

        Optional<ObsType> currentCd4Opt = HelperFunctions.getMaxObsbyConceptID(LabEncounterType, 5497, container);
        if (currentCd4Opt.isPresent()) {
            artLinelist.setCurrentCd4Count(currentCd4Opt.map(ObsType::getValueNumeric).get().toBigInteger());
            artLinelist.setCurrentCd4CountDate(currentCd4Opt.map(ObsType::getObsDatetime).get());
        }

        Optional<ObsType> currentRegOpt = HelperFunctions.getMaxObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 165708, container);

        if (currentRegOpt.isPresent()) {
            String regimen = getRegimen(currentRegOpt.map(ObsType::getValueCoded).get());
            artLinelist.setCurrentRegimen(regimen);
        }


        //Update by Tayo oyelekan
        Optional<ObsType> ancNoConceptID = HelperFunctions.getMaxObsbyConceptID(GeneralAntenatalCareType,165567,container);
        if (ancNoConceptID.isPresent()){
            artLinelist.setAncNoConceptId(ancNoConceptID.get().getVariableValue());
        }


        Optional<ObsType> approvalDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,166425,container);
        if(approvalDate.isPresent())
            artLinelist.setApprovalDate(approvalDate.get().getValueDatetime());

        artLinelist.setArtConfirmationDate(HelperFunctions.getObsbyConceptID(160554, container).map(ObsType::getValueDatetime).orElse(null));

        Optional<ObsType> assayDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,166424,container);
        if(assayDate.isPresent())
            artLinelist.setAssayDate(assayDate.get().getValueDatetime());

        Optional<ObsType> baseLineINHStartDate = HelperFunctions.getMaxObsbyConceptID(ARTCommencementType,164852,container);
        if(baseLineINHStartDate.isPresent())
            artLinelist.setBaselineInhStartDate(baseLineINHStartDate.get().getValueDatetime());

        Optional<ObsType> baseLineINHStopDate = HelperFunctions.getMaxObsbyConceptID(ARTCommencementType,166096,container);
        if(baseLineINHStopDate.isPresent())
            artLinelist.setBaselineInhStopDate(baseLineINHStopDate.get().getValueDatetime());

        artLinelist.setBaselineTbTreatmentStartDate(HelperFunctions.getObsbyConceptID(1113, container).map(ObsType::getValueDatetime).orElse(null));

        artLinelist.setBaselineTbTreatmentStopDate(HelperFunctions.getObsbyConceptID(159431, container).map(ObsType::getValueDatetime).orElse(null));

        Optional<ObsType> clinicalNextAppointment = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,5096,container);
        if(clinicalNextAppointment.isPresent())
            artLinelist.setClinicalNextAppointment(clinicalNextAppointment.get().getValueDatetime());

        artLinelist.setCurrentAgeYrs(HelperFunctions.getCurrentAge(container,ageTypeYear));
        artLinelist.setCurrentAgeMonths(HelperFunctions.getCurrentAge(container,ageTypeMonth));
        artLinelist.setDateOfTermination(HelperFunctions.getObsbyConceptID(165469, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setDateReturnedToCare(HelperFunctions.getObsbyConceptID(165775, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setCurrentArtStatus(HelperFunctions.getCurrentARTStatus(artLinelist.getLastPickupDate(),artLinelist.getDaysOfArvRefil(),artLinelist.getDateOfTermination(),artLinelist.getDateReturnedToCare()));

        Optional<ObsType> currentCD4 = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,5497,container);
        if(currentCD4.isPresent())
            artLinelist.setCurrentCd4Count(BigInteger.valueOf(Integer.parseInt(currentCD4.get().getVariableValue())));

        Optional<ObsType> currentCD4Date = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,5497,container);
        if(currentCD4Date.isPresent())
            artLinelist.setCurrentCd4CountDate(currentCD4Date.get().getObsDatetime());

        Optional<ObsType> currentINHOutcome = HelperFunctions.getMaxObsbyConceptID(IPTType,166007,container);
        if(currentINHOutcome.isPresent())
            artLinelist.setCurrentInhOutcome(currentINHOutcome.get().getVariableValue());

        Optional<ObsType> currentINHOutcomeDate = HelperFunctions.getMaxObsbyConceptID(IPTType,166008,container);
        if(currentINHOutcomeDate.isPresent())
            artLinelist.setCurrentInhOutcomeDate(currentINHOutcomeDate.get().getValueDatetime());

        artLinelist.setBiometricCaptured(HelperFunctions.getBiometricCaptured(container));
        artLinelist.setBiometricCapturedDate(HelperFunctions.getBiometricCapturedDate(container));
        Optional<ObsType> CurrentINHStartDate = HelperFunctions.getMaxObsbyConceptID(IPTType,165994,container);
        if(CurrentINHStartDate.isPresent())
            artLinelist.setCurrentInhStartDate(CurrentINHStartDate.get().getValueDatetime());

        Optional<ObsType> CurrentRegimenLine = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,165708,container);
        if(CurrentRegimenLine.isPresent())
            artLinelist.setCurrentRegimenLine(CurrentRegimenLine.get().getVariableValue());

        Optional<ObsType> currentViralLoad = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,856,container);
        if(currentViralLoad.isPresent())
            artLinelist.setCurrentViralLoad(BigInteger.valueOf(Integer.parseInt(currentViralLoad.get().getVariableValue())));

        Optional<ObsType> currentWeight = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,5089,container);
        if(currentWeight.isPresent())
            artLinelist.setCurrentWeight(BigInteger.valueOf(Integer.parseInt(currentWeight.get().getVariableValue())));

        Optional<ObsType> currentWeightDate = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,5089,container);
        if(currentWeightDate.isPresent())
            artLinelist.setCurrentWeightDate(currentWeightDate.get().getObsDatetime());

        Date dob= null;
        dob = container.getMessageData().getDemographics().getBirthdate();
            artLinelist.setDateOfBirth(dob);

        Optional<ObsType> dddDispensingModality = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166363,container);
        if(dddDispensingModality.isPresent())
            artLinelist.setDddDispensingModality(dddDispensingModality.get().getVariableValue());

        Optional<ObsType> dispensingModality = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166148,container);
        if(dispensingModality.isPresent())
            artLinelist.setDispensingModality(dispensingModality.get().getVariableValue());

        Optional<ObsType> edd = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,5596,container);
        if(edd.isPresent())
            artLinelist.setEdd(edd.get().getValueDatetime());

        artLinelist.setEnrollmentDate(HelperFunctions.getMaxEncounterDateTime(EnrollmentForm,container));

        Optional<ObsType> facilityDispensingModality = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166276,container);
        if(facilityDispensingModality.isPresent())
            artLinelist.setFacilityDispensingModality(facilityDispensingModality.get().getVariableValue());

        Optional<Date> firstPickupDate = HelperFunctions.getMinEncounterDateTime(PharmacyForm,container);
        if(firstPickupDate.isPresent())
            artLinelist.setFirstPickupDate(firstPickupDate.get());

        Optional<ObsType> gestationAgeWeeks = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,1438,container);
        if(gestationAgeWeeks.isPresent())
            artLinelist.setGestationAgeWeeks(BigInteger.valueOf(Integer.parseInt(gestationAgeWeeks.get().getVariableValue())));

        artLinelist.setHtsNo(HelperFunctions.returnIdentifiers(8, container).orElse(null));

        Optional<ObsType> initialFirstLineRegimen = HelperFunctions.getInitialRegimenLine(164506,164507,container);
        if(initialFirstLineRegimen.isPresent()) {
            String regimen = getRegimen(initialFirstLineRegimen.get().getValueCoded());
            artLinelist.setInitialFirstLineRegimen(regimen);
        }

        Optional<Date> initialFirstLineRegimenDate = HelperFunctions.getInitialRegimenLineDate(164506,164507,container);
        if(initialFirstLineRegimenDate.isPresent())
            artLinelist.setInitialFirstLineRegimenDate(initialFirstLineRegimenDate.get());

        Optional<ObsType> initialSecondLineRegimen = HelperFunctions.getInitialRegimenLine(164513,164514,container);
        if(initialSecondLineRegimen.isPresent()) {
            String regimen = getRegimen(initialSecondLineRegimen.get().getValueCoded());
            artLinelist.setInitialSecondLineRegimen(regimen);
        }

        Optional<Date> initialSecondLineRegimenDate = HelperFunctions.getInitialRegimenLineDate(164513,164514,container);
        if(initialSecondLineRegimenDate.isPresent())
            artLinelist.setInitialSecondLineRegimenDate(initialSecondLineRegimenDate.get());

        artLinelist.setLastDeliveryDate(artLinelist.getEdd());
        artLinelist.setLastEacDate(HelperFunctions.getMaxEncounterDateTime(69, container));

        Optional<Date> lastINHDispensedDate = HelperFunctions.getLastINHDispensedDate(165727,1679,PharmacyForm,container);
        if(lastINHDispensedDate.isPresent())
            artLinelist.setLastInhDispensedDate(lastINHDispensedDate.get());

        Optional<ObsType> lastQtyofARVrefil = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,1443,container);
        if(lastQtyofARVrefil.isPresent())
            artLinelist.setLastQtyOfArvRefill(BigInteger.valueOf(Integer.parseInt(lastQtyofARVrefil.get().getVariableValue())));

        Optional<ObsType> lastSampleTakenDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,159951,container);
        if(lastSampleTakenDate.isPresent())
            artLinelist.setLastSampleTakenDate(lastSampleTakenDate.get().getValueDatetime());

        artLinelist.setLastViralLoadSampleCollectionFormDate(HelperFunctions.getMaxEncounterDateTime(SampleCollectionForm,container));
        artLinelist.setLgaName(container.getMessageData().getDemographics().getCityVillage());
        artLinelist.setStateName(container.getMessageData().getDemographics().getStateProvince());

        int deathMark = 0;
        deathMark= container.getMessageData().getDemographics().getDead();
        if (deathMark == 1)
            artLinelist.setMarkAsDiseased("Dead");
        else
            artLinelist.setMarkAsDiseased("");

        artLinelist.setMarkAsDiseasedDate(container.getMessageData().getDemographics().getDeathDate());

        Optional<ObsType> mmdType = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166278,container);
        if(mmdType.isPresent())
            artLinelist.setMmdType(mmdType.get().getVariableValue());


        Optional<ObsType> nextOfKinPhoneNo = HelperFunctions.getMaxObsbyConceptID(EnrollmentType,159635,container);
        if(nextOfKinPhoneNo.isPresent())
            artLinelist.setNextOfKinPhoneno(nextOfKinPhoneNo.get().getVariableValue());

        artLinelist.setOtzEnrollmentDate(HelperFunctions.getMaxEncounterDateTime(OTZForm,container));
        Optional<ObsType> otzOutCOmeDate = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166008,container);
        if(otzOutCOmeDate.isPresent())
            artLinelist.setOtzOutcomeDate(otzOutCOmeDate.get().getValueDatetime());

        Optional<ObsType> patientOutCome = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,165470,container);
        if(patientOutCome.isPresent()) {
            artLinelist.setPatientOutcome(patientOutCome.get().getVariableValue());
            artLinelist.setPatientOutcomeDate(patientOutCome.get().getObsDatetime());
        }

        Optional<ObsType> pharmacyNextAppointment = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,5096,container);
        if(pharmacyNextAppointment.isPresent()) {
            artLinelist.setPharmacyNextAppointment(pharmacyNextAppointment.get().getValueDatetime());
        }
        Optional<ObsType> pillBalance = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,166406,container);
        if(pillBalance.isPresent()) {
            artLinelist.setPillBalance(BigInteger.valueOf(Integer.parseInt(pillBalance.get().getVariableValue())));
        }

        Optional<ObsType> pregnancyStatus = HelperFunctions.getMaxObsbyConceptID(PharmacyEncounterType,165050,container);
        if(pregnancyStatus.isPresent()) {
            artLinelist.setPregnancyStatus(pregnancyStatus.get().getVariableValue());
            artLinelist.setPregnancyStatusDate(pregnancyStatus.get().getObsDatetime());
        }

        Optional<ObsType> resultDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,166423,container);
        if(resultDate.isPresent()) {
            artLinelist.setResultDate(resultDate.get().getValueDatetime());
        }

        artLinelist.setSex(container.getMessageData().getDemographics().getGender());

        Optional<ObsType> tbStatus = HelperFunctions.getMaxObsbyConceptID(CareCardEncounterType,1659,container);
        if(tbStatus.isPresent()) {
            artLinelist.setTbStatus(tbStatus.get().getVariableValue());
            artLinelist.setTbStatusDate(tbStatus.get().getObsDatetime());
        }

        Optional<ObsType> treatmentSupporterPhoneNo = HelperFunctions.getMaxObsbyConceptID(EnrollmentType,160642,container);
        if(treatmentSupporterPhoneNo.isPresent()) {
            artLinelist.setTreatmentSupporterPhoneno(treatmentSupporterPhoneNo.get().getVariableValue());
        }

        artLinelist.setValidCapture(HelperFunctions.getValidCapture(container));

        Optional<ObsType> viralLoadEncounterDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,856,container);
        if(viralLoadEncounterDate.isPresent()) {
            artLinelist.setViralLoadEncounterDate(viralLoadEncounterDate.get().getObsDatetime());
        }

        Optional<ObsType> viralLoadIndication = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,164980,container);
        if(viralLoadIndication.isPresent()) {
            artLinelist.setViralLoadIndication(viralLoadIndication.get().getVariableValue());
        }

        Optional<ObsType> viralLoadReportedDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,164980,container);
        if(viralLoadReportedDate.isPresent()) {
            artLinelist.setViralLoadReportedDate(viralLoadReportedDate.get().getValueDatetime());
        }

        Optional<ObsType> viralLoadSampleCollectionDate = HelperFunctions.getMaxObsbyConceptID(LabEncounterType,159951,container);
        if(viralLoadSampleCollectionDate.isPresent()) {
            artLinelist.setViralLoadSampleCollectionDate(viralLoadSampleCollectionDate.get().getValueDatetime());
        }
        return artLinelist;

    }

}
