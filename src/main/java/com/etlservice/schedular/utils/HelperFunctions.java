/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.utils;

import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.EncounterType;
import com.etlservice.schedular.model.ObsType;
import com.etlservice.schedular.model.PatientIdentifierType;
import com.etlservice.schedular.model.VisitType;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    
    public static BigInteger getMonthsOnArt(Container container) {
        
        BigInteger monthsOnArt = null;
        
        try {
            Date artStartDate = getArtStartDate(container);
            Date today = new Date();

            //LocalDate start = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
            if (artStartDate != null) {
                LocalDate start = convertDate(artStartDate);
                //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
                LocalDate stop = convertDate(today);
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
    
    public static Optional<Date> getMaxVisitDate(Container container) {
        
        return container.getMessageData().getVisits()
                .stream()
                .map(x -> {
                    return x.getDateChanged() == null ? x.getDateCreated() : x.getDateChanged();
                }).max(Date::compareTo);
                
        
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
    
}
