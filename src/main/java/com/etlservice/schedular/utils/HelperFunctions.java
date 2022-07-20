/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.utils;

import com.etlservice.schedular.model.*;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.math.BigInteger;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 *
 * @author MORRISON.I
 */
@Slf4j
public class HelperFunctions {

    public static Optional<String> returnIdentifiers(int idType, Container container) {

        return container.getMessageData().getPatientIdentifiers()
                .stream()
                .filter(a -> a.getIdentifierType() == idType)
                .filter(d -> d.getVoided() == 0)
                .map(PatientIdentifierType::getIdentifier)
                .findAny();
    }

    public static Integer getAgeAtStartOfARTYears(Container container) {

        Integer ageAtStartOfARTYears = null;
        try {
            Date birthDate = container.getMessageData().getDemographics().getBirthdate();

            LocalDate start = convertDate(birthDate);
            Date artStartDate;

            Optional<Date> findAny = container.getMessageData().getObs()
                    .stream()
                    .filter(a -> a.getConceptId() == 159599)
                    .map(ObsType::getValueDatetime)
                    .findAny();
            if (findAny.isPresent()) {
                artStartDate = findAny.get();
                LocalDate stop = convertDate(artStartDate);
                long years = ChronoUnit.YEARS.between(start, stop);
                ageAtStartOfARTYears = (int) years;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ageAtStartOfARTYears;
    }

    public static Integer getAgeAtStartOfARTMonths(Container container) {

        Integer ageAtStartOfARTYears = null;
        try {
            Date birthDate = container.getMessageData().getDemographics().getBirthdate();

            LocalDate start = convertDate(birthDate);
            Date artStartDate;

            Optional<Date> findAny = container.getMessageData().getObs()
                    .stream()
                    .filter(a -> a.getConceptId() == 159599)
                    .map(ObsType::getValueDatetime)
                    .findAny();
            if (findAny.isPresent()) {
                artStartDate = findAny.get();
                LocalDate stop = convertDate(artStartDate);
                long months = ChronoUnit.MONTHS.between(start, stop);

                ageAtStartOfARTYears = (int) months;
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ageAtStartOfARTYears;
    }

    private static LocalDate convertDate(Date date) {

        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());

        return zdt.toLocalDate();
    }

    public static Optional<ObsType> getObsByConceptID(int conceptId, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getConceptId() == conceptId)
                .filter(d -> d.getVoided() == 0)
                .findAny();
    }

    public static BigInteger getMonthsOnArt(Container container, Date lastPickupDate) {
        BigInteger monthsOnArt = null;

        try {
            Date artStartDate = getArtStartDate(container);

            if (artStartDate != null) {
                LocalDate start = convertDate(artStartDate);
                LocalDate stop = convertDate(lastPickupDate);
                long months = ChronoUnit.MONTHS.between(start, stop);
                monthsOnArt = BigInteger.valueOf(months);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return monthsOnArt;
    }

    public static Date getArtStartDate(Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getConceptId() == 159599)
                .filter(b -> b.getVoided() == 0)
                .map(ObsType::getValueDatetime)
                .max(Date::compareTo)
                .orElse(null);
    }

    public static Date getMaxEncounterDateTime(int formID, Container container) {
        Date encounterDate = null;
        try {
            List<EncounterType> obsTypeList = container.getMessageData().getEncounters();
            encounterDate = obsTypeList.stream()
                    .filter(encounterType -> encounterType.getFormId() == formID)
                    .map(EncounterType::getEncounterDatetime)
                    .max(Date::compareTo).orElse(null);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return encounterDate;
    }

    public static Optional<Date> getMinEncounterDateTime(int formID, Container container) {
        Date encounterDate = null;
        try {
            List<EncounterType> obsTypeList = container.getMessageData().getEncounters();
            encounterDate = obsTypeList.stream()
                    .map(EncounterType::getEncounterDatetime)
                    .min(Date::compareTo).orElse(null);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Optional.ofNullable(encounterDate);
    }



    public static Optional<Date> getMaxVisitDate(Container container) {
        List<Integer> formIds = new ArrayList<>(Arrays.asList(22,56,14,69,23,44,74,53,21,73,20,27,67));
        Date lastVisitDate = null;
        try {
            List<EncounterType> obsTypeList = container.getMessageData().getEncounters();
            lastVisitDate = obsTypeList.stream()
                    .filter(a -> formIds.contains(a.getFormId()))
                    .filter(d -> d.getVoided() == 0)
                    .map(EncounterType::getEncounterDatetime)
                    .max(Date::compareTo).orElse(null);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return Optional.ofNullable(lastVisitDate);

    }

    public static Optional<ObsType> getMaxObsByConceptID(int encounterTypeId, int conceptId, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == encounterTypeId)
                .filter(b -> b.getConceptId()==conceptId)
                .filter(c -> c.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getDateCreated));
    }

    public static Optional<ObsType> getMinObsByConceptID(int encounterTypeId, int conceptId, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == encounterTypeId)
                .filter(b -> b.getConceptId()==conceptId)
                .filter(c -> c.getVoided() == 0)
                .min(Comparator.comparing(ObsType::getDateCreated));
    }

    public static Optional<ObsType> getInitialRegimen(int encounterTypeId, int valueCoded, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == encounterTypeId)
                .filter(b -> b.getConceptId()==valueCoded)
                .filter(c -> c.getVoided() == 0)
                .min(Comparator.comparing(ObsType::getDateCreated));
    }

    public static Optional<ObsType> getCurrentRegimen(int encounterTypeId, int valueCoded, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterType() == encounterTypeId)
                .filter(b -> b.getConceptId()==valueCoded)
                .filter(c -> c.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getDateCreated));
    }

//    public static Optional<ObsType> getMaxByConceptId(int conceptId, Container container) {
//        return container.getMessageData().getObs()
//                .stream()
//                .filter(a -> a.getConceptId() == conceptId)
//                .max(Comparator.comparing(ObsType::getDateCreated));
//    }

    public static BigInteger getCurrentAge(Container container, String type) {
        BigInteger currentAge = null;
        long years,months;
        try {
            Date birthDate = container.getMessageData().getDemographics().getBirthdate();

            Date today = new Date();

            LocalDate start = convertDate(birthDate);
            LocalDate stop = convertDate(today);
            if(type.equals("YEARS")) {
                years = ChronoUnit.YEARS.between(start, stop);
                currentAge =BigInteger.valueOf(years);
            } else {
                months = ChronoUnit.MONTHS.between(start, stop);
                currentAge = BigInteger.valueOf(months);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return currentAge;
    }

    public static String getCurrentARTStatus(Date lastPickupDate, BigInteger daysOfARVRefil, Date dateOfTermination, Date dateReturnToCare) {
        String currentARTStatus = null;
        try {
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            if (lastPickupDate != null) {
                cal.setTime(lastPickupDate);
                cal.add(Calendar.DAY_OF_MONTH, (daysOfARVRefil.intValue() + 28));

                if (dateReturnToCare != null && dateOfTermination != null) {
                    if (dateReturnToCare.compareTo(dateOfTermination) > 0) {
                        if (cal.getTime().compareTo(today) > 0) {
                            currentARTStatus = "Active";
                        } else
                            currentARTStatus = "InActive";
                    }
                } else if (dateReturnToCare == null && dateOfTermination != null) {
                    currentARTStatus = "InActive";
                } else if (dateReturnToCare == null && dateOfTermination == null) {
                    if (cal.getTime().compareTo(today) > 0) {
                        currentARTStatus = "Active";
                    } else
                        currentARTStatus = "InActive";
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return currentARTStatus;
    }

    public static String getCurrentArtStatus(Date lastPickupDate, BigInteger daysOfARVRefil, Date cutOff) {
        int ltfunumber = daysOfARVRefil.intValue() + 28;
        if (lastPickupDate != null) {
            LocalDate pickup = convertDate(lastPickupDate).plusDays(ltfunumber);
            long daysDiff = ChronoUnit.DAYS.between(pickup, convertDate(cutOff));
            if (daysDiff >= 0) return "Active";
        }
        return "Inactive";
    }

    public static String getBiometricCaptured(Container container) {
        String biometricCaptured = null;
        try {
            if (container.getMessageData().getPatientBiometrics() != null && container.getMessageData().getPatientBiometrics().size() > 0) {
                biometricCaptured = "Yes";
            } else
                biometricCaptured = "No";
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return biometricCaptured;
    }

    public static Date getBiometricCaptureDate(Container container) {
        Date biometricCapturedDate = null;
        try{
            if (container.getMessageData().getPatientBiometrics().size() > 0)
                biometricCapturedDate = container.getMessageData().getPatientBiometrics().get(0).getDateCreated();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return biometricCapturedDate;
    }

    public static Optional<ObsType> getInitialRegimenLine(int adultConceptID, int childConceptId, Container container) {
//        String initialRegimenLine = null;
        ObsType obs = null;
        try {
            List<ObsType> obsList = container.getMessageData().getObs();
            Map<Date, ObsType> initialFirstLineRegimenMap = new HashMap<>();
            Set<Date> keys = getListOfDateSet(obsList, initialFirstLineRegimenMap, adultConceptID, childConceptId);
            List<Date> initialFirstLineRegimenDateList = new ArrayList<>(keys);
            if (!initialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(initialFirstLineRegimenDateList);
//                initialRegimenLine = initialFirstLineRegimenMap.get(latestDate).getVariableValue();
                obs = initialFirstLineRegimenMap.get(latestDate);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.ofNullable(obs);
    }

    public static Optional<Date> getInitialRegimenLineDate(int adultConceptID, int childConceptId, Container container) {
        Date initialRegimenLineDate = null;
        try {
            var obsList = container.getMessageData().getObs();
            Map<Date, ObsType> initialFirstLineRegimenMap = new HashMap<>();
            Set<Date> keys = getListOfDateSet(obsList, initialFirstLineRegimenMap, adultConceptID, childConceptId);
            List<Date> initialFirstLineRegimenDateList = new ArrayList<>(keys);
            if (!initialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(initialFirstLineRegimenDateList);
                initialRegimenLineDate = initialFirstLineRegimenMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.ofNullable(initialRegimenLineDate);
    }

    private static Set<Date> getListOfDateSet(List<ObsType> obsTypeList, Map<Date, ObsType> obsTypeMap,
                                              int adultConceptID, int childConceptId) {
        for (ObsType obsType : obsTypeList) {
            if ((obsType.getConceptId() == adultConceptID && obsType.getFormId() == 27) ||
                    (obsType.getConceptId() == childConceptId && obsType.getFormId() == 27))
                obsTypeMap.put(obsType.getObsDatetime(), obsType);
        }
        return obsTypeMap.keySet();
    }

    public static Optional<Date> getLastINHDispensedDate(int conceptId, int valueCoded,int formID,
                                                         Container container) {
        Date lastINHDispenseDate = null;
        try {
            List<ObsType> lastINHDispensedDateList = container.getMessageData().getObs();
            Map<Date, ObsType> lastINHDispensedDateMap = new HashMap<>();

            for (ObsType obsType : lastINHDispensedDateList) {
                if (obsType.getConceptId() == conceptId && obsType.getFormId() == formID &&
                        obsType.getValueCoded() == valueCoded)
                    lastINHDispensedDateMap.put(obsType.getObsDatetime(), obsType);
            }
            List<Date> tbStatusDateList = new ArrayList<>(lastINHDispensedDateMap.keySet());
            if (!tbStatusDateList.isEmpty()) {
                Date latestDate = Collections.max(tbStatusDateList);
                lastINHDispenseDate = lastINHDispensedDateMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.ofNullable(lastINHDispenseDate);
    }

    public static String getValidCapture(Container container) {
        String validCapture = null;
        try {
            List<PatientBiometricType> patientBiometricTypeList = container.getMessageData().getPatientBiometrics();
            for (PatientBiometricType patientBiometricType : patientBiometricTypeList) {
                if (patientBiometricType.getTemplate().startsWith("Rk1S"))
                    validCapture = "Yes";
                else {
                    validCapture = "No";
                    break;
                }
            }
            if (container.getMessageData().getPatientBiometrics().size() == 0)
                validCapture = "No";
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return validCapture;
    }

    public static Optional<ObsType> getObsByEncounterId(int encounterId, int conceptId, Container container) {

        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterId() == encounterId)
                .filter(b -> b.getConceptId() == conceptId)
                .filter(d -> d.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getDateCreated));
    }

    public static Optional<ObsType> getObsByEncounterId(int encounterId, int conceptId, Container container, LocalDate localDate) {
        Date date = getCutOffDate(localDate);
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getEncounterId() == encounterId)
                .filter(b -> b.getConceptId() == conceptId)
                .filter(c -> c.getDateCreated().before(date))
                .filter(d -> d.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getDateCreated));
    }

    public static Optional<ObsType> getMinConceptObsIdWithFormId (int formId, int conceptId, Container container) {
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getFormId() == formId)
                .filter(b -> b.getConceptId() == conceptId)
                .filter(c -> c.getVoided() == 0)
                .min(Comparator.comparing(ObsType::getObsDatetime));
    }

    public static Optional<ObsType> getMaxConceptObsIdWithFormId (int formId, int conceptId, Container container) {
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getFormId() == formId)
                .filter(b -> b.getConceptId() == conceptId)
                .filter(c -> c.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getObsDatetime));
    }

    public static Optional<ObsType> getMaxConceptObsIdWithFormId (int formId, int conceptId, Container container, LocalDate localDate) {
        Date cutOffDate = getCutOffDate(localDate);
        return container.getMessageData().getObs()
                .stream()
                .filter(a -> a.getFormId() == formId)
                .filter(b -> b.getConceptId() == conceptId)
                .filter(d -> d.getDateCreated().before(cutOffDate))
                .filter(c -> c.getVoided() == 0)
                .max(Comparator.comparing(ObsType::getObsDatetime));
    }

    private static Date getCutOffDate(LocalDate localDate) {
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        TreeMap<Integer, Date> rangeTreeMap = new TreeMap<>();
        rangeTreeMap.put(0, Date.from(LocalDate.of(year - 1, 12, 31)
                .atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()));
        rangeTreeMap.put(3, Date.from(LocalDate.of(year, 3, 31)
                .atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()));
        rangeTreeMap.put(6, Date.from(LocalDate.of(year, 6, 30)
                .atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()));
        rangeTreeMap.put(9, Date.from(LocalDate.of(year, 9, 30)
                .atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()));
        return rangeTreeMap.get(rangeTreeMap.lowerKey(month));
    }
    
}
