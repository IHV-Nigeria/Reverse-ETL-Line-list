/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.SchedularService;

import com.etlservice.schedular.model.Cohort;
import com.etlservice.schedular.entities.Facility;
import com.etlservice.schedular.model.FlatFile;
import com.etlservice.schedular.model.Radet;
import com.etlservice.schedular.mongorepo.postgres.CohortRepository;
import com.etlservice.schedular.mongorepo.postgres.FacilityRepository;
import com.etlservice.schedular.mongorepo.postgres.FlatFileRepository;
import com.etlservice.schedular.mongorepo.postgres.PostgresRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static com.etlservice.schedular.model.Cohort.intersect;
import static com.etlservice.schedular.model.Cohort.minus;
import static com.etlservice.schedular.model.Cohort.union;


/**
 *
 * @author The Bright
 */
@Service
public class CohortService {

    @Autowired
    PostgresRepository postgresRepository;

    @Autowired
    CohortRepository cohortRepository;

    @Autowired
    FlatFileRepository flatFileRepository;

    @Autowired
    FacilityRepository facilityRepository;

    Radet radet = new Radet();


    void saveCohort(List<FlatFile> cohortList){
        flatFileRepository.saveAll(cohortList);
    }
    public Cohort createCohortAge(int ageStart, int ageStop, String name, String desc){

        List<Radet> radetList = postgresRepository.findRadetsByCurrentAgeYearsBetween(ageStart,ageStop);
        Cohort cohort = new Cohort();
        cohort.setCohortName(name);
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription(desc);
        cohort.setDatimCode(radetList.get(0).getDatimCode());
       // cohortRepository.save(cohort);
        return  cohort;
    }
    public Cohort createCohortAge(int age, String name, String desc){
        List<Radet> radetList = postgresRepository.findRadetsByCurrentAgeYearsGreaterThanEqual(age);
        Cohort cohort = new Cohort();
        cohort.setCohortName(name);
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription(desc);
        cohort.setDatimCode(radetList.get(0).getDatimCode());
       // cohortRepository.save(cohort);
        return  cohort;
    }
    public Cohort createCohortAgeLessThan(int age, String name, String desc){
        List<Radet> radetList = postgresRepository.findRadetsByCurrentAgeYearsLessThan(age);
        Cohort cohort = new Cohort();
        cohort.setCohortName(name);
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription(desc);
        cohort.setDatimCode(radetList.get(0).getDatimCode());
       // cohortRepository.save(cohort);
        return  cohort;
    }

    public Cohort createCohortStatus(String status, String name, String desc){
        List<Radet> radetList = postgresRepository.findRadetsByPatientOutcomeEquals(status);
        Cohort cohort = new Cohort();
        cohort.setCohortName(name);
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription(desc);
        cohort.setDatimCode(radetList.get(0).getDatimCode());
      //  cohortRepository.save(cohort);
        return cohort;
    }

    public Cohort createCohortArtStart( Date end){
        LocalDate endDate = radet.convertDate(end);
        Date start = null;
        System.out.println("date: "+endDate.getYear());
        Month month = endDate.getMonth();
        if(month == Month.JANUARY || month == Month.FEBRUARY || month == Month.MARCH  ){
           // start =  new GregorianCalendar(endDate.getYear(), Calendar.JANUARY, 1).getTime();
            start =  new GregorianCalendar(endDate.getYear(), Calendar.OCTOBER, 1).getTime();
        }
        else if(month == Month.APRIL || month == Month.MAY || month == Month.JUNE  ){
            start =  new GregorianCalendar(endDate.getYear(), Calendar.APRIL, 1).getTime();
        }

        else if(month == Month.JULY || month == Month.AUGUST || month == Month.SEPTEMBER  ){
            start =  new GregorianCalendar(endDate.getYear(), Calendar.JULY, 1).getTime();
        }

        else if(month == Month.OCTOBER || month == Month.NOVEMBER || month == Month.DECEMBER  ){
            start =  new GregorianCalendar(endDate.getYear(), Calendar.OCTOBER, 1).getTime();
        }

        List<Radet> radetList = postgresRepository.findRadetsByArtStartDateBetween(start, end);
        Cohort cohort = new Cohort();
        cohort.setCohortName("ART Start");
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription("art_start_date between start_date and end_date");

        //cohortRepository.save(cohort);
        return  cohort;
    }

    public Cohort createCohortTransfferredIn(){
        List<Radet> radetList = postgresRepository.findRadetsByCareEntryPointEquals("Transfer in");
        Cohort cohort = new Cohort();
        cohort.setCohortName("Transferred in");
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription("Transferred in");
        cohort.setDatimCode(radetList.get(0).getDatimCode());
        //cohortRepository.save(cohort);
        return  cohort;
    }
    public Cohort createCohortReturnToCare(){
        List<Radet> radetList = postgresRepository.findRadetsByDateReturnedToCareIsNotNull();
        Cohort cohort = new Cohort();
        cohort.setCohortName("Date Return To Care");
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription("Date Return To Care");
        cohort.setDatimCode(radetList.get(0).getDatimCode());
        //cohortRepository.save(cohort);
        return  cohort;
    }

    public Cohort createCohortTXNew(){
        Cohort tx_new = minus(createCohortArtStart(new Date()),createCohortTransfferredIn(),"TX_New");
        //cohortRepository.save(tx_new);
        return  tx_new;
    }

    public FlatFile createCohortTXNewMale1to4(){
        Cohort tx_newMale1to4 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge1to4(),"TX_NEW MALE 1-4");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","jjUGfPF0ObP","1-4, Male, Positive","ARBAaiIB2ay",tx_newMale1to4);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale5to9(){
        Cohort tx_newMmale5to9 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge5to9(),"TX_NEW MALE 5-9");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","p1HABZs9ydt","5-9, Male, Positive","ARBAaiIB2ay",tx_newMmale5to9);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale10to14(){
        Cohort tx_newMale10to14 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge10to14(),"TX_NEW MALE 10-14");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","tEMe0224zlP","10-14, Male, Positive","ARBAaiIB2ay",tx_newMale10to14);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale15to19(){
        Cohort tx_newMale15to19 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge15to19(),"TX_NEW MALE 15-19");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","LpnJL4zZxRH","15-19, Male, Positive","ARBAaiIB2ay",tx_newMale15to19);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale20to24(){
        Cohort tx_newMale20to24 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge20to24(),"TX_NEW MALE 20-24");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","NCnIv37EwU1","20-24, Male, Positive","ARBAaiIB2ay",tx_newMale20to24);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale25to29(){
        Cohort tx_newMale25to29 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge25to29(),"TX_NEW MALE 25-29");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","y9LP85d8t4b","25-29, Male, Positive","ARBAaiIB2ay",tx_newMale25to29);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale30to34(){
        Cohort tx_newMale30to34 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge30to34(),"TX_NEW MALE 30-34");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","YDzeLL6xf5o","30-34, Male, Positive","ARBAaiIB2ay",tx_newMale30to34);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale35to39(){
        Cohort tx_newMale35to39 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge35to39(),"TX_NEW MALE 35-39");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","XcW5HWccYYZ","35-39, Male, Positive","ARBAaiIB2ay",tx_newMale35to39);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale40to44(){
        Cohort tx_newMale40to44 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge40to44(),"TX_NEW MALE 40-44");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","zouTxRQ0kXP","40-44, Male, Positive","ARBAaiIB2ay",tx_newMale40to44);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale45to49(){
        Cohort tx_newMale45to49 = intersect(createCohortTXNew(),createCohortMale(),createCohortAge45to49(),"TX_NEW MALE 45-49");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","zUjkTTlva36","45-49, Male, Positive","ARBAaiIB2ay",tx_newMale45to49);
        return flatFile;
    }

    public FlatFile createCohortTXNewMale50Plus(){
        Cohort tx_newMale50Plus = intersect(createCohortTXNew(),createCohortMale(),createCohortAge45to49(),"TX_NEW MALE 50+");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","QwUdNwRA8Uc","50+, Male, Positive","ARBAaiIB2ay",tx_newMale50Plus);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale1to4(){
        Cohort tx_newFemale1to4 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge1to4(),"TX_NEW FEMALE 1-4");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","dRjezxQktoz","1-4, Female, Positive","ARBAaiIB2ay",tx_newFemale1to4);
        return flatFile;
    }

    private FlatFile flatFileProcessing(String dataElement,String dataElementName,String categoryOptionCombo,String categoryOptionComboName,String attributeOptionCombo,Cohort cohort){
        FlatFile flatFile = new FlatFile();
        flatFile.setDataElement(dataElement);
        flatFile.setDataElementName(dataElementName);
        flatFile.setPeriod(ageProcessing(new Date()));
        flatFile.setCategoryOptionCombo(categoryOptionCombo);
        flatFile.setCategoryOptionComboName(categoryOptionComboName);
        flatFile.setAttributeOptionCombo(attributeOptionCombo);
        flatFile.setValue(cohort.getMemberPatients().size()+"");
        flatFile.setImplementingPartnerName("IHVN");
        flatFile.setOrgUnit(cohort.getDatimCode());
        Facility facility = facilityRepository.findFacilityByDatimCode(cohort.getDatimCode());
        if(facility != null) {
            flatFile.setOrgUnitName(facility.getFacilityName());
            flatFile.setStateName(facility.getState().getStateName());
            flatFile.setLgaName(facility.getLga().getLga());
        }
        return flatFile;
    }
    private String ageProcessing(Date date){
        LocalDate endDate = radet.convertDate(date);
        Month month = endDate.getMonth();
        String quarter = "";

        if(month == Month.JANUARY || month == Month.FEBRUARY || month == Month.MARCH  ){
            quarter = "Q1";
        }
        else if(month == Month.APRIL || month == Month.MAY || month == Month.JUNE  ){
            quarter = "Q2";
        }

        else if(month == Month.JULY || month == Month.AUGUST || month == Month.SEPTEMBER  ){
            quarter = "Q3";
        }

        else if(month == Month.OCTOBER || month == Month.NOVEMBER || month == Month.DECEMBER  ){
            quarter = "Q4";
        }

        return endDate.getYear()+quarter;
    }

    public FlatFile createCohortTXNewFemale5to9(){
        Cohort tx_newFemale5to9 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge5to9(),"TX_NEW FEMALE 5-9");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","zLbjm4E1NsG","5-9, Female, Positive","ARBAaiIB2ay",tx_newFemale5to9);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale10to14(){
        Cohort tx_newFemale10to14 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge10to14(),"TX_NEW FEMALE 10-14");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","AG0milXShQM","10-14, Female, Positive","ARBAaiIB2ay",tx_newFemale10to14);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale15to19(){
        Cohort tx_newFemale15to19 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge15to19(),"TX_NEW FEMALE 15-19");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","QqlHrg6f0Sm","15-19, Female, Positive","ARBAaiIB2ay",tx_newFemale15to19);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale20to24(){
        Cohort tx_newFemale20to24 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge20to24(),"TX_NEW FEMALE 20-24");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","LyXZybq6Sjf","20-24, Female, Positive","ARBAaiIB2ay",tx_newFemale20to24);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale25to29(){
        Cohort tx_newFemale25to29 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge25to29(),"TX_NEW FEMALE 25-29");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","zqARzn2wVj5","25-29, Female, Positive","ARBAaiIB2ay",tx_newFemale25to29);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale30to34(){
        Cohort tx_newFemale30to34 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge30to34(),"TX_NEW FEMALE 30-34");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","Vi8sd7mvZW4","30-34, Female, Positive","ARBAaiIB2ay",tx_newFemale30to34);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale35to39(){
        Cohort tx_newFemale35to39 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge35to39(),"TX_NEW FEMALE 35-39");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","hRq4baaUamW","35-39, Female, Positive","ARBAaiIB2ay",tx_newFemale35to39);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale40to44(){
        Cohort tx_newFemale40to44 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge40to44(),"TX_NEW FEMALE 40-44");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","PEXIFVXGP9S","40-44, Female, Positive","ARBAaiIB2ay",tx_newFemale40to44);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale45to49(){
        Cohort tx_newFemale45to49 = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge45to49(),"TX_NEW FEMALE 45-49");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","J8fGj3Iefbc","45-49, Female, Positive","ARBAaiIB2ay",tx_newFemale45to49);
        return flatFile;
    }

    public FlatFile createCohortTXNewFemale50Plus(){
        Cohort tx_newFemale50Plus = intersect(createCohortTXNew(),createCohortFemale(),createCohortAge50plus(),"TX_NEW FEMALE 50+");
        FlatFile flatFile = flatFileProcessing("yXZtvoYQXcD","TX_NEW (N, DSD, Age/Sex/HIVStatus): New on ART","lR2zeQ9VfB8","50+, Female, Positive","ARBAaiIB2ay",tx_newFemale50Plus);
        return flatFile;
    }

    public Cohort createCohortTExit(){
        Cohort exit = union(createCohortDeadPatients(),createCohortTransferredOut(),createCohortStoppedTreatment(),"Exit");
        return exit;
    }

    public Cohort createCohortDeadPatients(){
        Cohort deadPatients = createCohortStatus("Death","Dead Patients","Dead Patients");
        return  deadPatients;
    }
    public Cohort createCohortTransferredOut(){
        Cohort transfferedOut = createCohortStatus("Transffered out","Transffered out","Transffered out Patients");
        return transfferedOut;
    }
    public Cohort createCohortStoppedTreatment(){
        Cohort stoppedTreatment = createCohortStatus("Stopped","Stopped Treatment","Stopped Treatment patients");
        return stoppedTreatment;
    }
    public Cohort createCohortAgeLessThan1(){
        Cohort ageLessThan1 = createCohortAgeLessThan(1,"Age <1","Number of patients age Less than 1");
        return ageLessThan1;
    }
    public Cohort createCohortAge1to4(){
        Cohort cohort = createCohortAge(1,4,"Age 1-4","Number of patients age 1 to 4");
        return cohort;
    }
    public Cohort createCohortAge5to9(){
        Cohort age5to9 = createCohortAge(5,9, "Age 5-9","Number of patients age 5 to 9");
        return age5to9;
    }

    public Cohort createCohortAge10to14(){
        Cohort age10to14 = createCohortAge(10,14,"Age 10-14","Number of patients age 10 to 14");
        return age10to14;
    }

    public Cohort createCohortAge15to19(){
        Cohort age15to19 = createCohortAge(15,19,"Age 15-19","Number of patients age 15 to 19");
        return age15to19;
    }
    public Cohort createCohortAge20to24(){
        Cohort age20to24 = createCohortAge(20,24,"Age 20-24","Number of patients age 20 to 24");
        return age20to24;
    }

    public Cohort createCohortAge25to29(){
        Cohort age25to29 = createCohortAge(25,29,"Age 25-29","Number of patients age 25 to 29");
        return age25to29;
    }

    public Cohort createCohortAge30to34(){
        Cohort age30to34 = createCohortAge(30,34,"Age 30-34","Number of patients age 30 to 34");
        return age30to34;
    }

    public Cohort createCohortAge35to39(){
        Cohort age35to39 = createCohortAge(35,39,"Age 35-39","Number of patients age 35 to 39");
        return age35to39;
    }

    public Cohort createCohortAge40to44(){
        Cohort age40to44 = createCohortAge(40,44,"Age 40-44","Number of patients age 40 to 44");
        return age40to44;
    }

    public Cohort createCohortAge45to49(){
        Cohort age45to49 = createCohortAge(45,49,"Age 45-49","Number of patients age 45 to 49");
        return age45to49;
    }
    public Cohort createCohortAge50plus(){
        Cohort age50plus = createCohortAge(50,"Age 50+","Number of patients age 50+");
        return age50plus;
    }

    public Cohort createCohortAge15plus(){
        Cohort age15Plus =  createCohortAge(15,"Age 15+","Number of patients age 15+");
        return age15Plus;
    }
    public Cohort createCohortFemale(){
        List<Radet> radetList = postgresRepository.findRadetsBySexEquals("F");
        System.out.println("Female size: "+radetList.size());
        Cohort cohort = new Cohort();
        cohort.setCohortName("F");
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription("Number of female patients");
        cohort.setDatimCode(radetList.get(0).getDatimCode());
        //cohortRepository.save(cohort);
        return  cohort;
    }

    public Cohort createCohortMale(){
        List<Radet> radetList = postgresRepository.findRadetsBySexEquals("M");
        System.out.println("Male size: "+radetList.size());
        Cohort cohort = new Cohort();
        cohort.setCohortName("M");
        cohort.setMemberPatients(radetList);
        cohort.setCohortDescription("Number of male patients");
        //cohortRepository.save(cohort);
        return  cohort;
    }

    public Cohort buildAgeCohort(int ageStart, int ageStop, String cohortName){
        Set<Integer> agePatientSet=Sets.newHashSet(2,3,4,5,6,7,8,9,10);// This is the result of a query
        String sql_text="select radet.patient_id from radet where radet.age BETWEEN ? AND ?";
        Cohort c=Cohort.createCohort(agePatientSet, cohortName);
        return c;
    }
    public Cohort buildARTStartCohort(String startDate, String endDate){
        Set<Integer> agePatientSet=Sets.newHashSet(2,3,4,5,11,12,13);// This is the result of a query
        String sql_text="select radet.patient_id from radet where radet.art_start_date BETWEEN ? AND ?";
        Cohort c=Cohort.createCohort(agePatientSet, "ART_START");
        return c;
    }
    
    public Cohort buildGenderCohort(String gender){
        Set<Integer> genderPatientSet=Sets.newHashSet(2,3,4,5,11,12,13);// This is the result of a query
        String sql_text="select radet.patient_id from radet where radet.art_start_date BETWEEN ? AND ?";
        Cohort c=Cohort.createCohort(genderPatientSet, gender);
        return c;
    }
}
