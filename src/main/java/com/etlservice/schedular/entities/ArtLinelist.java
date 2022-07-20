/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "state")
    private String state;
    @Column(name = "lga")
    private String lgaName;
    @Column(name = "datim_code")
    private String datimCode;
    @Column(name = "facility_name")
    private String facilityName;
    @Column(name = "patient_unique_id")
    private String patientUniqueId;
    @Column(name = "patient_hospital_no")
    private String patientHospitalNo;
    @Column(name = "anc_no_identifier")
    private String ancNoIdentifier;
    @Column(name = "anc_no_concept_id")
    private String ancNoConceptId;
    @Column(name = "sex")
    private String sex;
    @Column(name = "patient_id")
    private BigInteger patientId;
    @Column(name = "patient_uuid")
    private String patientUuid;
    @Column(name = "age_at_start_of_art_years")
    private BigInteger ageAtStartOfArtYears;
    @Column(name = "age_at_start_of_art_months")
    private BigInteger ageAtStartOfArtMonths;
    @Column(name = "care_entry_point")
    private String careEntryPoint;
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
    private Double currentViralLoad;
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
    @Temporal(TemporalType.DATE)
    @Column(name = "patient_outcome_date")
    private Date patientOutcomeDate;
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
    @Column(name = "mark_as_deceased")
    private String markAsDeceased;
    @Column(name = "mark_as_deceased_death_date")
    @Temporal(TemporalType.DATE)
    private Date markAsDeceasedDeathDate;
    @Column(name = "registration_phone_no")
    private String registrationPhoneNo;
    @Column(name = "next_of_kin_phoneNo")
    private String nextOfKinPhoneNo;
    @Column(name = "treatment_supporter_phoneNo")
    private String treatmentSupporterPhoneNo;
    @Column(name = "biometric_captured")
    private String biometricCaptured;
    @Column(name = "biometric_capture_date")
    @Temporal(TemporalType.DATE)
    private Date biometricCaptureDate;
    @Column(name = "valid_capture")
    private String validCapture;
    @Column(name = "current_weight")
    private Double currentWeight;
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
    @Column(name = "current_inh_outcome")
    private String currentInhOutcome;
    @Column(name = "current_inh_outcome_date")
    @Temporal(TemporalType.DATE)
    private Date currentInhOutcomeDate;
    @Column(name = "last_inh_dispensed_date")
    @Temporal(TemporalType.DATE)
    private Date lastInhDispensedDate;
    @Column(name = "baseline_tb_treatment_start_date")
    @Temporal(TemporalType.DATE)
    private Date baselineTbTreatmentStartDate;
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
    @Column(name = "initial_second_line_regimen")
    private String initialSecondLineRegimen;
    @Column(name = "initial_second_line_regimen_date")
    @Temporal(TemporalType.DATE)
    private Date initialSecondLineRegimenDate;
    @Column(name = "last_pickup_date_previous_quarter")
    @Temporal(TemporalType.DATE)
    private Date lastPickupDatePreviousQuarter;
    @Column(name = "drug_duration_previous_quarter")
    private BigDecimal drugDurationPreviousQuarter;
    @Column(name = "patient_outcome_previous_quarter")
    private String patientOutcomePreviousQuarter;
    @Column(name = "patient_outcome_date_previous_quarter")
    @Temporal(TemporalType.DATE)
    private Date patientOutcomeDatePreviousQuarter;
    @Column(name = "art_status_previous_quarter")
    private String artStatusPreviousQuarter;

    @Column(name = "art_confirmation_date")
    @Temporal(TemporalType.DATE)
    private Date artConfirmationDate;
    @Column(name = "first_pickup_date")
    @Temporal(TemporalType.DATE)
    private Date firstPickupDate;
    @Column(name = "hts_no")
    private String htsNo;
    @Column(name = "last_qty_of_arv_refill")
    private BigInteger lastQtyOfArvRefill;
}
