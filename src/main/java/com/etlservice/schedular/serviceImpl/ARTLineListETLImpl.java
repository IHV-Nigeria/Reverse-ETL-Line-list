/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.serviceImpl;

import com.etlservice.schedular.entities.ArtLinelist;
import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.ObsType;
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

        artLineListRepository.saveAll(allArtLine);
    }

    private ArtLinelist mapARTLineList(Container container) {

        ArtLinelist artLinelist = new ArtLinelist();
        artLinelist.setDatimCode(container.getMessageHeader().getFacilityDatimCode());
        artLinelist.setFacilityName(container.getMessageHeader().getFacilityName());
        artLinelist.setPatientId(BigInteger.valueOf(container.getMessageData().getDemographics().getPatientId()));
        artLinelist.setPatientUuid(container.getMessageData().getDemographics().getPatientUuid());
        artLinelist.setPatientUniqueId(HelperFunctions.returnIdentifiers(4, container).orElse(null));
        artLinelist.setPatientHospitalNo(HelperFunctions.returnIdentifiers(5, container).orElse(null));
        artLinelist.setSex(container.getMessageData().getDemographics().getGender());

        if (HelperFunctions.getAgeAtStartOfARTYears(container) != null) {
            artLinelist.setAgeAtStartOfArtYears(BigInteger.valueOf(HelperFunctions.getAgeAtStartOfARTYears(container)));
            artLinelist.setAgeAtStartOfArtMonths(BigInteger.valueOf(HelperFunctions.getAgeAtStartOfARTMonths(container)));
        }
        artLinelist.setCareEntryPoints(HelperFunctions.getObsbyConceptID(160540, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setKpType(HelperFunctions.getObsbyConceptID(166369, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setMonthsOnArt(HelperFunctions.getMonthsOnArt(container));
        artLinelist.setDateTransferredIn(HelperFunctions.getObsbyConceptID(160534, container).map(ObsType::getValueDatetime).orElse(null));
        artLinelist.setTransferInStatus(HelperFunctions.getObsbyConceptID(165242, container).map(ObsType::getVariableValue).orElse(null));
        artLinelist.setArtStartDate(HelperFunctions.getArtStartDate(container));
        artLinelist.setLastPickupDate(HelperFunctions.getMaxEncounterDateTime(27, container));
        artLinelist.setLastVisitDate(HelperFunctions.getMaxVisitDate(container).map(x -> x).orElse(null));
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
            artLinelist.setInitialRegimen(initialRegOpt.map(ObsType::getVariableValue).get());
        }

        Optional<ObsType> initialCd4Opt = HelperFunctions.getMinObsbyConceptID(ConstantsUtils.LabEncounterType, 5497, container);

        if (initialCd4Opt.isPresent()) {
            artLinelist.setInitialCd4Count(initialCd4Opt.map(ObsType::getValueNumeric).get().toBigInteger());
            artLinelist.setInitialCd4CountDate(initialCd4Opt.map(ObsType::getObsDatetime).get());
        }

        Optional<ObsType> currentCd4Opt = HelperFunctions.getMaxObsbyConceptID(ConstantsUtils.LabEncounterType, 5497, container);
        if (currentCd4Opt.isPresent()) {
            artLinelist.setCurrentCd4Count(currentCd4Opt.map(ObsType::getValueNumeric).get().toBigInteger());
            artLinelist.setCurrentCd4CountDate(currentCd4Opt.map(ObsType::getObsDatetime).get());
        }

        Optional<ObsType> currentRegOpt = HelperFunctions.getMaxObsbyConceptID(ConstantsUtils.PharmacyEncounterType, 165708, container);

        if (currentRegOpt.isPresent()) {
            artLinelist.setCurrentRegimen(currentRegOpt.map(ObsType::getVariableValue).get());
        }

        return artLinelist;

    }

}
