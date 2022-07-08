/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.utils;

import com.etlservice.schedular.model.*;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static com.etlservice.schedular.utils.ConstantsUtils.PharmacyEncounterType;

/**
 *
 * @author MORRISON.I
 */
public class HelperFunctions {
    
    public static Optional<String> returnIdentifiers(int idType, Container container) {
        
        return container.getMessageData().getPatientIdentifiers()
                .stream()
                .filter(a -> a.getIdentifierType() == idType)
                .map(PatientIdentifierType::getIdentifier)
                .findAny();
        
    }
    
    public static Integer getAgeAtStartOfARTYears(Container container) {
        
        Integer ageAtStartOfARTYears = null;
        try {
            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();

//        LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
            LocalDate start = convertDate(birthDate);
            //System.out.println("Date: "+start.);
            Date artStartDate = null;
            
            Optional<Date> findAny = radetContainer.getMessageData().getObs()
                    .stream()
                    .filter(a -> a.getConceptId() == 159599)
                    .map(ObsType::getValueDatetime)
                    .findAny();
            if (findAny.isPresent()) {
                artStartDate = findAny.get();
                //LocalDate stop = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
                LocalDate stop = convertDate(artStartDate);
                long years = ChronoUnit.YEARS.between(start, stop);
             //   System.out.println("start: " + start + " | stop: " + stop + " | years: " + years);
                ageAtStartOfARTYears = (int) years;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ageAtStartOfARTYears;
    }
    
    public static Integer getAgeAtStartOfARTMonths(Container container) {
        
        Integer ageAtStartOfARTYears = null;
        try {
            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();

//        LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
            LocalDate start = convertDate(birthDate);
            //System.out.println("Date: "+start.);
            Date artStartDate = null;
            
            Optional<Date> findAny = radetContainer.getMessageData().getObs()
                    .stream()
                    .filter(a -> a.getConceptId() == 159599)
                    .map(ObsType::getValueDatetime)
                    .findAny();
            if (findAny.isPresent()) {
                artStartDate = findAny.get();
                //LocalDate stop = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
                LocalDate stop = convertDate(artStartDate);
                long months = ChronoUnit.MONTHS.between(start, stop);
                
                ageAtStartOfARTYears = (int) months;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ageAtStartOfARTYears;
    }
    
    public static LocalDate convertDate(Date date) {
        
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();
        
        return localDate;
    }
    
    public static Optional<ObsType> getObsbyConceptID(int conceptId, Container container) {
        
        return container.getMessageData().getObs()
                .stream().filter(a -> a.getConceptId() == conceptId)
                .findAny();
        
    }
    
    public static BigInteger getMonthsOnArt(Container container, Date lastPickupDate) {
        
        BigInteger monthsOnArt = null;
        
        try {
            Date artStartDate = getArtStartDate(container);
            Date today = new Date();

            //LocalDate start = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
            if (artStartDate != null) {
                LocalDate start = convertDate(artStartDate);
                //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
                LocalDate stop = convertDate(lastPickupDate);
                long months = ChronoUnit.MONTHS.between(start, stop);
                monthsOnArt = BigInteger.valueOf(months);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthsOnArt;
    }
    
    public static Date getArtStartDate(Container container) {
        
        return container.getMessageData().getObs().stream()
                .filter(a -> a.getConceptId() == 159599)
                .map(ObsType::getValueDatetime)
                .findAny().orElse(null);
        
    }
    
    public static Date getMaxEncounterDateTime(int forimID, Container container) {
        Date encounterDate = null;
        try {
            Container radetContainer = container;
            List<EncounterType> obsTypeList = radetContainer.getMessageData().getEncounters();
            List<Date> lastPickupDateList = new ArrayList();
            for (EncounterType encounterType : obsTypeList) {
                if (encounterType.getFormId() == forimID) {
                    lastPickupDateList.add(encounterType.getEncounterDatetime());
                }
            }
            if (!lastPickupDateList.isEmpty()) {
                encounterDate = Collections.max(lastPickupDateList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encounterDate;
    }

    public static Optional<Date> getMinEncounterDateTime(int forimID, Container container) {
        Date encounterDate = null;
        try {
            List<EncounterType> obsTypeList = container.getMessageData().getEncounters();
            List<Date> firstDateList = new ArrayList<>();
            for (EncounterType encounterType : obsTypeList) {
                if (encounterType.getFormId() == forimID) {
                    firstDateList.add(encounterType.getEncounterDatetime());
                }
            }
            if (!firstDateList.isEmpty()) {
                encounterDate = Collections.min(firstDateList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(encounterDate);
    }


    
    public static Optional<Date> getMaxVisitDate(Container container) {
        Date lastVisitDate = null;
        try {

            List<EncounterType> obsTypeList = container.getMessageData().getEncounters();
            List<Date> lastVisitDateList = new ArrayList<>();
            for (EncounterType encounterType : obsTypeList) {
                lastVisitDateList.add(encounterType.getEncounterDatetime());
            }
            lastVisitDate = Collections.max(lastVisitDateList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(lastVisitDate);
                
        
    }
    
    public static Optional<ObsType> getMaxObsbyConceptID(int enconterTypeId,int conceptId, Container container) {
        
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == enconterTypeId)
                .filter(b -> b.getConceptId()==conceptId)
                .max(Comparator.comparing(ObsType::getDateCreated));
        
    }


  public static Optional<ObsType> getMinObsbyConceptID(int enconterTypeId,int conceptId, Container container) {
        
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == enconterTypeId)
                .filter(b -> b.getConceptId()==conceptId)
                .min(Comparator.comparing(ObsType::getDateCreated));
        
    }

    public static BigInteger getCurrentAge(Container container, String type) {
        BigInteger currentAge =null;
        long years,months;
        try {

            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();

            Date today = new Date();

            LocalDate start = convertDate(birthDate);
            //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
            LocalDate stop = convertDate(today);
            if(type.equals("YEARS")) {
                years = ChronoUnit.YEARS.between(start, stop);
                currentAge =BigInteger.valueOf(years);
            }
            else {
                months = ChronoUnit.MONTHS.between(start, stop);
                currentAge =BigInteger.valueOf(months);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return currentAge;
    }

    public static String getCurrentARTStatus(Date lastPickupDate, BigInteger daysOfARVRefil, Date dateOfTermination, Date dateReturnToCare) {
        String currentARTStatus = null;
        try {
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(lastPickupDate);
            //int daysOfArvRefill = daysOfARVRefil;
            cal.add(Calendar.DAY_OF_MONTH, (daysOfARVRefil.intValue() + 28));
            //cal.add(Calendar.DATE, (Integer.parseInt(getDaysOfARVRefil() + 28)));

            //Date terminationDate = dateOfTermination;
            // Optional.ofNullable(getDateOfTermination()).orElse(null);
            //Date returnTOCare = dateReturnToCare;
            //Optional.ofNullable(getDateReturnedToCare()).orElse(null);
            if (dateReturnToCare != null && dateOfTermination != null) {
                if (dateReturnToCare.compareTo(dateOfTermination) > 0) {
                    //        if(today.compareTo(cal.getTime()) > 0) {
                    if (cal.getTime().compareTo(today) > 0) {
                        currentARTStatus = "Active";
                        System.out.println("Date 1 occurs after Date 2");
                    } else
                        currentARTStatus = "InActive";
                }
            } else if (dateReturnToCare == null && dateOfTermination != null) {
                currentARTStatus = "InActive";
            } else if (dateReturnToCare == null && dateOfTermination == null) {
                if (cal.getTime().compareTo(today) > 0) {
                    currentARTStatus = "Active";
                    System.out.println("Date 1 occurs after Date 2");
                } else
                    currentARTStatus = "InActive";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return currentARTStatus;
    }

    public static String getBiometricCaptured(Container container) {
        String biometricCaptured = null;
        try {
            Container radetContainer = container;
            if (radetContainer.getMessageData().getPatientBiometrics() != null && radetContainer.getMessageData().getPatientBiometrics().size() > 0) {
                biometricCaptured = "Yes";
            } else
                biometricCaptured = "No";
        }catch (Exception e){
            e.printStackTrace();
        }
        return biometricCaptured;
    }

    public static Date getBiometricCapturedDate(Container container) {
        Date biometricCapturedDate = null;
        try{
            Container radetContainer = container;
            if (radetContainer.getMessageData().getPatientBiometrics().size() > 0)
                biometricCapturedDate = radetContainer.getMessageData().getPatientBiometrics().get(0).getDateCreated();
        }catch (Exception e){
            e.printStackTrace();
        }
        return biometricCapturedDate;
    }

    public static Optional<ObsType> getInitialRegimenLine(int adultConceptID, int childConceptId, Container container) {
//        String InitialRegimenLine = null;
        ObsType obs = null;
        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> InitialFirstLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> InitialFirstLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == adultConceptID && obsType.getFormId() == 27) || (obsType.getConceptId() == childConceptId && obsType.getFormId() == 27))
                    InitialFirstLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date InitialFirstLineRegimenDate : InitialFirstLineRegimenMap.keySet()) {
                InitialFirstLineRegimenDateList.add(InitialFirstLineRegimenDate);
            }
            if (!InitialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(InitialFirstLineRegimenDateList);
//                InitialRegimenLine = InitialFirstLineRegimenMap.get(latestDate).getVariableValue();
                obs = InitialFirstLineRegimenMap.get(latestDate);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        return Optional.ofNullable(InitialRegimenLine);
        return Optional.ofNullable(obs);
    }

    public static Optional<Date> getInitialRegimenLineDate(int adultConceptID, int childConceptId, Container container) {
        Date InitialRegimenLineDate = null;
        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> InitialFirstLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> InitialFirstLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == adultConceptID && obsType.getFormId() == 27) || (obsType.getConceptId() == adultConceptID && obsType.getFormId() == 27))
                    InitialFirstLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date InitialFirstLineRegimenDate : InitialFirstLineRegimenMap.keySet()) {
                InitialFirstLineRegimenDateList.add(InitialFirstLineRegimenDate);
            }
            if (!InitialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(InitialFirstLineRegimenDateList);
                InitialRegimenLineDate = InitialFirstLineRegimenMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(InitialRegimenLineDate);
    }

    public static Optional<Date> getLastINHDispensedDate(int conceptId, int valueCoded,int formID, Container container) {
        Date lastINHDispenseDate = null;
        try {
            Container radetContainer = container;
            List<ObsType> lastINHDispensedDateList = radetContainer.getMessageData().getObs();
            List<Date> tbStatusDateList = new ArrayList();
            Map<Date, ObsType> lastINHDispensedDateMap = new HashMap<>();

            for (ObsType obsType : lastINHDispensedDateList) {
                if (obsType.getConceptId() == conceptId && obsType.getFormId() == formID && obsType.getValueCoded() == valueCoded)
                    lastINHDispensedDateMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date lastINHDispensedDate : lastINHDispensedDateMap.keySet()) {
                tbStatusDateList.add(lastINHDispensedDate);
            }
            if (!tbStatusDateList.isEmpty()) {
                Date latestDate = Collections.max(tbStatusDateList);
                lastINHDispenseDate = lastINHDispensedDateMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(lastINHDispenseDate);
    }


    public static String getValidCapture(Container container) {
        String validCapture = null;
        try {
            Container radetContainer = container;
            List<PatientBiometricType> patientBiometricTypeList = radetContainer.getMessageData().getPatientBiometrics();
            for (PatientBiometricType patientBiometricType : patientBiometricTypeList) {
                if (patientBiometricType.getTemplate().startsWith("Rk1S"))
                    validCapture = "Yes";
                else {
                    validCapture = "No";
                    break;
                }
            }
            if (radetContainer.getMessageData().getPatientBiometrics().size() == 0)
                validCapture = "No";
        }catch (Exception e){
            e.printStackTrace();
        }
        return validCapture;
    }

    public static void preeviousQuarter(Date today){

        List<String> Q1 = Arrays.asList("OCT","NOV","DEC");
        List<String> Q2 = Arrays.asList("JAN","FEB","MAR");
        List<String> Q3 = Arrays.asList("APR","MAY","JUN");
        List<String> Q4 = Arrays.asList("JUL","AUG","SEP");

        LocalDate localDate = convertDate(today);
        localDate.getMonth().firstMonthOfQuarter().toString();


    }



}
