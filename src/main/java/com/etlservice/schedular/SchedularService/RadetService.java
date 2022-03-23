package com.etlservice.schedular.SchedularService;

import com.etlservice.schedular.database.Dbconfig;
import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.Quarter;
import com.etlservice.schedular.model.Radet;
import com.etlservice.schedular.model.Test;
import com.etlservice.schedular.mongorepo.MongoRepos;
import com.etlservice.schedular.mongorepo.postgres.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RadetService {
    @Autowired
    PostgresRepository postgresRepository;
    @Autowired
    MongoRepos mongoRepos;

   Quarter quarter = new Quarter();


    public void createTest(String  test){
      List<Container> containerList =  mongoRepos.findAll();
        List<Radet> containerListRecord = new ArrayList<>();
        int count = 0;
      for(Container container : containerList) {
          System.out.println("Container: " + container.toString());
          Radet radetRecord  = setupContainer(container);
          containerListRecord.add(radetRecord);
//          postgresRepository.save(radetRecord);
          System.out.println("Count: "+ ++count);
      }
        if(!containerListRecord.isEmpty())
        postgresRepository.saveAll(containerListRecord);

        containerListRecord.clear();
        //createFlatFile();
    }

    public void createCohortAge(){
        List<Radet> radetList = postgresRepository.findRadetsByCurrentAgeYearsBetween(1,4);
        System.out.println("Cohort Size: "+radetList.size());

//        for(Radet radet : radetList){
//            if(radet.getCurrentAgeYears() !=null)
//            System.out.println(radet.getCurrentAgeYears());
//        }
    }
    public void createFlatFile()   {

        try {
            // creating a date object with specified time.
            LocalDate loc = quarter.getQuarterDate();
            Date quarterDate = Date.from(loc.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            //LocalDate today = quarter.convertDate(new Date());
            Date dateOne = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-01");
            Date today = new Date();
            List<Radet> txNew = postgresRepository.findRadetsByArtStartDateBetween(quarterDate, today);
            for (Radet radet : txNew)
                System.out.println("TX_NEW: " + radet.toString());//radet.toString());
        }catch (ParseException p){
            p.printStackTrace();
        }
    }
     private Radet setupContainer(Container container){
         Radet radet = new Radet(container);
         Radet radetContent =new Radet();
//         radetContent.setId("");
         radetContent.setDatimCode(radet.getDatimCode());
         radetContent.setFacilityName(radet.getFacilityName());
         radetContent.setPatientID(radet.getPatientID());
         radetContent.setPatientUniqueID(radet.getPatientUniqueID());
         radetContent.setPatientHospitalNo(radet.getPatientHospitalNo());
         radetContent.setAncNo(radet.getAncNo());
         radetContent.setHtsNo(radet.getHtsNo());
         radetContent.setSex(radet.getSex());
         radetContent.setAgeAtStartOfARTYears(radet.getAgeAtStartOfARTYears());
         radetContent.setAgeAtStartOfARTMonths(radet.getAgeAtStartOfARTMonths());
         radetContent.setCareEntryPoint(radet.getCareEntryPoint());
         radetContent.setKpType(radet.getKpType());
         radetContent.setMonthsOnArt(radet.getMonthsOnArt());
         radetContent.setDateTransferredIn(radet.getDateTransferredIn());
         radetContent.setTransferInStatus(radet.getTransferInStatus());
         radetContent.setArtStartDate(radet.getArtStartDate());
         radetContent.setLastPickupDate(radet.getLastPickupDate());
         radetContent.setLastVisitDate(radet.getLastVisitDate());
         radetContent.setDaysOfARVRefil(radet.getDaysOfARVRefil());
         radetContent.setPillBalance(radet.getPillBalance());
         radetContent.setInitialRegimenLine(radet.getInitialRegimenLine());
         radetContent.setInitialRegimen(radet.getInitialRegimen());
         radetContent.setInitialCd4Count(radet.getInitialCd4Count());
         radetContent.setInitialCd4CountDate(radet.getInitialCd4CountDate());
         radetContent.setCurrentCd4Count(radet.getCurrentCd4Count());
         radetContent.setCurrentCd4CountDate(radet.getCurrentCd4CountDate());
         radetContent.setLastEacDate(radet.getLastEacDate());
         radetContent.setCurrentRegimenLine(radet.getCurrentRegimenLine());
         radetContent.setCurrentRegimen(radet.getCurrentRegimen());
         radetContent.setPregnancyStatus(radet.getPregnancyStatus());
         radetContent.setPregnancyStatusDate(radet.getPregnancyStatusDate());
         radetContent.setEdd(radet.getEdd());
         radetContent.setLastDeliveryDate(radet.getLastDeliveryDate());
         radetContent.setLmp(radet.getLmp());
         radetContent.setEstimatedGestationAgeWeeks(radet.getEstimatedGestationAgeWeeks());
         radetContent.setCurrentViralLoad(radet.getCurrentViralLoad());
         radetContent.setViralLoadEncounterDate(radet.getViralLoadEncounterDate());
         radetContent.setViralLoadSampleCollectionDate(radet.getViralLoadSampleCollectionDate());
         radetContent.setViralLoadReportedDate(radet.getViralLoadReportedDate());
         radetContent.setResultDate(radet.getResultDate());
         radetContent.setAssayDate(radet.getAssayDate());
         radetContent.setApprovalDate(radet.getApprovalDate());
         radetContent.setViralLoadIndication(radet.getViralLoadIndication());
         radetContent.setPatientOutcome(radet.getPatientOutcome());
         radetContent.setPatientOutcomeDate(radet.getPatientOutcomeDate());
         radetContent.setCurrentARTStatus(radet.getCurrentARTStatus());
         radetContent.setDispensingModality(radet.getDispensingModality());
         radetContent.setFacilityDispensingModality(radet.getFacilityDispensingModality());
         radetContent.setDddDispensingModality(radet.getDddDispensingModality());
         radetContent.setMmdType(radet.getMmdType());
         radetContent.setDateReturnedToCare(radet.getDateReturnedToCare());
         radetContent.setDateOfTermination(radet.getDateOfTermination());
//         radetContent.setLastAppointmentDate(radet.getLastAppointmentDate());
         radetContent.setPharmacyNextAppointment(radet.getPharmacyNextAppointment());
         radetContent.setClinicalNextAppointment(radet.getClinicalNextAppointment());
         radetContent.setCurrentAgeYears(radet.getCurrentAgeYears());
         radetContent.setCurrentAgeMonths(radet.getCurrentAgeMonths());
         radetContent.setDateOfBirth(radet.getDateOfBirth());
         radetContent.setMarkAsDeseased(radet.getMarkAsDeseased());
         radetContent.setMarkAsDeseasedDeathDate(radet.getMarkAsDeseasedDeathDate());
         radetContent.setNextOfkinPhoneNo(radet.getNextOfkinPhoneNo());
         radetContent.setTreatmentSupporterPhoneNo(radet.getTreatmentSupporterPhoneNo());
         radetContent.setBiometricCaptured(radet.getBiometricCaptured());
         radetContent.setBiometricCapturedDate(radet.getBiometricCapturedDate());
         radetContent.setValidCapture(radet.getValidCapture());
         radetContent.setCurrentWeight(radet.getCurrentWeight());
         radetContent.setCurrentWeightDate(radet.getCurrentWeightDate());
         radetContent.setTbStatus(radet.getTbStatus());
         radetContent.setTbStatusDate(radet.getTbStatusDate());
         radetContent.setInhStartDate(radet.getInhStartDate());
         radetContent.setInhStopDate(radet.getInhStopDate());
         radetContent.setLastINHDispensedDate(radet.getLastINHDispensedDate());
         radetContent.setTbTreatmentStartDate(radet.getTbTreatmentStartDate());
         radetContent.setTbTreatmentStopDate(radet.getTbTreatmentStopDate());
         radetContent.setLastViralLoadSampleCollectionFormDate(radet.getLastViralLoadSampleCollectionFormDate());
         radetContent.setLastSampleTakenDate(radet.getLastSampleTakenDate());
         radetContent.setOtzEnrollmentDate(radet.getOtzEnrollmentDate());
         radetContent.setOtzOutcomeDate(radet.getOtzOutcomeDate());
         radetContent.setEnrollmentDate(radet.getEnrollmentDate());
         radetContent.setInitialFirstLineRegimen(radet.getInitialFirstLineRegimen());
         radetContent.setInitialFirstLineRegimenDate(radet.getInitialFirstLineRegimenDate());
         radetContent.setInitialSecondLineRegimen(radet.getInitialSecondLineRegimen());
         radetContent.setInitialFirstLineRegimenDate(radet.getInitialSecondLineRegimenDate());
         radetContent.setTouchTime(radet.getTouchTime());
         radetContent.setPatientUuid(radet.getPatientUuid());
        return  radetContent;
     }
}
