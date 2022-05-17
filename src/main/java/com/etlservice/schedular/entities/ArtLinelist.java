/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MORRISON.I
 */
@Entity
@Table(name = "art_linelist")
@NamedQueries({
    @NamedQuery(name = "ArtLinelist.findAll", query = "SELECT a FROM ArtLinelist a")})
public class ArtLinelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "state_name")
    private String stateName;
    @Column(name = "lga_name")
    private String lgaName;
    @Column(name = "datim_code")
    private String datimCode;
    @Column(name = "facility_name")
    private String facilityName;
    @Column(name = "patient_timestamp")
    @Temporal(TemporalType.DATE)
    private Date patientTimestamp;
    @Column(name = "patient_id")
    private BigInteger patientId;
    @Column(name = "patient_uuid")
    private String patientUuid;
    @Column(name = "patient_unique_id")
    private String patientUniqueId;
    @Column(name = "patient_hospital_no")
    private String patientHospitalNo;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age_at_start_of_art_years")
    private BigInteger ageAtStartOfArtYears;
    @Column(name = "age_at_start_of_art_months")
    private BigInteger ageAtStartOfArtMonths;
    @Column(name = "care_entry_points")
    private String careEntryPoints;
    @Column(name = "kp_type")
    private String kpType;
    @Column(name = "months_on_art")
    private BigInteger monthsOnArt;
    @Column(name = "date_transferred_in")
    @Temporal(TemporalType.DATE)
    private Date dateTransferredIn;
    @Column(name = "transfer_in_status")
    private String transferInStatus;
    @Column(name = "art_start_date")
    @Temporal(TemporalType.DATE)
    private Date artStartDate;
    @Column(name = "last_pickup_date")
    @Temporal(TemporalType.DATE)
    private Date lastPickupDate;
    @Column(name = "last_visit_date")
    @Temporal(TemporalType.DATE)
    private Date lastVisitDate;
    @Column(name = "days_of_arv_refil")
    private BigInteger daysOfArvRefil;
    @Column(name = "pill_balance")
    private BigInteger pillBalance;
    @Column(name = "initial_regimen_line")
    private String initialRegimenLine;
    @Column(name = "initial_regimen")
    private String initialRegimen;
    @Column(name = "initial_cd4_count")
    private BigInteger initialCd4Count;
    @Column(name = "initial_cd4_count_date")
    @Temporal(TemporalType.DATE)
    private Date initialCd4CountDate;
    @Column(name = "current_cd4_count")
    private BigInteger currentCd4Count;
    @Column(name = "current_cd4_count_date")
    @Temporal(TemporalType.DATE)
    private Date currentCd4CountDate;
    @Column(name = "last_eac_date")
    @Temporal(TemporalType.DATE)
    private Date lastEacDate;
    @Column(name = "current_regimen_line")
    private String currentRegimenLine;
    @Column(name = "current_regimen")
    private String currentRegimen;
    @Column(name = "pregnancy_status")
    private String pregnancyStatus;
    @Column(name = "pregnancy_status_date")
    @Temporal(TemporalType.DATE)
    private Date pregnancyStatusDate;
    @Column(name = "edd")
    @Temporal(TemporalType.DATE)
    private Date edd;
    @Column(name = "last_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date lastDeliveryDate;
    @Column(name = "lmp")
    @Temporal(TemporalType.DATE)
    private Date lmp;
    @Column(name = "gestation_age_weeks")
    private BigInteger gestationAgeWeeks;
    @Column(name = "current_viral_load")
    private BigInteger currentViralLoad;
    @Column(name = "viral_load_encounter_date")
    @Temporal(TemporalType.DATE)
    private Date viralLoadEncounterDate;
    @Column(name = "viral_load_sample_collection_date")
    @Temporal(TemporalType.DATE)
    private Date viralLoadSampleCollectionDate;
    @Column(name = "viral_load_reported_date")
    @Temporal(TemporalType.DATE)
    private Date viralLoadReportedDate;
    @Column(name = "result_date")
    @Temporal(TemporalType.DATE)
    private Date resultDate;
    @Column(name = "assay_date")
    @Temporal(TemporalType.DATE)
    private Date assayDate;
    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Column(name = "viral_load_indication")
    private String viralLoadIndication;
    @Column(name = "patient_outcome")
    private String patientOutcome;
    @Column(name = "patient_outcome_date")
    private String patientOutcomeDate;
    @Column(name = "current_art_status")
    private String currentArtStatus;
    @Column(name = "dispensing_modality")
    private String dispensingModality;
    @Column(name = "facility_dispensing_modality")
    private String facilityDispensingModality;
    @Column(name = "ddd_dispensing_modality")
    private String dddDispensingModality;
    @Column(name = "mmd_type")
    private String mmdType;
    @Column(name = "date_returned_to_care")
    @Temporal(TemporalType.DATE)
    private Date dateReturnedToCare;
    @Column(name = "date_of_termination")
    @Temporal(TemporalType.DATE)
    private Date dateOfTermination;
    @Column(name = "pharmacy_next_appointment")
    @Temporal(TemporalType.DATE)
    private Date pharmacyNextAppointment;
    @Column(name = "clinical_next_appointment")
    @Temporal(TemporalType.DATE)
    private Date clinicalNextAppointment;
    @Column(name = "current_age_yrs")
    private BigInteger currentAgeYrs;
    @Column(name = "current_age_months")
    private BigInteger currentAgeMonths;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "mark_as_diseased")
    private String markAsDiseased;
    @Column(name = "mark_as_diseased_date")
    @Temporal(TemporalType.DATE)
    private Date markAsDiseasedDate;
    @Column(name = "registration_phoneno")
    private String registrationPhoneno;
    @Column(name = "next_of_kin_phoneno")
    private String nextOfKinPhoneno;
    @Column(name = "treatment_supporter_phoneno")
    private String treatmentSupporterPhoneno;
    @Column(name = "biometric_captured")
    private String biometricCaptured;
    @Column(name = "biometric_captured_date")
    @Temporal(TemporalType.DATE)
    private Date biometricCapturedDate;
    @Column(name = "valid_capture")
    private String validCapture;
    @Column(name = "current_weight")
    private BigInteger currentWeight;
    @Column(name = "current_weight_date")
    @Temporal(TemporalType.DATE)
    private Date currentWeightDate;
    @Column(name = "tb_status")
    private String tbStatus;
    @Column(name = "tb_status_date")
    @Temporal(TemporalType.DATE)
    private Date tbStatusDate;
    @Column(name = "baseline_inh_start_date")
    @Temporal(TemporalType.DATE)
    private Date baselineInhStartDate;
    @Column(name = "baseline_inh_stop_date")
    @Temporal(TemporalType.DATE)
    private Date baselineInhStopDate;
    @Column(name = "current_inh_start_date")
    @Temporal(TemporalType.DATE)
    private Date currentInhStartDate;
    @Column(name = "current_inh_stop_date")
    @Temporal(TemporalType.DATE)
    private Date currentInhStopDate;
    @Column(name = "current_inh_outcome")
    private String currentInhOutcome;
    @Column(name = "last_inh_dispensed_date")
    @Temporal(TemporalType.DATE)
    private Date lastInhDispensedDate;
    @Column(name = "baseline_tb_treatment_stop_date")
    @Temporal(TemporalType.DATE)
    private Date baselineTbTreatmentStopDate;
    @Column(name = "last_viral_load_sample_collection_form_date")
    @Temporal(TemporalType.DATE)
    private Date lastViralLoadSampleCollectionFormDate;
    @Column(name = "last_sample_taken_date")
    @Temporal(TemporalType.DATE)
    private Date lastSampleTakenDate;
    @Column(name = "otz_enrollment_date")
    @Temporal(TemporalType.DATE)
    private Date otzEnrollmentDate;
    @Column(name = "otz_outcome_date")
    @Temporal(TemporalType.DATE)
    private Date otzOutcomeDate;
    @Column(name = "enrollment_date")
    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;
    @Column(name = "initial_first_line_regimen")
    private String initialFirstLineRegimen;
    @Column(name = "initial_first_line_regimen_date")
    @Temporal(TemporalType.DATE)
    private Date initialFirstLineRegimenDate;
    @Column(name = "initial_second_line_regimen_date")
    @Temporal(TemporalType.DATE)
    private Date initialSecondLineRegimenDate;
    @Column(name = "last_pickup_date_previous_quarter")
    @Temporal(TemporalType.DATE)
    private Date lastPickupDatePreviousQuarter;
    @Column(name = "drug_duration_previous_quarter")
    private BigInteger drugDurationPreviousQuarter;
    @Column(name = "patient_outcome_previous_quarter")
    private String patientOutcomePreviousQuarter;
    @Column(name = "patient_outcome_date_previous_quater")
    @Temporal(TemporalType.DATE)
    private Date patientOutcomeDatePreviousQuater;
    @Column(name = "art_status_previous_quater")
    private String artStatusPreviousQuater;

    public ArtLinelist() {
    }

    public ArtLinelist(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getLgaName() {
        return lgaName;
    }

    public void setLgaName(String lgaName) {
        this.lgaName = lgaName;
    }

    public String getDatimCode() {
        return datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Date getPatientTimestamp() {
        return patientTimestamp;
    }

    public void setPatientTimestamp(Date patientTimestamp) {
        this.patientTimestamp = patientTimestamp;
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        this.patientId = patientId;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    public String getPatientUniqueId() {
        return patientUniqueId;
    }

    public void setPatientUniqueId(String patientUniqueId) {
        this.patientUniqueId = patientUniqueId;
    }

    public String getPatientHospitalNo() {
        return patientHospitalNo;
    }

    public void setPatientHospitalNo(String patientHospitalNo) {
        this.patientHospitalNo = patientHospitalNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigInteger getAgeAtStartOfArtYears() {
        return ageAtStartOfArtYears;
    }

    public void setAgeAtStartOfArtYears(BigInteger ageAtStartOfArtYears) {
        this.ageAtStartOfArtYears = ageAtStartOfArtYears;
    }

    public BigInteger getAgeAtStartOfArtMonths() {
        return ageAtStartOfArtMonths;
    }

    public void setAgeAtStartOfArtMonths(BigInteger ageAtStartOfArtMonths) {
        this.ageAtStartOfArtMonths = ageAtStartOfArtMonths;
    }

    public String getCareEntryPoints() {
        return careEntryPoints;
    }

    public void setCareEntryPoints(String careEntryPoints) {
        this.careEntryPoints = careEntryPoints;
    }

    public String getKpType() {
        return kpType;
    }

    public void setKpType(String kpType) {
        this.kpType = kpType;
    }

    public BigInteger getMonthsOnArt() {
        return monthsOnArt;
    }

    public void setMonthsOnArt(BigInteger monthsOnArt) {
        this.monthsOnArt = monthsOnArt;
    }

    public Date getDateTransferredIn() {
        return dateTransferredIn;
    }

    public void setDateTransferredIn(Date dateTransferredIn) {
        this.dateTransferredIn = dateTransferredIn;
    }

    public String getTransferInStatus() {
        return transferInStatus;
    }

    public void setTransferInStatus(String transferInStatus) {
        this.transferInStatus = transferInStatus;
    }

    public Date getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(Date artStartDate) {
        this.artStartDate = artStartDate;
    }

    public Date getLastPickupDate() {
        return lastPickupDate;
    }

    public void setLastPickupDate(Date lastPickupDate) {
        this.lastPickupDate = lastPickupDate;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public BigInteger getDaysOfArvRefil() {
        return daysOfArvRefil;
    }

    public void setDaysOfArvRefil(BigInteger daysOfArvRefil) {
        this.daysOfArvRefil = daysOfArvRefil;
    }

    public BigInteger getPillBalance() {
        return pillBalance;
    }

    public void setPillBalance(BigInteger pillBalance) {
        this.pillBalance = pillBalance;
    }

    public String getInitialRegimenLine() {
        return initialRegimenLine;
    }

    public void setInitialRegimenLine(String initialRegimenLine) {
        this.initialRegimenLine = initialRegimenLine;
    }

    public String getInitialRegimen() {
        return initialRegimen;
    }

    public void setInitialRegimen(String initialRegimen) {
        this.initialRegimen = initialRegimen;
    }

    public BigInteger getInitialCd4Count() {
        return initialCd4Count;
    }

    public void setInitialCd4Count(BigInteger initialCd4Count) {
        this.initialCd4Count = initialCd4Count;
    }

    public Date getInitialCd4CountDate() {
        return initialCd4CountDate;
    }

    public void setInitialCd4CountDate(Date initialCd4CountDate) {
        this.initialCd4CountDate = initialCd4CountDate;
    }

    public BigInteger getCurrentCd4Count() {
        return currentCd4Count;
    }

    public void setCurrentCd4Count(BigInteger currentCd4Count) {
        this.currentCd4Count = currentCd4Count;
    }

    public Date getCurrentCd4CountDate() {
        return currentCd4CountDate;
    }

    public void setCurrentCd4CountDate(Date currentCd4CountDate) {
        this.currentCd4CountDate = currentCd4CountDate;
    }

    public Date getLastEacDate() {
        return lastEacDate;
    }

    public void setLastEacDate(Date lastEacDate) {
        this.lastEacDate = lastEacDate;
    }

    public String getCurrentRegimenLine() {
        return currentRegimenLine;
    }

    public void setCurrentRegimenLine(String currentRegimenLine) {
        this.currentRegimenLine = currentRegimenLine;
    }

    public String getCurrentRegimen() {
        return currentRegimen;
    }

    public void setCurrentRegimen(String currentRegimen) {
        this.currentRegimen = currentRegimen;
    }

    public String getPregnancyStatus() {
        return pregnancyStatus;
    }

    public void setPregnancyStatus(String pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

    public Date getPregnancyStatusDate() {
        return pregnancyStatusDate;
    }

    public void setPregnancyStatusDate(Date pregnancyStatusDate) {
        this.pregnancyStatusDate = pregnancyStatusDate;
    }

    public Date getEdd() {
        return edd;
    }

    public void setEdd(Date edd) {
        this.edd = edd;
    }

    public Date getLastDeliveryDate() {
        return lastDeliveryDate;
    }

    public void setLastDeliveryDate(Date lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }

    public Date getLmp() {
        return lmp;
    }

    public void setLmp(Date lmp) {
        this.lmp = lmp;
    }

    public BigInteger getGestationAgeWeeks() {
        return gestationAgeWeeks;
    }

    public void setGestationAgeWeeks(BigInteger gestationAgeWeeks) {
        this.gestationAgeWeeks = gestationAgeWeeks;
    }

    public BigInteger getCurrentViralLoad() {
        return currentViralLoad;
    }

    public void setCurrentViralLoad(BigInteger currentViralLoad) {
        this.currentViralLoad = currentViralLoad;
    }

    public Date getViralLoadEncounterDate() {
        return viralLoadEncounterDate;
    }

    public void setViralLoadEncounterDate(Date viralLoadEncounterDate) {
        this.viralLoadEncounterDate = viralLoadEncounterDate;
    }

    public Date getViralLoadSampleCollectionDate() {
        return viralLoadSampleCollectionDate;
    }

    public void setViralLoadSampleCollectionDate(Date viralLoadSampleCollectionDate) {
        this.viralLoadSampleCollectionDate = viralLoadSampleCollectionDate;
    }

    public Date getViralLoadReportedDate() {
        return viralLoadReportedDate;
    }

    public void setViralLoadReportedDate(Date viralLoadReportedDate) {
        this.viralLoadReportedDate = viralLoadReportedDate;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Date getAssayDate() {
        return assayDate;
    }

    public void setAssayDate(Date assayDate) {
        this.assayDate = assayDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getViralLoadIndication() {
        return viralLoadIndication;
    }

    public void setViralLoadIndication(String viralLoadIndication) {
        this.viralLoadIndication = viralLoadIndication;
    }

    public String getPatientOutcome() {
        return patientOutcome;
    }

    public void setPatientOutcome(String patientOutcome) {
        this.patientOutcome = patientOutcome;
    }

    public String getPatientOutcomeDate() {
        return patientOutcomeDate;
    }

    public void setPatientOutcomeDate(String patientOutcomeDate) {
        this.patientOutcomeDate = patientOutcomeDate;
    }

    public String getCurrentArtStatus() {
        return currentArtStatus;
    }

    public void setCurrentArtStatus(String currentArtStatus) {
        this.currentArtStatus = currentArtStatus;
    }

    public String getDispensingModality() {
        return dispensingModality;
    }

    public void setDispensingModality(String dispensingModality) {
        this.dispensingModality = dispensingModality;
    }

    public String getFacilityDispensingModality() {
        return facilityDispensingModality;
    }

    public void setFacilityDispensingModality(String facilityDispensingModality) {
        this.facilityDispensingModality = facilityDispensingModality;
    }

    public String getDddDispensingModality() {
        return dddDispensingModality;
    }

    public void setDddDispensingModality(String dddDispensingModality) {
        this.dddDispensingModality = dddDispensingModality;
    }

    public String getMmdType() {
        return mmdType;
    }

    public void setMmdType(String mmdType) {
        this.mmdType = mmdType;
    }

    public Date getDateReturnedToCare() {
        return dateReturnedToCare;
    }

    public void setDateReturnedToCare(Date dateReturnedToCare) {
        this.dateReturnedToCare = dateReturnedToCare;
    }

    public Date getDateOfTermination() {
        return dateOfTermination;
    }

    public void setDateOfTermination(Date dateOfTermination) {
        this.dateOfTermination = dateOfTermination;
    }

    public Date getPharmacyNextAppointment() {
        return pharmacyNextAppointment;
    }

    public void setPharmacyNextAppointment(Date pharmacyNextAppointment) {
        this.pharmacyNextAppointment = pharmacyNextAppointment;
    }

    public Date getClinicalNextAppointment() {
        return clinicalNextAppointment;
    }

    public void setClinicalNextAppointment(Date clinicalNextAppointment) {
        this.clinicalNextAppointment = clinicalNextAppointment;
    }

    public BigInteger getCurrentAgeYrs() {
        return currentAgeYrs;
    }

    public void setCurrentAgeYrs(BigInteger currentAgeYrs) {
        this.currentAgeYrs = currentAgeYrs;
    }

    public BigInteger getCurrentAgeMonths() {
        return currentAgeMonths;
    }

    public void setCurrentAgeMonths(BigInteger currentAgeMonths) {
        this.currentAgeMonths = currentAgeMonths;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMarkAsDiseased() {
        return markAsDiseased;
    }

    public void setMarkAsDiseased(String markAsDiseased) {
        this.markAsDiseased = markAsDiseased;
    }

    public Date getMarkAsDiseasedDate() {
        return markAsDiseasedDate;
    }

    public void setMarkAsDiseasedDate(Date markAsDiseasedDate) {
        this.markAsDiseasedDate = markAsDiseasedDate;
    }

    public String getRegistrationPhoneno() {
        return registrationPhoneno;
    }

    public void setRegistrationPhoneno(String registrationPhoneno) {
        this.registrationPhoneno = registrationPhoneno;
    }

    public String getNextOfKinPhoneno() {
        return nextOfKinPhoneno;
    }

    public void setNextOfKinPhoneno(String nextOfKinPhoneno) {
        this.nextOfKinPhoneno = nextOfKinPhoneno;
    }

    public String getTreatmentSupporterPhoneno() {
        return treatmentSupporterPhoneno;
    }

    public void setTreatmentSupporterPhoneno(String treatmentSupporterPhoneno) {
        this.treatmentSupporterPhoneno = treatmentSupporterPhoneno;
    }

    public String getBiometricCaptured() {
        return biometricCaptured;
    }

    public void setBiometricCaptured(String biometricCaptured) {
        this.biometricCaptured = biometricCaptured;
    }

    public Date getBiometricCapturedDate() {
        return biometricCapturedDate;
    }

    public void setBiometricCapturedDate(Date biometricCapturedDate) {
        this.biometricCapturedDate = biometricCapturedDate;
    }

    public String getValidCapture() {
        return validCapture;
    }

    public void setValidCapture(String validCapture) {
        this.validCapture = validCapture;
    }

    public BigInteger getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(BigInteger currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Date getCurrentWeightDate() {
        return currentWeightDate;
    }

    public void setCurrentWeightDate(Date currentWeightDate) {
        this.currentWeightDate = currentWeightDate;
    }

    public String getTbStatus() {
        return tbStatus;
    }

    public void setTbStatus(String tbStatus) {
        this.tbStatus = tbStatus;
    }

    public Date getTbStatusDate() {
        return tbStatusDate;
    }

    public void setTbStatusDate(Date tbStatusDate) {
        this.tbStatusDate = tbStatusDate;
    }

    public Date getBaselineInhStartDate() {
        return baselineInhStartDate;
    }

    public void setBaselineInhStartDate(Date baselineInhStartDate) {
        this.baselineInhStartDate = baselineInhStartDate;
    }

    public Date getBaselineInhStopDate() {
        return baselineInhStopDate;
    }

    public void setBaselineInhStopDate(Date baselineInhStopDate) {
        this.baselineInhStopDate = baselineInhStopDate;
    }

    public Date getCurrentInhStartDate() {
        return currentInhStartDate;
    }

    public void setCurrentInhStartDate(Date currentInhStartDate) {
        this.currentInhStartDate = currentInhStartDate;
    }

    public Date getCurrentInhStopDate() {
        return currentInhStopDate;
    }

    public void setCurrentInhStopDate(Date currentInhStopDate) {
        this.currentInhStopDate = currentInhStopDate;
    }

    public String getCurrentInhOutcome() {
        return currentInhOutcome;
    }

    public void setCurrentInhOutcome(String currentInhOutcome) {
        this.currentInhOutcome = currentInhOutcome;
    }

    public Date getLastInhDispensedDate() {
        return lastInhDispensedDate;
    }

    public void setLastInhDispensedDate(Date lastInhDispensedDate) {
        this.lastInhDispensedDate = lastInhDispensedDate;
    }

    public Date getBaselineTbTreatmentStopDate() {
        return baselineTbTreatmentStopDate;
    }

    public void setBaselineTbTreatmentStopDate(Date baselineTbTreatmentStopDate) {
        this.baselineTbTreatmentStopDate = baselineTbTreatmentStopDate;
    }

    public Date getLastViralLoadSampleCollectionFormDate() {
        return lastViralLoadSampleCollectionFormDate;
    }

    public void setLastViralLoadSampleCollectionFormDate(Date lastViralLoadSampleCollectionFormDate) {
        this.lastViralLoadSampleCollectionFormDate = lastViralLoadSampleCollectionFormDate;
    }

    public Date getLastSampleTakenDate() {
        return lastSampleTakenDate;
    }

    public void setLastSampleTakenDate(Date lastSampleTakenDate) {
        this.lastSampleTakenDate = lastSampleTakenDate;
    }

    public Date getOtzEnrollmentDate() {
        return otzEnrollmentDate;
    }

    public void setOtzEnrollmentDate(Date otzEnrollmentDate) {
        this.otzEnrollmentDate = otzEnrollmentDate;
    }

    public Date getOtzOutcomeDate() {
        return otzOutcomeDate;
    }

    public void setOtzOutcomeDate(Date otzOutcomeDate) {
        this.otzOutcomeDate = otzOutcomeDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getInitialFirstLineRegimen() {
        return initialFirstLineRegimen;
    }

    public void setInitialFirstLineRegimen(String initialFirstLineRegimen) {
        this.initialFirstLineRegimen = initialFirstLineRegimen;
    }

    public Date getInitialFirstLineRegimenDate() {
        return initialFirstLineRegimenDate;
    }

    public void setInitialFirstLineRegimenDate(Date initialFirstLineRegimenDate) {
        this.initialFirstLineRegimenDate = initialFirstLineRegimenDate;
    }

    public Date getInitialSecondLineRegimenDate() {
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

    public BigInteger getDrugDurationPreviousQuarter() {
        return drugDurationPreviousQuarter;
    }

    public void setDrugDurationPreviousQuarter(BigInteger drugDurationPreviousQuarter) {
        this.drugDurationPreviousQuarter = drugDurationPreviousQuarter;
    }

    public String getPatientOutcomePreviousQuarter() {
        return patientOutcomePreviousQuarter;
    }

    public void setPatientOutcomePreviousQuarter(String patientOutcomePreviousQuarter) {
        this.patientOutcomePreviousQuarter = patientOutcomePreviousQuarter;
    }

    public Date getPatientOutcomeDatePreviousQuater() {
        return patientOutcomeDatePreviousQuater;
    }

    public void setPatientOutcomeDatePreviousQuater(Date patientOutcomeDatePreviousQuater) {
        this.patientOutcomeDatePreviousQuater = patientOutcomeDatePreviousQuater;
    }

    public String getArtStatusPreviousQuater() {
        return artStatusPreviousQuater;
    }

    public void setArtStatusPreviousQuater(String artStatusPreviousQuater) {
        this.artStatusPreviousQuater = artStatusPreviousQuater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtLinelist)) {
            return false;
        }
        ArtLinelist other = (ArtLinelist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlservice.schedular.entities.ArtLinelist[ id=" + id + " ]";
    }
    
}
