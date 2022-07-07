package com.etlservice.schedular.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
@Table(name = "radet")//, schema = "postgres")
public class Radet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DatimCode")
    private String datimCode;

    @Column(name = "FacilityName")
    private String facilityName;

    @Column(name = "PatientID")
    private Integer patientID;

    @Column(name = "PatientUniqueID")
    private String patientUniqueID;

    @Column(name = "PatientHospitalNo")
    private String patientHospitalNo;

    @Column(name = "AncNo")
    private String ancNo;

    @Column(name = "HtsNo")
    private String htsNo;

    @Column(name = "Sex")
    private String sex;

    @Column(name = "AgeAtStartOfArtYears")
    private Integer ageAtStartOfARTYears;

    @Column(name = "AgeAtStartOfArtMonths")
    private Integer ageAtStartOfARTMonths;

    @Column(name = "CareEntryPoint")
    private String careEntryPoint;

    @Column(name = "KpType")
    private String kpType;

    @Column(name = "MonthsOnArt")
    private String monthsOnArt;

    @Column(name = "DateTransferredIn")
    private Date dateTransferredIn;

    @Column(name = "TransferInStatus")
    private String transferInStatus;

    @Column(name = "ArtStartDate")
    private Date artStartDate;

    @Column(name = "LastPickupDate")
    private Date lastPickupDate;

    @Column(name = "LastVisitDate")
    private Date lastVisitDate;

    @Column(name = "DaysOfArvRefil")
    private String daysOfARVRefil;

    @Column(name = "PillBalance")
    private String pillBalance;

    @Column(name = "InitialRegimenLine")
    private String initialRegimenLine;

    @Column(name = "InitialRegimen")
    private String initialRegimen;

    @Column(name = "InitialCd4Count")
    private String initialCd4Count;

    @Column(name = "InitialCd4CountDate")
    private Date initialCd4CountDate;

    @Column(name = "CurrentCd4Count")
    private String currentCd4Count;

    @Column(name = "CurrentCd4CountDate")
    private Date currentCd4CountDate;

    @Column(name = "LastEacDate")
    private Date lastEacDate;

    @Column(name = "CurrentRegimenLine")
    private String currentRegimenLine;

    @Column(name = "CurrentRegimen")
    private String currentRegimen;

    @Column(name = "PregnancyStatus")
    private String pregnancyStatus;

    @Column(name = "PregnancyStatusDate")
    private Date pregnancyStatusDate;

    @Column(name = "EDD")
    private Date edd;

    @Column(name = "LastDeliveryDate")
    private Date lastDeliveryDate;

    @Column(name = "LMP")
    private Date lmp;

    @Column(name = "EstimatedGestationAgeWeeks")
    private String estimatedGestationAgeWeeks;

    @Column(name = "CurrentViralLoad")
    private String currentViralLoad;

    @Column(name = "ViralLoadEncounterDate")
    private Date viralLoadEncounterDate;

    @Column(name = "ViralLoadSampleCollectionDate")
    private Date viralLoadSampleCollectionDate;

    @Column(name = "ViralLoadReportedDate")
    private Date viralLoadReportedDate;

    @Column(name = "ResultDate")
    private Date resultDate;

    @Column(name = "AssayDate")
    private Date assayDate;

    @Column(name = "ApprovalDate")
    private Date approvalDate;

    @Column(name = "ViralLoadIndication")
    private String viralLoadIndication;

    @Column(name = "PatientOutcome")
    private String patientOutcome;

    @Column(name = "PatientOutcomeDate")
    private Date patientOutcomeDate;

    @Column(name = "CurrentArtStatus")
    private String currentARTStatus;

    @Column(name = "DispensingModality")
    private String dispensingModality;

    @Column(name = "FacilityDispensingModality")
    private String facilityDispensingModality;

    @Column(name = "DddDispensingModality")
    private String dddDispensingModality;

    @Column(name = "MmdType")
    private String mmdType;

    @Column(name = "DateReturnedToCare")
    private Date dateReturnedToCare;

    @Column(name = "DateOfTermination")
    private Date dateOfTermination;

    @Column(name = "PharmacyNextAppointment")
    private Date pharmacyNextAppointment;

    @Column(name = "ClinicalNextAppointment")
    private Date clinicalNextAppointment;

    @Column(name = "CurrentAgeYears")
    private Integer currentAgeYears;

    @Column(name = "CurrentAgeMonths")
    private Integer currentAgeMonths;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "MarkAsDeseased")
    private String markAsDeseased;

    @Column(name = "MarkAsDeseasedDeathDate")
    private Date markAsDeseasedDeathDate;

    @Column(name = "RegistrationPhoneNo")
    private String registrationPhoneNo;

    @Column(name = "NextofKinPhoneNo")
    private String nextOfkinPhoneNo;

    @Column(name = "TreatmentSupporterPhoneNo")
    private String treatmentSupporterPhoneNo;

    @Column(name = "BiometricCaptured")
    private String biometricCaptured;

    @Column(name = "BiometricCapturedDate")
    private Date biometricCapturedDate;

    @Column(name = "ValidCapture")
    private String validCapture;

    @Column(name = "CurrentWeight")
    private String currentWeight;

    @Column(name = "CurrentWeightDate")
    private Date currentWeightDate;

    @Column(name = "TbStatus")
    private String tbStatus;

    @Column(name = "TbStatusDate")
    private Date tbStatusDate;

    @Column(name = "InhStartDate")
    private Date inhStartDate;

    @Column(name = "InhStopDate")
    private Date inhStopDate;

    @Column(name = "LastInhDispensedDate")
    private Date lastINHDispensedDate;

    @Column(name = "TbTreatmentStartDate")
    private Date tbTreatmentStartDate;

    @Column(name = "TnTreatmentStopDate")
    private Date tbTreatmentStopDate;

    @Column(name = "LastViralLoadSampleCollectionFormDate")
    private Date lastViralLoadSampleCollectionFormDate;

    @Column(name = "LastSampleTakenDate")
    private Date lastSampleTakenDate;

    @Column(name = "OtzEnrollmentDate")
    private Date otzEnrollmentDate;

    @Column(name = "OtzOutcomeDate")
    private Date otzOutcomeDate;

    @Column(name = "EnrollmentDate")
    private Date enrollmentDate;

    @Column(name = "InitialFirstLineRegimen")
    private String InitialFirstLineRegimen;

    @Column(name = "InitialFirstLineRegimenDate")
    private Date initialFirstLineRegimenDate;

    @Column(name = "InitialSecondLineRegimen")
    private String initialSecondLineRegimen;

    @Column(name = "InitialSecondLineRegimenDate")
    private Date initialSecondLineRegimenDate;

    @Column(name = "LastPickupDatePreviousQuarter")
    private Date lastPickupDatePreviousQuarter;

    @Column(name = "DrugDurationPreviousQuarter")
    private String drugDurationPreviousQuarter;

    @Column( name = "PatientOutcomePreviousQuarter")
    private String patientOutcomePreviousQuarter;

    @Column(name = "PatientOutcomeDatePreviousQuarter")
    private Date patientOutcomeDatePreviousQuarter;

    @Column( name = "ArtStatusPreviousQuarter")
    private String artStatusPreviousQuarter;

    @Column(name = "TouchTime")
    private Date touchTime;

    @Column(name = "PatientUuid")
    protected String patientUuid;

    @Transient
    Container container;

    public Radet(Container container) {
        this.container = container;
    }
    public Radet() {

    }
    String returnIdentifiers(int num){
        Container radetContainer = container;
        String id ="";
        if(radetContainer != null) {
            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
            for(PatientIdentifierType patientIdentifierType : patientIdentifierTypeList){
                if(patientIdentifierType.getIdentifierType() == num)
                    id = patientIdentifierType.getIdentifier();
            }
        }
        return id;
    }

    String returnPatientID(int num){
        Container radetContainer = container;
        String id ="";
        if(radetContainer != null) {
            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
            for(PatientIdentifierType patientIdentifierType : patientIdentifierTypeList){
                if(patientIdentifierType.getIdentifierType() == num)
                    id = patientIdentifierType.getPatientId()+"";
            }
        }
        return id;
    }

    private String getMaxVariableValue(int conceptID, int formID){
        String variableValue = "";
        try {
            Container radetContainer = container;
            List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
            List<Date> tbStatusDateList = new ArrayList();
            Map<Date, ObsType> tbStatusMap = new HashMap<>();

            for (ObsType obsType : tbStatusList) {
                if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                    tbStatusMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date tbStatusDate : tbStatusMap.keySet()) {
                tbStatusDateList.add(tbStatusDate);
            }
            if (!tbStatusDateList.isEmpty()) {
                Date latestDate = Collections.max(tbStatusDateList);
                variableValue = tbStatusMap.get(latestDate).getVariableValue();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return variableValue;
    }

    private String getMinVariableValue(int conceptID, int formID){
        String variableValue = "";
        try {
            Container radetContainer = container;
            List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
            List<Date> tbStatusDateList = new ArrayList();
            Map<Date, ObsType> tbStatusMap = new HashMap<>();


            for (ObsType obsType : tbStatusList) {
                if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                    tbStatusMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date tbStatusDate : tbStatusMap.keySet()) {
                tbStatusDateList.add(tbStatusDate);
            }
            if (!tbStatusDateList.isEmpty()) {
                Date latestDate = Collections.min(tbStatusDateList);
                variableValue = tbStatusMap.get(latestDate).getVariableValue();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return variableValue;
    }

    private String getVariableValue(int conceptID){
        String variableValue = "";
        try {
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            for (ObsType obsType : obsTypeList) {
                if (obsType.getConceptId() == conceptID)
                    variableValue = obsType.getVariableValue();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return variableValue;
    }

    private  Date getEncounterDateTime(int forimID){
        Date encounterDate = null;
        try {
            Container radetContainer = container;
            List<EncounterType> obsTypeList = radetContainer.getMessageData().getEncounters();
            List<Date> lastPickupDateList = new ArrayList();
            for (EncounterType encounterType : obsTypeList) {
                if (encounterType.getFormId() == forimID)
                    lastPickupDateList.add(encounterType.getEncounterDatetime());
            }
            if(!lastPickupDateList.isEmpty())
            encounterDate = Collections.max(lastPickupDateList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return encounterDate;
    }

    private Date getValueDateTime(int conceptID){
        Date valueDateTime = null;
        try{
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            for (ObsType obsType : obsTypeList) {
                if(obsType.getConceptId() == conceptID)
                    valueDateTime = obsType.getValueDatetime();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return valueDateTime;
    }
    private Date getMaxValueDateTime(int conceptID, int formID){
        Container radetContainer = container;
        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
        List<Date> tbStatusDateList = new ArrayList();
        Map<Date, ObsType> tbStatusMap = new HashMap<>();
        Date valueDatetime = null;

        for (ObsType obsType : tbStatusList) {
            if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                tbStatusMap.put(obsType.getObsDatetime(), obsType);

        }for (Date tbStatusDate : tbStatusMap.keySet()){
            tbStatusDateList.add(tbStatusDate);
        }
        if(!tbStatusDateList.isEmpty()) {
            Date latestDate = Collections.max(tbStatusDateList);
            valueDatetime = tbStatusMap.get(latestDate).getValueDatetime();
        }
        return valueDatetime;
    }

    private Date getMinValueDateTime(int conceptID, int formID){
        Container radetContainer = container;
        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
        List<Date> tbStatusDateList = new ArrayList();
        Map<Date, ObsType> tbStatusMap = new HashMap<>();
        Date valueDatetime = null;

        for (ObsType obsType : tbStatusList) {
            if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                tbStatusMap.put(obsType.getObsDatetime(), obsType);

        }for (Date tbStatusDate : tbStatusMap.keySet()){
            tbStatusDateList.add(tbStatusDate);
        }
        if(!tbStatusDateList.isEmpty()) {
            Date latestDate = Collections.min(tbStatusDateList);
            valueDatetime = tbStatusMap.get(latestDate).getValueDatetime();
        }
        return valueDatetime;
    }
    private Date getMaxObsDateTime(int conceptID, int formID){
        Container radetContainer = container;
        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
        List<Date> tbStatusDateList = new ArrayList();
        Map<Date, ObsType> tbStatusMap = new HashMap<>();
        Date obsDatetime = null;

        for (ObsType obsType : tbStatusList) {
            if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                tbStatusMap.put(obsType.getObsDatetime(), obsType);

        }for (Date tbStatusDate : tbStatusMap.keySet()){
            tbStatusDateList.add(tbStatusDate);
        }
        if(!tbStatusDateList.isEmpty()) {
            Date latestDate = Collections.max(tbStatusDateList);
            obsDatetime = tbStatusMap.get(latestDate).getObsDatetime();
        }
        return obsDatetime;
    }
    private Date getMinObsDateTime(int conceptID, int formID){
        Container radetContainer = container;
        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
        List<Date> tbStatusDateList = new ArrayList();
        Map<Date, ObsType> tbStatusMap = new HashMap<>();
        Date obsDatetime = null;

        for (ObsType obsType : tbStatusList) {
            if (obsType.getConceptId() == conceptID && obsType.getFormId() == formID)
                tbStatusMap.put(obsType.getObsDatetime(), obsType);

        }for (Date tbStatusDate : tbStatusMap.keySet()){
            tbStatusDateList.add(tbStatusDate);
        }
        if(!tbStatusDateList.isEmpty()) {
            Date latestDate = Collections.min(tbStatusDateList);
            obsDatetime = tbStatusMap.get(latestDate).getObsDatetime();
        }
        return obsDatetime;
    }



    public String getDatimCode() {
        Container radetContainer = container;
        if(radetContainer != null)
            datimCode =  radetContainer.getMessageHeader().getFacilityDatimCode();
        return  datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }

    public String getFacilityName() {
        Container radetContainer = container;
        facilityName = container.getMessageHeader().getFacilityName();
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getPatientID() {
        Container radetContainer = container;
        if(radetContainer != null) {
            patientID = radetContainer.getMessageData().getDemographics().getPatientId();
        }
        return patientID;
    }

    public void setPatientID(Integer patientID) {

        this.patientID = patientID;
    }

    public String getPatientUniqueID() {
//        Container radetContainer = container;
//        if(radetContainer != null) {
//            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
//            for(PatientIdentifierType patientIdentifierType : patientIdentifierTypeList){
//                if(patientIdentifierType.getIdentifierType() == 4)
//                    patientUniqueID = patientIdentifierType.getIdentifier();
//            }
//        }
        patientUniqueID = returnIdentifiers(4);
        return patientUniqueID;
    }

    public void setPatientUniqueID(String patientUniqueID) {
        this.patientUniqueID = patientUniqueID;
    }

    public String getPatientHospitalNo() {
//        Container radetContainer = container;
//        if(radetContainer != null) {
//            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
//            for(PatientIdentifierType patientIdentifierType : patientIdentifierTypeList){
//                if(patientIdentifierType.getIdentifierType() == 5)
//                    patientHospitalNo = patientIdentifierType.getIdentifier();
//            }
//        }
        patientHospitalNo = returnIdentifiers(5);
        return patientHospitalNo;
    }

    public void setPatientHospitalNo(String patientHospitalNo) {
        this.patientHospitalNo = patientHospitalNo;
    }

    public String getAncNo() {
//        Container radetContainer = container;
//        if(radetContainer != null) {
//            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
//            for (PatientIdentifierType patientIdentifierType : patientIdentifierTypeList) {
//                if (patientIdentifierType.getIdentifierType() == 6)
//                    ancNo = patientIdentifierType.getIdentifier();
//            }
//        }
        //ancNo = returnIdentifiers(6);
        Container radetContainer = container;
        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
        List<Date> initialRegimenLineList = new ArrayList();
        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();

        for (ObsType obsType : obsTypeList) {
            if(obsType.getFormId()==16) {
                if (obsType.getConceptId() == 165567)
                    initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
            }
        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
            initialRegimenLineList.add(initialRegimenLineDate);
        }
        if(!initialRegimenLineList.isEmpty()) {
            Date latestDate = Collections.max(initialRegimenLineList);
            ancNo = initialRegimenLineMap.get(latestDate).getValueText();
        }
        return ancNo;
    }

    public void setAncNo(String ancNo) {
        this.ancNo = ancNo;
    }

    public String getHtsNo() {
//        Container radetContainer = container;
//        if(radetContainer != null) {
//            List<PatientIdentifierType> patientIdentifierTypeList = radetContainer.getMessageData().getPatientIdentifiers();
//            for (PatientIdentifierType patientIdentifierType : patientIdentifierTypeList) {
//                if (patientIdentifierType.getIdentifierType() == 8)
//                    htsNo = patientIdentifierType.getIdentifier();
//            }
//        }
        htsNo = returnIdentifiers(8);
        return htsNo;
    }

    public void setHtsNo(String htsNo) {
        this.htsNo = htsNo;
    }

    public String getSex() {
        Container radetContainer = container;
        if(radetContainer != null) {
            sex = radetContainer.getMessageData().getDemographics().getGender();
        }
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate convertDate(Date date){

        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();

        return localDate;
    }
    public Integer getAgeAtStartOfARTYears() {
        try {
            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();

//        LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
            LocalDate start = convertDate(birthDate);
            //System.out.println("Date: "+start.);
            Date artStartDate = null;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            for (ObsType obsType : obsTypeList) {
                if (obsType.getConceptId() == 159599)
                    artStartDate = obsType.getValueDatetime();
            }
            //LocalDate stop = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
            LocalDate stop = convertDate(artStartDate);
            long years = ChronoUnit.YEARS.between(start, stop);
            System.out.println("start: " + start + " | stop: " + stop + " | years: " + years);
            ageAtStartOfARTYears =(int) years ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ageAtStartOfARTYears;
    }

    public void setAgeAtStartOfARTYears(Integer ageAtStartOfARTYears) {
        this.ageAtStartOfARTYears = ageAtStartOfARTYears;
    }

    public Integer getAgeAtStartOfARTMonths() {
        try{
        Container radetContainer = container;
        Date birthDate  = radetContainer.getMessageData().getDemographics().getBirthdate();
        //LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
        LocalDate start =convertDate(birthDate);
        Date artStartDate = null;
        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
        for (ObsType obsType : obsTypeList) {
            if(obsType.getConceptId() == 159599)
                artStartDate = obsType.getValueDatetime();
        }
        //LocalDate stop = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
        LocalDate stop =convertDate(artStartDate);
        long months = ChronoUnit.MONTHS.between( start , stop );
        System.out.println( "start: " + start + " | stop: " + stop + " | months: " + months ) ;
        ageAtStartOfARTMonths  = (int) months;
    }catch (Exception e){
        e.printStackTrace();
    }
        return ageAtStartOfARTMonths;
    }

    public void setAgeAtStartOfARTMonths(Integer ageAtStartOfARTMonths) {
        this.ageAtStartOfARTMonths = ageAtStartOfARTMonths;
    }

    public String getCareEntryPoint() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 160540)
//                careEntryPoint = obsType.getVariableValue();
//        }
        careEntryPoint = getVariableValue(160540);
        return careEntryPoint;
    }

    public void setCareEntryPoint(String careEntryPoint) {
        this.careEntryPoint = careEntryPoint;
    }

    public String getKpType() {
        kpType = getMaxVariableValue(166369,23);
        return kpType;
    }

    public void setKpType(String kpType) {
        this.kpType = kpType;
    }

    public String getMonthsOnArt() {
    try {
        Date artStartDate = getArtStartDate();
        Date today = new Date();


        //LocalDate start = LocalDate.of( artStartDate.getYear() , artStartDate.getMonth() , artStartDate.getDay() ) ;
        if(artStartDate != null){
            LocalDate start = convertDate(artStartDate);
            //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
            LocalDate stop = convertDate(today);
            long months = ChronoUnit.MONTHS.between(start, stop);
            monthsOnArt = months + "";
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        return monthsOnArt;
    }

    public void setMonthsOnArt(String monthsOnArt) {
        this.monthsOnArt = monthsOnArt;
    }

    public Date getDateTransferredIn() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 160534)
//                dateTransferredIn = obsType.getValueDatetime();
//        }
        dateTransferredIn = getValueDateTime(160534);
        return dateTransferredIn;
    }

    public void setDateTransferredIn(Date dateTransferredIn) {
        this.dateTransferredIn = dateTransferredIn;
    }

    public String getTransferInStatus() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 165242)
//                transferInStatus = obsType.getVariableValue();
//        }
        transferInStatus = getVariableValue(165242);
        return transferInStatus;
    }

    public void setTransferInStatus(String transferInStatus) {
        this.transferInStatus = transferInStatus;
    }

    public Date getArtStartDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 159599)
//                artStartDate = obsType.getValueDatetime();
//        }
        artStartDate = getValueDateTime(159599);
        return artStartDate;
    }

    public void setArtStartDate(Date artStartDate) {
        this.artStartDate = artStartDate;
    }

    public Date getLastPickupDate() {
//        Container radetContainer = container;
//        List<EncounterType> obsTypeList = radetContainer.getMessageData().getEncounters();
//        List<Date> lastPickupDateList = new ArrayList();
//        for(EncounterType encounterType : obsTypeList){
//            if(encounterType.getFormId() == 27)
//                lastPickupDateList.add(encounterType.getEncounterDatetime());
//        }
//        lastPickupDate = Collections.max(lastPickupDateList);
        lastPickupDate = getEncounterDateTime(27);
        return lastPickupDate;
    }

    public void setLastPickupDate(Date lastPickupDate) {
        this.lastPickupDate = lastPickupDate;
    }

    public Date getLastVisitDate() {
        try {
            Container radetContainer = container;
            List<EncounterType> obsTypeList = radetContainer.getMessageData().getEncounters();
            List<Date> lastVisitDateList = new ArrayList();
            for (EncounterType encounterType : obsTypeList) {
                lastVisitDateList.add(encounterType.getEncounterDatetime());
            }
            lastVisitDate = Collections.max(lastVisitDateList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getDaysOfARVRefil() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> daysOfARVRefilDateList = new ArrayList();
//        Map<Date, ObsType> daysOfARVRefilMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 159368 && obsType.getFormId() == 27)
//                daysOfARVRefilMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date daysOfARVRefilDate : daysOfARVRefilMap.keySet()){
//            daysOfARVRefilDateList.add(daysOfARVRefilDate);
//        }
//        if(!daysOfARVRefilDateList.isEmpty()) {
//            Date latestDate = Collections.max(daysOfARVRefilDateList);
//            daysOfARVRefil = daysOfARVRefilMap.get(latestDate).getValueNumeric().intValue()+"";
//        }

        daysOfARVRefil = getMaxVariableValue(159368,27);
        return daysOfARVRefil;
    }

    public void setDaysOfARVRefil(String daysOfARVRefil) {
        this.daysOfARVRefil = daysOfARVRefil;
    }

    public String getPillBalance() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> pillBalanceDateList = new ArrayList();
//        Map<Date, ObsType> pillBalanceMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 166406 && obsType.getFormId() == 27)
//                pillBalanceMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date pillBalanceDate : pillBalanceMap.keySet()){
//            pillBalanceDateList.add(pillBalanceDate);
//        }
//        if(!pillBalanceDateList.isEmpty()) {
//            Date latestDate = Collections.max(pillBalanceDateList);
//            pillBalance = pillBalanceMap.get(latestDate).getValueNumeric().intValue()+"";
//        }
        pillBalance = getMaxVariableValue(166406,27);
        return pillBalance;
    }

    public void setPillBalance(String pillBalance) {
        this.pillBalance = pillBalance;
    }

    public String getInitialRegimenLine() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 165708)
//                initialRegimenLineMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.min(initialRegimenLineList);
//            initialRegimenLine = initialRegimenLineMap.get(latestDate).getVariableValue();
//        }
        initialRegimenLine = getMinVariableValue(165708,27);
        return initialRegimenLine;
    }

    public void setInitialRegimenLine(String initialRegimenLine) {
        this.initialRegimenLine = initialRegimenLine;
    }

    public String getInitialRegimen() {
        try {
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            List<Date> initialRegimenLineList = new ArrayList();
            Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();

            for (ObsType obsType : obsTypeList) {
                if (obsType.getFormId() == 27) {
                    if (obsType.getConceptId() == 165707 || obsType.getConceptId() == 164506 || obsType.getConceptId() == 164514
                            || obsType.getConceptId() == 165703 || obsType.getConceptId() == 164513 || obsType.getConceptId() == 165702)

                        initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
                }
            }
            for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()) {
                initialRegimenLineList.add(initialRegimenLineDate);
            }
            if (!initialRegimenLineList.isEmpty()) {
                Date latestDate = Collections.min(initialRegimenLineList);
                initialRegimen = initialRegimenLineMap.get(latestDate).getVariableValue();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return initialRegimen;
    }

    public void setInitialRegimen(String initialRegimen) {
        this.initialRegimen = initialRegimen;
    }

    public String getInitialCd4Count() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//                if (obsType.getConceptId() == 5497 && obsType.getFormId()==21)
//                    initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.min(initialRegimenLineList);
//            initialCd4Count = initialRegimenLineMap.get(latestDate).getVariableValue();
//        }
        initialCd4Count = getMinVariableValue(5497,21);
        return initialCd4Count;
    }

    public void setInitialCd4Count(String initialCd4Count) {
        this.initialCd4Count = initialCd4Count;
    }

    public Date getInitialCd4CountDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 5497 && obsType.getFormId()==21)
//                initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.min(initialRegimenLineList);
//            initialCd4CountDate = initialRegimenLineMap.get(latestDate).getObsDatetime();
//        }
        initialCd4CountDate = getMinObsDateTime(5497,21);
        return initialCd4CountDate;
    }

    public void setInitialCd4CountDate(Date initialCd4CountDate) {
        this.initialCd4CountDate = initialCd4CountDate;
    }

    public String getCurrentCd4Count() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 5497 && obsType.getFormId()==21)
//                initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.max(initialRegimenLineList);
//            currentCd4Count = initialRegimenLineMap.get(latestDate).getVariableValue();
//        }
        currentCd4Count = getMaxVariableValue(5497,21);
        return currentCd4Count;
    }

    public void setCurrentCd4Count(String currentCd4Count) {
        this.currentCd4Count = currentCd4Count;
    }

    public Date getCurrentCd4CountDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 5497 && obsType.getFormId()==21)
//                initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.max(initialRegimenLineList);
//            initialCd4CountDate = initialRegimenLineMap.get(latestDate).getObsDatetime();
//        }
        currentCd4CountDate = getMaxObsDateTime(5497,21);
        return currentCd4CountDate;
    }

    public void setCurrentCd4CountDate(Date currentCd4CountDate) {
        this.currentCd4CountDate = currentCd4CountDate;
    }

    public Date getLastEacDate() {

//        Container radetContainer = container;
//        List<EncounterType> encounterTypeList = radetContainer.getMessageData().getEncounters();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (EncounterType encounterType : encounterTypeList) {
//            if (encounterType.getFormId()==69)
//                initialRegimenLineList.add(encounterType.getEncounterDatetime());
//
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.max(initialRegimenLineList);
//            lastEacDate = initialRegimenLineMap.get(latestDate).getObsDatetime();
//        }
        lastEacDate = getEncounterDateTime(69);
        return lastEacDate;
    }

    public void setLastEacDate(Date lastEacDate) {
        this.lastEacDate = lastEacDate;
    }

    public String getCurrentRegimenLine() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> initialRegimenLineList = new ArrayList();
//        Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==27) {
//                if (obsType.getConceptId() == 165708)
//                    initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()){
//            initialRegimenLineList.add(initialRegimenLineDate);
//        }
//        if(!initialRegimenLineList.isEmpty()) {
//            Date latestDate = Collections.max(initialRegimenLineList);
//            currentRegimenLine = initialRegimenLineMap.get(latestDate).getVariableValue();
//        }
        currentRegimenLine = getMaxVariableValue(165708,27);
        return currentRegimenLine;
    }

    public void setCurrentRegimenLine(String currentRegimenLine) {
        this.currentRegimenLine = currentRegimenLine;
    }

    public String getCurrentRegimen() {
        try {
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            List<Date> initialRegimenLineList = new ArrayList();
            Map<Date, ObsType> initialRegimenLineMap = new HashMap<>();

            for (ObsType obsType : obsTypeList) {
                if (obsType.getFormId() == 27) {
                    if (obsType.getConceptId() == 165707 || obsType.getConceptId() == 164506 || obsType.getConceptId() == 164514
                            || obsType.getConceptId() == 165703 || obsType.getConceptId() == 164513 || obsType.getConceptId() == 165702)

                        initialRegimenLineMap.put(obsType.getObsDatetime(), obsType);
                }
            }
            for (Date initialRegimenLineDate : initialRegimenLineMap.keySet()) {
                initialRegimenLineList.add(initialRegimenLineDate);
            }
            if (!initialRegimenLineList.isEmpty()) {
                Date latestDate = Collections.max(initialRegimenLineList);
                currentRegimen = initialRegimenLineMap.get(latestDate).getVariableValue();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return currentRegimen;
    }

    public void setCurrentRegimen(String currentRegimen) {
        this.currentRegimen = currentRegimen;
    }

    public String getPregnancyStatus() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> pregnancyStatusList = new ArrayList();
//        Map<Date, ObsType> pregnancyStatuseMap = new HashMap<>();
//
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==27) {
//                if (obsType.getConceptId() == 165050)
//                    pregnancyStatuseMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date pregnancyStatusDate : pregnancyStatuseMap.keySet()){
//            pregnancyStatusList.add(pregnancyStatusDate);
//        }
//        if(!pregnancyStatusList.isEmpty()) {
//            Date latestDate = Collections.max(pregnancyStatusList);
//            pregnancyStatus = pregnancyStatuseMap.get(latestDate).getVariableValue();
//        }
        pregnancyStatus = getMaxVariableValue(165050,27);
        return pregnancyStatus;
    }

    public void setPregnancyStatus(String pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

    public Date getPregnancyStatusDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> pregnancyStatusList = new ArrayList();
//        Map<Date, ObsType> pregnancyStatuseMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 165050)
//                pregnancyStatuseMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date pregnancyStatusDate : pregnancyStatuseMap.keySet()){
//            pregnancyStatusList.add(pregnancyStatusDate);
//        }
//        if(!pregnancyStatusList.isEmpty()) {
//            Date latestDate = Collections.max(pregnancyStatusList);
//            pregnancyStatusDate = pregnancyStatuseMap.get(latestDate).getObsDatetime();
//        }
        pregnancyStatusDate = getMaxObsDateTime(165050, 27);
        return pregnancyStatusDate;
    }

    public void setPregnancyStatusDate(Date pregnancyStatusDate) {
        this.pregnancyStatusDate = pregnancyStatusDate;
    }

    public Date getEdd() {
        try {
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            List<Date> eddList = new ArrayList();
            Map<Date, ObsType> eddMap = new HashMap<>();

            if (getPregnancyStatus().equals("Pregnant")) {
                if (radetContainer.getMessageData().getDemographics().getGender().equals("F")) {
                    for (ObsType obsType : obsTypeList) {
                        if (obsType.getConceptId() == 5596 && obsType.getFormId() == 14)
                            eddMap.put(obsType.getObsDatetime(), obsType);
                    }
                    for (Date eddDate : eddMap.keySet()) {
                        eddList.add(eddDate);
                    }
                    if (!eddList.isEmpty()) {
                        Date latestDate = Collections.max(eddList);
                        edd = eddMap.get(latestDate).getValueDatetime();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return edd;
        }

    public void setEdd(Date edd) {
        this.edd = edd;
    }

    public Date getLastDeliveryDate() {
        lastDeliveryDate = getEdd();
        return lastDeliveryDate;
    }

    public void setLastDeliveryDate(Date lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }

    public Date getLmp() {
        try{
        Container radetContainer = container;
        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
        List<Date> lmpList = new ArrayList();
        Map<Date, ObsType> lmpMap = new HashMap<>();

        if (getPregnancyStatus().equals("Pregnant")) {
            if (radetContainer.getMessageData().getDemographics().getGender().equals("F")) {
                for (ObsType obsType : obsTypeList) {
                    if (obsType.getConceptId() == 1427 && obsType.getFormId() == 14)
                        lmpMap.put(obsType.getObsDatetime(), obsType);
                }
                for (Date pregnancyStatusDate : lmpMap.keySet()) {
                    lmpList.add(pregnancyStatusDate);
                }
                if (!lmpList.isEmpty()) {
                    Date latestDate = Collections.max(lmpList);
                    lmp = lmpMap.get(latestDate).getValueDatetime();
                }
            }
        }
    }catch (Exception e){
            e.printStackTrace();
        }
        return lmp;
    }

    public void setLmp(Date lmp) {
        this.lmp = lmp;
    }

    public String getEstimatedGestationAgeWeeks() {
        try{
            Container radetContainer = container;
            List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
            List<Date> estimatedGestationAgeWeeksList = new ArrayList();
            Map<Date, ObsType> estimatedGestationAgeWeeksMap = new HashMap<>();

            if (getPregnancyStatus().equals("Pregnant")) {
                if (radetContainer.getMessageData().getDemographics().getGender().equals("F")) {
                    for (ObsType obsType : obsTypeList) {
                        if (obsType.getConceptId() == 1438 && obsType.getFormId() == 14)
                            estimatedGestationAgeWeeksMap.put(obsType.getObsDatetime(), obsType);
                    }
                    for (Date pregnancyStatusDate : estimatedGestationAgeWeeksMap.keySet()) {
                        estimatedGestationAgeWeeksList.add(pregnancyStatusDate);
                    }
                    if (!estimatedGestationAgeWeeksList.isEmpty()) {
                        Date latestDate = Collections.max(estimatedGestationAgeWeeksList);
                        estimatedGestationAgeWeeks = estimatedGestationAgeWeeksMap.get(latestDate).getVariableValue();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return estimatedGestationAgeWeeks;
    }

    public void setEstimatedGestationAgeWeeks(String estimatedGestationAgeWeeks) {
        this.estimatedGestationAgeWeeks = estimatedGestationAgeWeeks;
    }

    public String getCurrentViralLoad() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadList = new ArrayList();
//        Map<Date, ObsType> pregnancyStatuseMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==21) {
//                if (obsType.getConceptId() == 856)
//                    pregnancyStatuseMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date pregnancyStatusDate : pregnancyStatuseMap.keySet()){
//            currentViralLoadList.add(pregnancyStatusDate);
//        }
//        if(!currentViralLoadList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadList);
//            currentViralLoad = pregnancyStatuseMap.get(latestDate).getValueNumeric()+"";
//        }
        currentViralLoad = getMaxVariableValue(856,21);
        return currentViralLoad;
    }

    public void setCurrentViralLoad(String currentViralLoad) {
        this.currentViralLoad = currentViralLoad;
    }

    public Date getViralLoadEncounterDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadEncounterDateList = new ArrayList();
//        Map<Date, ObsType> currentViralLoadEncounterDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//                if (obsType.getConceptId() == 856 && obsType.getFormId()==21)
//                    currentViralLoadEncounterDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date currentViralLoadEncounterDate : currentViralLoadEncounterDateMap.keySet()){
//            currentViralLoadEncounterDateList.add(currentViralLoadEncounterDate);
//        }
//        if(!currentViralLoadEncounterDateList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadEncounterDateList);
//            viralLoadEncounterDate = currentViralLoadEncounterDateMap.get(latestDate).getObsDatetime();
//        }
        viralLoadEncounterDate = getMaxObsDateTime(856,21);
        return viralLoadEncounterDate;
    }

    public void setViralLoadEncounterDate(Date viralLoadEncounterDate) {
        this.viralLoadEncounterDate = viralLoadEncounterDate;
    }

    public Date getViralLoadSampleCollectionDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadList = new ArrayList();
//        Map<Date, ObsType> pregnancyStatuseMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==21) {
//                if (obsType.getConceptId() == 159951)
//                    pregnancyStatuseMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date pregnancyStatusDate : pregnancyStatuseMap.keySet()){
//            currentViralLoadList.add(pregnancyStatusDate);
//        }
//        if(!currentViralLoadList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadList);
//            viralLoadSampleCollectionDate = pregnancyStatuseMap.get(latestDate).getObsDatetime();
//        }
        viralLoadSampleCollectionDate = getMaxValueDateTime(159951,21);
        return viralLoadSampleCollectionDate;
    }

    public void setViralLoadSampleCollectionDate(Date viralLoadSampleCollectionDate) {
        this.viralLoadSampleCollectionDate = viralLoadSampleCollectionDate;
    }

    public Date getViralLoadReportedDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadList = new ArrayList();
//        Map<Date, ObsType> currentViralLoadMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==21) {
//                if (obsType.getConceptId() == 165414)
//                    currentViralLoadMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date pregnancyStatusDate : currentViralLoadMap.keySet()){
//            currentViralLoadList.add(pregnancyStatusDate);
//        }
//        if(!currentViralLoadList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadList);
//            viralLoadReportedDate = currentViralLoadMap.get(latestDate).getValueDatetime();
//        }
        viralLoadReportedDate = getMaxValueDateTime(165414,21);
        return viralLoadReportedDate;
    }

    public void setViralLoadReportedDate(Date viralLoadReportedDate) {
        this.viralLoadReportedDate = viralLoadReportedDate;
    }

    public Date getResultDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> resultDateList = new ArrayList();
//        Map<Date, ObsType> resultDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 166423 && obsType.getFormId()==21)
//                resultDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date resultDate : resultDateMap.keySet()){
//            resultDateList.add(resultDate);
//        }
//        if(!resultDateList.isEmpty()) {
//            Date latestDate = Collections.max(resultDateList);
//            resultDate = resultDateMap.get(latestDate).getValueDatetime();
//        }
        resultDate = getMaxValueDateTime(166423,21);
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Date getAssayDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> assayDateList = new ArrayList();
//        Map<Date, ObsType> assayDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 166424 && obsType.getFormId()==21)
//                assayDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date assayDate : assayDateMap.keySet()){
//            assayDateList.add(assayDate);
//        }
//        if(!assayDateList.isEmpty()) {
//            Date latestDate = Collections.max(assayDateList);
//            assayDate = assayDateMap.get(latestDate).valueDatetime;
//        }
        assayDate = getMaxValueDateTime(166424,21);
        return assayDate;
    }

    public void setAssayDate(Date assayDate) {
        this.assayDate = assayDate;
    }

    public Date getApprovalDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> approvalDateList = new ArrayList();
//        Map<Date, ObsType> approvalDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 166425 && obsType.getFormId()==21)
//                approvalDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date approvalDate : approvalDateMap.keySet()){
//            approvalDateList.add(approvalDate);
//        }
//        if(!approvalDateList.isEmpty()) {
//            Date latestDate = Collections.max(approvalDateList);
//            approvalDate = approvalDateMap.get(latestDate).valueDatetime;
//        }
        approvalDate = getMaxValueDateTime(166425,21);
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getViralLoadIndication() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadList = new ArrayList();
//        Map<Date, ObsType> currentViralLoadMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getFormId()==21) {
//                if (obsType.getConceptId() == 164980)
//                    currentViralLoadMap.put(obsType.getObsDatetime(), obsType);
//            }
//        }for (Date pregnancyStatusDate : currentViralLoadMap.keySet()){
//            currentViralLoadList.add(pregnancyStatusDate);
//        }
//        if(!currentViralLoadList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadList);
//            viralLoadIndication = currentViralLoadMap.get(latestDate).getVariableValue();
//        }
        viralLoadIndication = getMaxVariableValue(164980,21);
        return viralLoadIndication;
    }

    public void setViralLoadIndication(String viralLoadIndication) {
        this.viralLoadIndication = viralLoadIndication;
    }

    public String getPatientOutcome() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> patientOutcomeList = new ArrayList();
//        Map<Date, ObsType> patientOutcomeMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//                if (obsType.getConceptId() == 165470 && obsType.getFormId()==21)
//                    patientOutcomeMap.put(obsType.getObsDatetime(), obsType);
//        }
//        if(!patientOutcomeMap.isEmpty())
//        for (Date patientOutcomeDate : patientOutcomeMap.keySet()){
//            patientOutcomeList.add(patientOutcomeDate);
//        }
//        if(!patientOutcomeList.isEmpty()) {
//            Date latestDate = Collections.max(patientOutcomeList);
//            patientOutcome = patientOutcomeMap.get(latestDate).getVariableValue();
//        }
        patientOutcome = getMaxVariableValue(165470,21);
        return patientOutcome;
    }

    public void setPatientOutcome(String patientOutcome) {
        this.patientOutcome = patientOutcome;
    }

    public Date getPatientOutcomeDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> currentViralLoadList = new ArrayList();
//        Map<Date, ObsType> currentViralLoadMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 165470 && obsType.getFormId()==21)
//                currentViralLoadMap.put(obsType.getObsDatetime(), obsType);
//        }
//        if(!currentViralLoadMap.isEmpty())
//            for (Date pregnancyStatusDate : currentViralLoadMap.keySet()){
//                currentViralLoadList.add(pregnancyStatusDate);
//            }
//        if(!currentViralLoadList.isEmpty()) {
//            Date latestDate = Collections.max(currentViralLoadList);
//            patientOutcomeDate = currentViralLoadMap.get(latestDate).getObsDatetime();
//        }
        patientOutcomeDate = getMaxObsDateTime(165470,21);
        return patientOutcomeDate;
    }

    public void setPatientOutcomeDate(Date patientOutcomeDate) {
        this.patientOutcomeDate = patientOutcomeDate;
    }

    public String getCurrentARTStatus() {
        try {
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(getLastPickupDate());
            int daysOfArvRefill = Integer.parseInt(getDaysOfARVRefil());
            cal.add(Calendar.DAY_OF_MONTH, (daysOfArvRefill + 28));
            //cal.add(Calendar.DATE, (Integer.parseInt(getDaysOfARVRefil() + 28)));

            Date terminationDate = getDateOfTermination();
            // Optional.ofNullable(getDateOfTermination()).orElse(null);
            Date returnTOCare = getDateReturnedToCare();
            //Optional.ofNullable(getDateReturnedToCare()).orElse(null);
            if (returnTOCare != null && terminationDate != null) {
                if (returnTOCare.compareTo(terminationDate) > 0) {
                    //        if(today.compareTo(cal.getTime()) > 0) {
                    if (cal.getTime().compareTo(today) > 0) {
                        currentARTStatus = "Active";
                        System.out.println("Date 1 occurs after Date 2");
                    } else
                        currentARTStatus = "InActive";
                }
            } else if (returnTOCare == null && terminationDate != null) {
                currentARTStatus = "InActive";
            } else if (returnTOCare == null && terminationDate == null) {
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

    public void setCurrentARTStatus(String currentARTStatus) {
        this.currentARTStatus = currentARTStatus;
    }

    public String getDispensingModality() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> dispensingModalityDateList = new ArrayList();
//        Map<Date, ObsType> dispensingModalityMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 166148 && obsType.getFormId() == 27)
//                dispensingModalityMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date daysOfARVRefilDate : dispensingModalityMap.keySet()){
//            dispensingModalityDateList.add(daysOfARVRefilDate);
//        }
//        if(!dispensingModalityDateList.isEmpty()) {
//            Date latestDate = Collections.max(dispensingModalityDateList);
//            dispensingModality = dispensingModalityMap.get(latestDate).getVariableValue();
//        }
        dispensingModality = getMaxVariableValue(166148,27);
        return dispensingModality;
    }

    public void setDispensingModality(String dispensingModality) {
        this.dispensingModality = dispensingModality;
    }

    public String getFacilityDispensingModality() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> facilityDispensingModalityDateList = new ArrayList();
//        Map<Date, ObsType> facilityDispensingModalityMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 166276 && obsType.getFormId() == 27)
//                facilityDispensingModalityMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date facilityDispensingModalityDate : facilityDispensingModalityMap.keySet()){
//            facilityDispensingModalityDateList.add(facilityDispensingModalityDate);
//        }
//        if(!facilityDispensingModalityDateList.isEmpty()) {
//            Date latestDate = Collections.max(facilityDispensingModalityDateList);
//            facilityDispensingModality = facilityDispensingModalityMap.get(latestDate).getVariableValue();
//        }
        facilityDispensingModality = getMaxVariableValue(166276,27);
        return facilityDispensingModality;
    }

    public void setFacilityDispensingModality(String facilityDispensingModality) {
        this.facilityDispensingModality = facilityDispensingModality;
    }

    public String getDddDispensingModality() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> dddDispensingModalityDateList = new ArrayList();
//        Map<Date, ObsType> dddDispensingModalityMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 166363 && obsType.getFormId() == 27)
//                dddDispensingModalityMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date dddDispensingModalityDate : dddDispensingModalityMap.keySet()){
//            dddDispensingModalityDateList.add(dddDispensingModalityDate);
//        }
//        if(!dddDispensingModalityDateList.isEmpty()) {
//            Date latestDate = Collections.max(dddDispensingModalityDateList);
//            dddDispensingModality = dddDispensingModalityMap.get(latestDate).getVariableValue();
//        }
        dddDispensingModality = getMaxVariableValue(166363,27);
        return dddDispensingModality;
    }

    public void setDddDispensingModality(String dddDispensingModality) {
        this.dddDispensingModality = dddDispensingModality;
    }

    public String getMmdType() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> mmdTypeDateList = new ArrayList();
//        Map<Date, ObsType> mmdTypeMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if(obsType.getConceptId() == 166278 && obsType.getFormId() == 27)
//                mmdTypeMap.put(obsType.getObsDatetime(),obsType);
//        }for (Date mmdTypeDate : mmdTypeMap.keySet()){
//            mmdTypeDateList.add(mmdTypeDate);
//        }
//        if(!mmdTypeDateList.isEmpty()) {
//            Date latestDate = Collections.max(mmdTypeDateList);
//            mmdType = mmdTypeMap.get(latestDate).getVariableValue();
//        }
        mmdType = getMaxVariableValue(166278,27);
        return mmdType;
    }

    public void setMmdType(String mmdType) {
        this.mmdType = mmdType;
    }

    public Date getDateReturnedToCare() {
//        Container radetContainer = container;
//        List<ObsType> dateReturnedToCareList = radetContainer.getMessageData().getObs();
//        List<Date> dateReturnedToCareDateList = new ArrayList();
//        Map<Date, ObsType> dateReturnedToCareMap = new HashMap<>();
//
//        for (ObsType obsType : dateReturnedToCareList) {
//                if (obsType.getConceptId() == 165775)
//                    dateReturnedToCareMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date dateReturnedToCare : dateReturnedToCareMap.keySet()){
//            dateReturnedToCareDateList.add(dateReturnedToCare);
//        }
//        if(!dateReturnedToCareDateList.isEmpty()) {
//            Date latestDate = Collections.max(dateReturnedToCareDateList);
//            dateReturnedToCare = dateReturnedToCareMap.get(latestDate).getValueDatetime();
//        }
        dateReturnedToCare = getValueDateTime(165775);
        return dateReturnedToCare;
    }

    public void setDateReturnedToCare(Date dateReturnedToCare) {
        this.dateReturnedToCare = dateReturnedToCare;
    }

    public Date getDateOfTermination() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> dateOfTerminationList = new ArrayList();
//        Map<Date, ObsType> dateOfTerminationMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 165469)
//                dateOfTerminationMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date dateOfTermination : dateOfTerminationMap.keySet()){
//            dateOfTerminationList.add(dateOfTermination);
//        }
//        if(!dateOfTerminationList.isEmpty()) {
//            Date latestDate = Collections.max(dateOfTerminationList);
//            dateOfTermination = dateOfTerminationMap.get(latestDate).getValueDatetime();
//        }
        dateOfTermination = getValueDateTime(165469);
        return dateOfTermination;
    }

    public void setDateOfTermination(Date dateOfTermination) {
        this.dateOfTermination = dateOfTermination;
    }

    public Date getPharmacyNextAppointment() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> pharmacyNextAppointmentDateList = new ArrayList();
//        Map<Date, ObsType> pharmacyNextAppointmentDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 5096 && obsType.getFormId() == 27 )
//                pharmacyNextAppointmentDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date pharmacyNextAppointmentDate : pharmacyNextAppointmentDateMap.keySet()){
//            pharmacyNextAppointmentDateList.add(pharmacyNextAppointmentDate);
//        }
//        if(!pharmacyNextAppointmentDateList.isEmpty()) {
//            Date latestDate = Collections.max(pharmacyNextAppointmentDateList);
//            pharmacyNextAppointment = pharmacyNextAppointmentDateMap.get(latestDate).getValueDatetime();
//        }
        pharmacyNextAppointment = getMaxValueDateTime(5096,27);
        return pharmacyNextAppointment;
    }

    public void setPharmacyNextAppointment(Date pharmacyNextAppointment) {

        this.pharmacyNextAppointment = pharmacyNextAppointment;
    }

    public Date getClinicalNextAppointment() {Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> clinicalNextAppointmentDateList = new ArrayList();
//        Map<Date, ObsType> clinicalNextAppointmentMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 5096 && obsType.getFormId() == 14 )
//                clinicalNextAppointmentMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date clinicalNextAppointmentDate : clinicalNextAppointmentMap.keySet()){
//            clinicalNextAppointmentDateList.add(clinicalNextAppointmentDate);
//        }
//        if(!clinicalNextAppointmentDateList.isEmpty()) {
//            Date latestDate = Collections.max(clinicalNextAppointmentDateList);
//            clinicalNextAppointment = clinicalNextAppointmentMap.get(latestDate).getValueDatetime();
//        }
        clinicalNextAppointment = getMaxValueDateTime(5096,14);
        return clinicalNextAppointment;
    }

    public void setClinicalNextAppointment(Date clinicalNextAppointment) {
        this.clinicalNextAppointment = clinicalNextAppointment;
    }

//    public Date getLastAppointmentDate() {
//        Container radetContainer = container;
//        List<ObsType> obsTypeList = radetContainer.getMessageData().getObs();
//        List<Date> lastAppointmentDateList = new ArrayList();
//        Map<Date, ObsType> lastAppointmentDateMap = new HashMap<>();
//
//        for (ObsType obsType : obsTypeList) {
//            if (obsType.getConceptId() == 50965096)
//                lastAppointmentDateMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date lastAppointmentDate : lastAppointmentDateMap.keySet()){
//            lastAppointmentDateList.add(lastAppointmentDate);
//        }
//        if(!lastAppointmentDateList.isEmpty()) {
//            Date latestDate = Collections.max(lastAppointmentDateList);
//            lastAppointmentDate = lastAppointmentDateMap.get(latestDate).getValueDatetime();
//        }
//        return lastAppointmentDate;
//    }
//
//    public void setLastAppointmentDate(Date lastAppointmentDate) {
//        this.lastAppointmentDate = lastAppointmentDate;
//    }

    public Integer getCurrentAgeYears() {
        try {
            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();
            //LocalDate dobLocal = LocalDate.of(dob.getYear(),dob.getMonth(),dob.getDay());
            Date today = new Date();


            //LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
            LocalDate start = convertDate(birthDate);
            //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
            LocalDate stop = convertDate(today);
            long years = ChronoUnit.YEARS.between(start, stop);
            currentAgeYears =(int) years;
        }catch (Exception e){
            e.printStackTrace();
        }
        return currentAgeYears;
    }

    public void setCurrentAgeYears(Integer currentAgeYears) {
        this.currentAgeYears = currentAgeYears;
    }

    public Integer getCurrentAgeMonths() {
        try {
            Container radetContainer = container;
            Date birthDate = radetContainer.getMessageData().getDemographics().getBirthdate();
            //LocalDate dobLocal = LocalDate.of(dob.getYear(),dob.getMonth(),dob.getDay());
            Date today = new Date();


            //LocalDate start = LocalDate.of( birthDate.getYear() , birthDate.getMonth() , birthDate.getDay() ) ;
            LocalDate start = convertDate(birthDate);
            //LocalDate stop = LocalDate.of( today.getYear() , today.getMonth() , today.getMonth() ) ;
            LocalDate stop = convertDate(today);
            long months = ChronoUnit.MONTHS.between(start, stop);
            currentAgeMonths =(int) months;
        }catch (Exception e){
            e.printStackTrace();
        }
        return currentAgeMonths;
    }

    public void setCurrentAgeMonths(Integer currentAgeMonths) {
        this.currentAgeMonths = currentAgeMonths;
    }

    public Date getDateOfBirth() {
        try {
            Container radetContainer = container;
            dateOfBirth = radetContainer.getMessageData().getDemographics().getBirthdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMarkAsDeseased() {
        try {
            Container radetContainer = container;
            DemographicsType demographicsType = radetContainer.getMessageData().getDemographics();
            if (demographicsType.getDead() == 1)
                markAsDeseased = "Dead";
        }catch (Exception e){
            e.printStackTrace();
        }
        return markAsDeseased;
    }

    public void setMarkAsDeseased(String markAsDeseased) {
        this.markAsDeseased = markAsDeseased;
    }

    public Date getMarkAsDeseasedDeathDate() {
        try {
            Container radetContainer = container;
            DemographicsType demographicsType = radetContainer.getMessageData().getDemographics();
            if (demographicsType.getDead() == 1)
                markAsDeseasedDeathDate = demographicsType.getDeathDate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return markAsDeseasedDeathDate;
    }

    public void setMarkAsDeseasedDeathDate(Date markAsDeseasedDeathDate) {
        this.markAsDeseasedDeathDate = markAsDeseasedDeathDate;
    }

    public String getRegistrationPhoneNo() {
        return registrationPhoneNo;
    }

    public void setRegistrationPhoneNo(String registrationPhoneNo) {
        this.registrationPhoneNo = registrationPhoneNo;
    }

    public String getNextOfkinPhoneNo() {
//        try {
//            Container radetContainer = container;
//            List<ObsType> nextOfkinPhoneNoList = radetContainer.getMessageData().getObs();
//            List<Date> nextOfkinPhoneNoDateList = new ArrayList();
//            Map<Date, ObsType> nextOfkinPhoneNoMap = new HashMap<>();
//
//            for (ObsType obsType : nextOfkinPhoneNoList) {
//                if (obsType.getConceptId() == 159635)
//                    nextOfkinPhoneNoMap.put(obsType.getObsDatetime(), obsType);
//
//            }
//            for (Date contactPhoneNoDate : nextOfkinPhoneNoMap.keySet()) {
//                nextOfkinPhoneNoDateList.add(contactPhoneNoDate);
//            }
//            if (!nextOfkinPhoneNoDateList.isEmpty()) {
//                Date latestDate = Collections.max(nextOfkinPhoneNoDateList);
//                nextOfkinPhoneNo = nextOfkinPhoneNoMap.get(latestDate).getValueText();
//            }
//        }catch (Exception e){
//
//        }

        nextOfkinPhoneNo = getMaxVariableValue(159635,23);
        return nextOfkinPhoneNo;
    }

    public void setNextOfkinPhoneNo(String nextOfkinPhoneNo) {
        this.nextOfkinPhoneNo = nextOfkinPhoneNo;
    }

    public String getTreatmentSupporterPhoneNo() {
        treatmentSupporterPhoneNo = getMaxVariableValue(160642,23);
        return treatmentSupporterPhoneNo;
    }

    public void setTreatmentSupporterPhoneNo(String treatmentSupporterPhoneNo) {
        this.treatmentSupporterPhoneNo = treatmentSupporterPhoneNo;
    }

    public String getBiometricCaptured() {
        try {
            Container radetContainer = container;
            int patientId = 0;

            if (radetContainer.getMessageData().getPatientBiometrics() != null && radetContainer.getMessageData().getPatientBiometrics().size() > 0) {
                patientId = radetContainer.getMessageData().getPatientBiometrics().get(0).getPatientId();
                biometricCaptured = "Yes";
            } else
                biometricCaptured = "No";
        }catch (Exception e){
            e.printStackTrace();
        }
        return biometricCaptured;
    }

    public void setBiometricCaptured(String biometricCaptured) {
        this.biometricCaptured = biometricCaptured;
    }

    public Date getBiometricCapturedDate() {

        try{
            Container radetContainer = container;
            if (radetContainer.getMessageData().getPatientBiometrics().size() > 0)
                biometricCapturedDate = radetContainer.getMessageData().getPatientBiometrics().get(0).getDateCreated();
        }catch (Exception e){
            e.printStackTrace();
        }
        return biometricCapturedDate;
    }

    public void setBiometricCapturedDate(Date biometricCapturedDate) {
        this.biometricCapturedDate = biometricCapturedDate;
    }

    public String getValidCapture() {
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

    public void setValidCapture(String validCapture) {
        this.validCapture = validCapture;
    }

    public String getCurrentWeight() {
//        Container radetContainer = container;
//        List<ObsType> currentWeightList = radetContainer.getMessageData().getObs();
//        List<Date> currentWeightDateList = new ArrayList();
//        Map<Date, ObsType> currentWeightMap = new HashMap<>();
//
//        for (ObsType obsType : currentWeightList) {
//            if (obsType.getConceptId() == 5089)
//                currentWeightMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date pregnancyStatusDate : currentWeightMap.keySet()){
//            currentWeightDateList.add(pregnancyStatusDate);
//        }
//        if(!currentWeightDateList.isEmpty()) {
//            Date latestDate = Collections.max(currentWeightDateList);
//            currentWeight = currentWeightMap.get(latestDate).getValueNumeric().toString();
//        }
        currentWeight = getMaxVariableValue(5089,14);
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Date getCurrentWeightDate() {
//        Container radetContainer = container;
//        List<ObsType> currentWeightList = radetContainer.getMessageData().getObs();
//        List<Date> currentWeightDateList = new ArrayList();
//        Map<Date, ObsType> currentWeightMap = new HashMap<>();
//
//        for (ObsType obsType : currentWeightList) {
//            if (obsType.getConceptId() == 5089)
//                currentWeightMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date pregnancyStatusDate : currentWeightMap.keySet()){
//            currentWeightDateList.add(pregnancyStatusDate);
//        }
//        if(!currentWeightDateList.isEmpty()) {
//            Date latestDate = Collections.max(currentWeightDateList);
//            currentWeightDate = currentWeightMap.get(latestDate).getObsDatetime();
//        }
        currentWeightDate = getMaxObsDateTime(5089,14);
        return currentWeightDate;
    }

    public void setCurrentWeightDate(Date currentWeightDate) {
        this.currentWeightDate = currentWeightDate;
    }

    public String getTbStatus() {
//        Container radetContainer = container;
//        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
//        List<Date> tbStatusDateList = new ArrayList();
//        Map<Date, ObsType> tbStatusMap = new HashMap<>();
//
//        for (ObsType obsType : tbStatusList) {
//            if (obsType.getConceptId() == 1659 && obsType.getFormId() == 14)
//                tbStatusMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date tbStatusDate : tbStatusMap.keySet()){
//            tbStatusDateList.add(tbStatusDate);
//        }
//        if(!tbStatusDateList.isEmpty()) {
//            Date latestDate = Collections.max(tbStatusDateList);
//            tbStatus = tbStatusMap.get(latestDate).getVariableValue().toString();
//        }
        tbStatus = getMaxVariableValue(1659,14);
        return tbStatus;
    }

    public void setTbStatus(String tbStatus) {
        this.tbStatus = tbStatus;
    }

    public Date getTbStatusDate() {
        Container radetContainer = container;
        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
        List<Date> tbStatusDateList = new ArrayList();
        Map<Date, ObsType> tbStatusMap = new HashMap<>();

        for (ObsType obsType : tbStatusList) {
            if (obsType.getConceptId() == 1659 && obsType.getFormId() == 14)
                tbStatusMap.put(obsType.getObsDatetime(), obsType);

        }for (Date tbStatusDate : tbStatusMap.keySet()){
            tbStatusDateList.add(tbStatusDate);
        }
        if(!tbStatusDateList.isEmpty()) {
            Date latestDate = Collections.max(tbStatusDateList);
            tbStatusDate = tbStatusMap.get(latestDate).getObsDatetime();
        }
        tbStatusDate = getMaxObsDateTime(1659,14);
        return tbStatusDate;
    }

    public void setTbStatusDate(Date tbStatusDate) {
        this.tbStatusDate = tbStatusDate;
    }

    public Date getInhStartDate() {
//        Container radetContainer = container;
//        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
//        List<Date> tbStatusDateList = new ArrayList();
//        Map<Date, ObsType> tbStatusMap = new HashMap<>();
//
//        for (ObsType obsType : tbStatusList) {
//            if (obsType.getConceptId() == 164852 && obsType.getFormId() == 56)
//                tbStatusMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date tbStatusDate : tbStatusMap.keySet()){
//            tbStatusDateList.add(tbStatusDate);
//        }
//        if(!tbStatusDateList.isEmpty()) {
//            Date latestDate = Collections.max(tbStatusDateList);
//            inhStartDate = tbStatusMap.get(latestDate).getValueDatetime();
//        }
        inhStartDate = getMaxValueDateTime(164852,56);
        return inhStartDate;
    }

    public void setInhStartDate(Date inhStartDate) {
        this.inhStartDate = inhStartDate;
    }

    public Date getInhStopDate() {
//        Container radetContainer = container;
//        List<ObsType> tbStatusList = radetContainer.getMessageData().getObs();
//        List<Date> tbStatusDateList = new ArrayList();
//        Map<Date, ObsType> tbStatusMap = new HashMap<>();
//
//        for (ObsType obsType : tbStatusList) {
//            if (obsType.getConceptId() == 166096 && obsType.getFormId() == 56)
//                tbStatusMap.put(obsType.getObsDatetime(), obsType);
//
//        }for (Date tbStatusDate : tbStatusMap.keySet()){
//            tbStatusDateList.add(tbStatusDate);
//        }
//        if(!tbStatusDateList.isEmpty()) {
//            Date latestDate = Collections.max(tbStatusDateList);
//            inhStopDate = tbStatusMap.get(latestDate).getValueDatetime();
//        }
        inhStopDate = getMaxValueDateTime(166096,56);
        return inhStopDate;
    }

    public void setInhStopDate(Date inhStopDate) {
        this.inhStopDate = inhStopDate;
    }

    public Date getLastINHDispensedDate() {
        try {
            Container radetContainer = container;
            List<ObsType> lastINHDispensedDateList = radetContainer.getMessageData().getObs();
            List<Date> tbStatusDateList = new ArrayList();
            Map<Date, ObsType> lastINHDispensedDateMap = new HashMap<>();

            for (ObsType obsType : lastINHDispensedDateList) {
                if (obsType.getConceptId() == 165727 && obsType.getFormId() == 27 && obsType.getValueCoded() == 1679)
                    lastINHDispensedDateMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date lastINHDispensedDate : lastINHDispensedDateMap.keySet()) {
                tbStatusDateList.add(lastINHDispensedDate);
            }
            if (!tbStatusDateList.isEmpty()) {
                Date latestDate = Collections.max(tbStatusDateList);
                lastINHDispensedDate = lastINHDispensedDateMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lastINHDispensedDate;
    }

    public void setLastINHDispensedDate(Date lastINHDispensedDate) {
        this.lastINHDispensedDate = lastINHDispensedDate;
    }

    public Date getTbTreatmentStartDate() {
        tbTreatmentStartDate = getMaxValueDateTime(1113,56);
        return tbTreatmentStartDate;
    }

    public void setTbTreatmentStartDate(Date tbTreatmentStartDate) {
        this.tbTreatmentStartDate = tbTreatmentStartDate;
    }

    public Date getTbTreatmentStopDate() {
        tbTreatmentStopDate = getMaxValueDateTime(159431,56);
        return tbTreatmentStopDate;
    }

    public void setTbTreatmentStopDate(Date tbTreatmentStopDate) {
        this.tbTreatmentStopDate = tbTreatmentStopDate;
    }

    public Date getLastViralLoadSampleCollectionFormDate() {
        lastViralLoadSampleCollectionFormDate = getEncounterDateTime(67);
        return lastViralLoadSampleCollectionFormDate;
    }

    public void setLastViralLoadSampleCollectionFormDate(Date lastViralLoadSampleCollectionFormDate) {
        this.lastViralLoadSampleCollectionFormDate = lastViralLoadSampleCollectionFormDate;
    }

    public Date getLastSampleTakenDate() {
        lastSampleTakenDate = getMaxValueDateTime(159951,21);
        return lastSampleTakenDate;
    }

    public void setLastSampleTakenDate(Date lastSampleTakenDate) {
        this.lastSampleTakenDate = lastSampleTakenDate;
    }

    public Date getOtzEnrollmentDate() {
        otzEnrollmentDate = getEncounterDateTime(73);
        return otzEnrollmentDate;
    }

    public void setOtzEnrollmentDate(Date otzEnrollmentDate) {
        this.otzEnrollmentDate = otzEnrollmentDate;
    }

    public Date getOtzOutcomeDate() {
        otzOutcomeDate = getMaxValueDateTime(166008,73);
        return otzOutcomeDate;
    }

    public void setOtzOutcomeDate(Date otzOutcomeDate) {
        this.otzOutcomeDate = otzOutcomeDate;
    }

    public Date getEnrollmentDate() {
        enrollmentDate = getEncounterDateTime(23);
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getInitialFirstLineRegimen() {

        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> InitialFirstLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> InitialFirstLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == 164506 && obsType.getFormId() == 27) || (obsType.getConceptId() == 164507 && obsType.getFormId() == 27))
                    InitialFirstLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date InitialFirstLineRegimenDate : InitialFirstLineRegimenMap.keySet()) {
                InitialFirstLineRegimenDateList.add(InitialFirstLineRegimenDate);
            }
            if (!InitialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(InitialFirstLineRegimenDateList);
                InitialFirstLineRegimen = InitialFirstLineRegimenMap.get(latestDate).getVariableValue();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return InitialFirstLineRegimen;
    }

    public void setInitialFirstLineRegimen(String initialFirstLineRegimen) {
        InitialFirstLineRegimen = initialFirstLineRegimen;
    }

    public Date getInitialFirstLineRegimenDate() {
        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> InitialFirstLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> InitialFirstLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == 164506 && obsType.getFormId() == 27) || (obsType.getConceptId() == 164507 && obsType.getFormId() == 27))
                    InitialFirstLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date InitialFirstLineRegimenDate : InitialFirstLineRegimenMap.keySet()) {
                InitialFirstLineRegimenDateList.add(InitialFirstLineRegimenDate);
            }
            if (!InitialFirstLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(InitialFirstLineRegimenDateList);
                initialFirstLineRegimenDate = InitialFirstLineRegimenMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return initialFirstLineRegimenDate;
    }

    public void setInitialFirstLineRegimenDate(Date initialFirstLineRegimenDate) {
        this.initialFirstLineRegimenDate = initialFirstLineRegimenDate;
    }

    public String getInitialSecondLineRegimen() {
        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> initialSecondLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> initialSecondLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == 164513 && obsType.getFormId() == 27) || (obsType.getConceptId() == 164514 && obsType.getFormId() == 27))
                    initialSecondLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date initialSecondLineRegimenDate : initialSecondLineRegimenMap.keySet()) {
                initialSecondLineRegimenDateList.add(initialSecondLineRegimenDate);
            }
            if (!initialSecondLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(initialSecondLineRegimenDateList);
                initialSecondLineRegimen = initialSecondLineRegimenMap.get(latestDate).getVariableValue();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return initialSecondLineRegimen;
    }

    public void setInitialSecondLineRegimen(String initialSecondLineRegimen) {
        this.initialSecondLineRegimen = initialSecondLineRegimen;
    }

    public Date getInitialSecondLineRegimenDate() {
        try {
            Container radetContainer = container;
            List<ObsType> obsList = radetContainer.getMessageData().getObs();
            List<Date> initialSecondLineRegimenDateList = new ArrayList();
            Map<Date, ObsType> initialSecondLineRegimenMap = new HashMap<>();


            for (ObsType obsType : obsList) {
                if ((obsType.getConceptId() == 164513 && obsType.getFormId() == 27) || (obsType.getConceptId() == 164514 && obsType.getFormId() == 27))
                    initialSecondLineRegimenMap.put(obsType.getObsDatetime(), obsType);

            }
            for (Date initialSecondLineRegimenDate : initialSecondLineRegimenMap.keySet()) {
                initialSecondLineRegimenDateList.add(initialSecondLineRegimenDate);
            }
            if (!initialSecondLineRegimenDateList.isEmpty()) {
                Date latestDate = Collections.min(initialSecondLineRegimenDateList);
                initialSecondLineRegimenDate = initialSecondLineRegimenMap.get(latestDate).getObsDatetime();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return initialSecondLineRegimenDate;
    }

    public void setInitialSecondLineRegimenDate(Date initialSecondLineRegimenDate) {
        this.initialSecondLineRegimenDate = initialSecondLineRegimenDate;
    }

    public Date getLastPickupDatePreviousQuarter() {
        return lastPickupDatePreviousQuarter;
    }

    public void setLastPickupDatePreviousQuarter(Date lastPickupDatePreviousQuarter) {
        this.lastPickupDatePreviousQuarter = lastPickupDatePreviousQuarter;
    }

    public String getDrugDurationPreviousQuarter() {
        return drugDurationPreviousQuarter;
    }

    public void setDrugDurationPreviousQuarter(String drugDurationPreviousQuarter) {
        this.drugDurationPreviousQuarter = drugDurationPreviousQuarter;
    }

    public String getPatientOutcomePreviousQuarter() {
        return patientOutcomePreviousQuarter;
    }

    public void setPatientOutcomePreviousQuarter(String patientOutcomePreviousQuarter) {
        this.patientOutcomePreviousQuarter = patientOutcomePreviousQuarter;
    }

    public Date getPatientOutcomeDatePreviousQuarter() {
        return patientOutcomeDatePreviousQuarter;
    }

    public void setPatientOutcomeDatePreviousQuarter(Date patientOutcomeDatePreviousQuarter) {
        this.patientOutcomeDatePreviousQuarter = patientOutcomeDatePreviousQuarter;
    }

    public String getArtStatusPreviousQuarter() {
        return artStatusPreviousQuarter;
    }

    public void setArtStatusPreviousQuarter(String artStatusPreviousQuarter) {
        this.artStatusPreviousQuarter = artStatusPreviousQuarter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTouchTime() {
        Container radetContainer = container;
        touchTime = radetContainer.getMessageHeader().getTouchTime();
        return touchTime;
    }

    public void setTouchTime(Date touchTime) {

        this.touchTime = touchTime;
    }

    public String getPatientUuid() {
        Container radetContainer = container;
        patientUuid = container.getMessageData().getDemographics().getPatientUuid();
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    @Override
    public String toString() {
        return "Radet{" +
                "id=" + id +
                ", datimCode='" + datimCode + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", patientID=" + patientID +
                ", patientUniqueID='" + patientUniqueID + '\'' +
                ", patientHospitalNo='" + patientHospitalNo + '\'' +
                ", ancNo='" + ancNo + '\'' +
                ", htsNo='" + htsNo + '\'' +
                ", sex='" + sex + '\'' +
                ", ageAtStartOfARTYears=" + ageAtStartOfARTYears +
                ", ageAtStartOfARTMonths=" + ageAtStartOfARTMonths +
                ", careEntryPoint='" + careEntryPoint + '\'' +
                ", kpType='" + kpType + '\'' +
                ", monthsOnArt='" + monthsOnArt + '\'' +
                ", dateTransferredIn=" + dateTransferredIn +
                ", transferInStatus='" + transferInStatus + '\'' +
                ", artStartDate=" + artStartDate +
                ", lastPickupDate=" + lastPickupDate +
                ", lastVisitDate=" + lastVisitDate +
                ", daysOfARVRefil='" + daysOfARVRefil + '\'' +
                ", pillBalance='" + pillBalance + '\'' +
                ", initialRegimenLine='" + initialRegimenLine + '\'' +
                ", initialRegimen='" + initialRegimen + '\'' +
                ", initialCd4Count='" + initialCd4Count + '\'' +
                ", initialCd4CountDate=" + initialCd4CountDate +
                ", currentCd4Count='" + currentCd4Count + '\'' +
                ", currentCd4CountDate=" + currentCd4CountDate +
                ", lastEacDate=" + lastEacDate +
                ", currentRegimenLine='" + currentRegimenLine + '\'' +
                ", currentRegimen='" + currentRegimen + '\'' +
                ", pregnancyStatus='" + pregnancyStatus + '\'' +
                ", pregnancyStatusDate=" + pregnancyStatusDate +
                ", edd=" + edd +
                ", lastDeliveryDate=" + lastDeliveryDate +
                ", lmp=" + lmp +
                ", estimatedGestationAgeWeeks='" + estimatedGestationAgeWeeks + '\'' +
                ", currentViralLoad='" + currentViralLoad + '\'' +
                ", viralLoadEncounterDate=" + viralLoadEncounterDate +
                ", viralLoadSampleCollectionDate=" + viralLoadSampleCollectionDate +
                ", viralLoadReportedDate=" + viralLoadReportedDate +
                ", resultDate=" + resultDate +
                ", assayDate=" + assayDate +
                ", approvalDate=" + approvalDate +
                ", viralLoadIndication='" + viralLoadIndication + '\'' +
                ", patientOutcome='" + patientOutcome + '\'' +
                ", patientOutcomeDate=" + patientOutcomeDate +
                ", currentARTStatus='" + currentARTStatus + '\'' +
                ", dispensingModality='" + dispensingModality + '\'' +
                ", facilityDispensingModality='" + facilityDispensingModality + '\'' +
                ", dddDispensingModality='" + dddDispensingModality + '\'' +
                ", mmdType='" + mmdType + '\'' +
                ", dateReturnedToCare=" + dateReturnedToCare +
                ", dateOfTermination=" + dateOfTermination +
                ", pharmacyNextAppointment=" + pharmacyNextAppointment +
                ", clinicalNextAppointment=" + clinicalNextAppointment +
                ", currentAgeYears=" + currentAgeYears +
                ", currentAgeMonths=" + currentAgeMonths +
                ", dateOfBirth=" + dateOfBirth +
                ", markAsDeseased='" + markAsDeseased + '\'' +
                ", markAsDeseasedDeathDate=" + markAsDeseasedDeathDate +
                ", registrationPhoneNo='" + registrationPhoneNo + '\'' +
                ", nextOfkinPhoneNo='" + nextOfkinPhoneNo + '\'' +
                ", treatmentSupporterPhoneNo='" + treatmentSupporterPhoneNo + '\'' +
                ", biometricCaptured='" + biometricCaptured + '\'' +
                ", biometricCapturedDate=" + biometricCapturedDate +
                ", validCapture='" + validCapture + '\'' +
                ", currentWeight='" + currentWeight + '\'' +
                ", currentWeightDate=" + currentWeightDate +
                ", tbStatus='" + tbStatus + '\'' +
                ", tbStatusDate=" + tbStatusDate +
                ", inhStartDate=" + inhStartDate +
                ", inhStopDate=" + inhStopDate +
                ", lastINHDispensedDate=" + lastINHDispensedDate +
                ", tbTreatmentStartDate=" + tbTreatmentStartDate +
                ", tbTreatmentStopDate=" + tbTreatmentStopDate +
                ", lastViralLoadSampleCollectionFormDate=" + lastViralLoadSampleCollectionFormDate +
                ", lastSampleTakenDate=" + lastSampleTakenDate +
                ", otzEnrollmentDate=" + otzEnrollmentDate +
                ", otzOutcomeDate=" + otzOutcomeDate +
                ", enrollmentDate=" + enrollmentDate +
                ", InitialFirstLineRegimen='" + InitialFirstLineRegimen + '\'' +
                ", initialFirstLineRegimenDate=" + initialFirstLineRegimenDate +
                ", initialSecondLineRegimen='" + initialSecondLineRegimen + '\'' +
                ", initialSecondLineRegimenDate=" + initialSecondLineRegimenDate +
                ", lastPickupDatePreviousQuarter=" + lastPickupDatePreviousQuarter +
                ", drugDurationPreviousQuarter='" + drugDurationPreviousQuarter + '\'' +
                ", patientOutcomePreviousQuarter='" + patientOutcomePreviousQuarter + '\'' +
                ", patientOutcomeDatePreviousQuarter=" + patientOutcomeDatePreviousQuarter +
                ", artStatusPreviousQuarter='" + artStatusPreviousQuarter + '\'' +
                ", touchTime=" + touchTime +
                ", patientUuid='" + patientUuid + '\'' +
                ", container=" + container +
                '}';
    }
}
