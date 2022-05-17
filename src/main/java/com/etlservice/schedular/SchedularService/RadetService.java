package com.etlservice.schedular.SchedularService;


import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.Quarter;
import com.etlservice.schedular.model.Radet;
import com.etlservice.schedular.mongorepo.MongoRepos;
import com.etlservice.schedular.mongorepo.postgres.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RadetService {
    int PAGE = 0;
    int SIZE = 1000;
    @Autowired
    PostgresRepository postgresRepository;
    @Autowired
    MongoRepos mongoRepos;

   Quarter quarter = new Quarter();

   // @Scheduled(fixedDelay = 2000L, initialDelay = 2000L)
    public void createTest(){
//    AtomicInteger count = new AtomicInteger();

        Pageable pageRequest = PageRequest.of(PAGE, SIZE);
        Page<Container> onePage = mongoRepos.findAll(pageRequest);

        while (!onePage.isEmpty()) {
            pageRequest = pageRequest.next();

            createRadetRecord(onePage.toList());
            //DO SOMETHING WITH ENTITIES
//            onePage.forEach(entity ->
//                    //System.out.println(count.incrementAndGet())
//                    System.out.println(entity.getId())
//            );

            onePage = mongoRepos.findAll(pageRequest);
        }

    }

    private void createRadetRecord(List<Container> containerList){
      if(!containerList.isEmpty()) {
          List<Radet> containerListRecord = new ArrayList<>();
          for (Container container : containerList) {
              Radet radetRecord = setupContainer(container);
              containerListRecord.add(radetRecord);
          }
          if (!containerListRecord.isEmpty())
              postgresRepository.saveAll(containerListRecord);

          containerListRecord.clear();
      }
    }


     private Radet setupContainer(Container container){
         Radet radet = new Radet(container);
         Radet radetContent =new Radet();
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
