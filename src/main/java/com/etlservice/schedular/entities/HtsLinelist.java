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
@Table(name = "hts_linelist")
@NamedQueries({
    @NamedQuery(name = "HtsLinelist.findAll", query = "SELECT h FROM HtsLinelist h")})
public class HtsLinelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ip_name")
    private String ipName;
    @Column(name = "facility_state")
    private String facilityState;
    @Column(name = "facility_lga")
    private String facilityLga;
    @Column(name = "facility_name")
    private String facilityName;
    @Column(name = "datim_code")
    private String datimCode;
    @Column(name = "client_state")
    private String clientState;
    @Column(name = "client_lga")
    private String clientLga;
    @Column(name = "hts_client_code")
    private String htsClientCode;
    @Column(name = "patient_id")
    private BigInteger patientId;
    @Column(name = "pepfar_id")
    private String pepfarId;
    @Column(name = "hosp_id")
    private String hospId;
    @Column(name = "recency_id")
    private String recencyId;
    @Column(name = "sex")
    private String sex;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "current_age")
    private BigInteger currentAge;
    @Column(name = "age_group")
    private BigInteger ageGroup;
    @Column(name = "age_at_visit")
    private BigInteger ageAtVisit;
    @Column(name = "visit_date")
    @Temporal(TemporalType.DATE)
    private Date visitDate;
    @Column(name = "setting")
    private String setting;
    @Column(name = "visit_id")
    private BigInteger visitId;
    @Column(name = "kind_of_hts")
    private String kindOfHts;
    @Column(name = "setting_others_specify")
    private String settingOthersSpecify;
    @Column(name = "first_time_visit")
    private String firstTimeVisit;
    @Column(name = "type_of_session")
    private String typeOfSession;
    @Column(name = "referred_from")
    private String referredFrom;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "no_of_own_children_less_than5")
    private String noOfOwnChildrenLessThan5;
    @Column(name = "no_of_wives")
    private String noOfWives;
    @Column(name = "is_client_identified_from_an_index_client")
    private String isClientIdentifiedFromAnIndexClient;
    @Column(name = "index_type")
    private String indexType;
    @Column(name = "index_client_id")
    private String indexClientId;
    @Column(name = "is_client_retesting_for_result_verification")
    private String isClientRetestingForResultVerification;
    @Column(name = "previously_tested_hiv_negative")
    private String previouslyTestedHivNegative;
    @Column(name = "client_pregnant")
    private String clientPregnant;
    @Column(name = "client_informed_about_hiv_transmission_routes")
    private String clientInformedAboutHivTransmissionRoutes;
    @Column(name = "client_informed_about_risk_factors_for_hiv_transmission")
    private String clientInformedAboutRiskFactorsForHivTransmission;
    @Column(name = "client_informed_on_preventing_hiv_transmission_methods")
    private String clientInformedOnPreventingHivTransmissionMethods;
    @Column(name = "client_informed_about_possible_test_results")
    private String clientInformedAboutPossibleTestResults;
    @Column(name = "informed_consent_for_hiv_testing_given")
    private String informedConsentForHivTestingGiven;
    @Column(name = "ever_had_sexual_intercourse")
    private String everHadSexualIntercourse;
    @Column(name = "blood_transfusionin_last_3months")
    private String bloodTransfusioninLast3months;
    @Column(name = "unprotected_sex_with_casual_partnerin_last_3months")
    private String unprotectedSexWithCasualPartnerinLast3months;
    @Column(name = "unprotected_sex_with_regular_partner_in_the_last_3months")
    private String unprotectedSexWithRegularPartnerInTheLast3months;
    @Column(name = "sti_in_last_3months")
    private String stiInLast3months;
    @Column(name = "more_than_1sex_partner_during_last_3months")
    private String moreThan1sexPartnerDuringLast3months;
    @Column(name = "current_cough")
    private String currentCough;
    @Column(name = "weight_loss")
    private String weightLoss;
    @Column(name = "fever")
    private String fever;
    @Column(name = "night_sweats")
    private String nightSweats;
    @Column(name = "contact_with_tb_patient")
    private String contactWithTbPatient;
    @Column(name = "tb_screening_score")
    private String tbScreeningScore;
    @Column(name = "complaints_of_vaginal_discharge_or_burning_when_urinating")
    private String complaintsOfVaginalDischargeOrBurningWhenUrinating;
    @Column(name = "complaints_of_lower_abdominal_pains_with_or_without_vaginal_dis")
    private String complaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis;
    @Column(name = "complaints_of_genital_sore_or_swollen_inguinal_lymph_nodes_with")
    private String complaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith;
    @Column(name = "sti_screening_score")
    private String stiScreeningScore;
    @Column(name = "risk_assesment_score")
    private String riskAssesmentScore;
    @Column(name = "screening_test_result")
    private String screeningTestResult;
    @Column(name = "screening_test_date")
    @Temporal(TemporalType.DATE)
    private Date screeningTestDate;
    @Column(name = "confirmatory_test_result")
    private String confirmatoryTestResult;
    @Column(name = "confirmatory_test_date")
    @Temporal(TemporalType.DATE)
    private Date confirmatoryTestDate;
    @Column(name = "tie_breaker")
    private String tieBreaker;
    @Column(name = "tie_breaker_date")
    @Temporal(TemporalType.DATE)
    private Date tieBreakerDate;
    @Column(name = "final_result")
    private String finalResult;
    @Column(name = "opt_out_rtri")
    private String optOutRtri;
    @Column(name = "recency_test_name")
    private String recencyTestName;
    @Column(name = "recency_test_date")
    @Temporal(TemporalType.DATE)
    private Date recencyTestDate;
    @Column(name = "control_line")
    private String controlLine;
    @Column(name = "verification_line")
    private String verificationLine;
    @Column(name = "longterm_line")
    private String longtermLine;
    @Column(name = "recency_interpretation")
    private String recencyInterpretation;
    @Column(name = "has_viral_load_been_requested")
    private String hasViralLoadBeenRequested;
    @Column(name = "date_sample_collected")
    @Temporal(TemporalType.DATE)
    private Date dateSampleCollected;
    @Column(name = "date_sample_sent")
    @Temporal(TemporalType.DATE)
    private Date dateSampleSent;
    @Column(name = "viral_load_result")
    private BigInteger viralLoadResult;
    @Column(name = "viral_load_result_classification")
    private String viralLoadResultClassification;
    @Column(name = "date_of_viral_load_result")
    @Temporal(TemporalType.DATE)
    private Date dateOfViralLoadResult;
    @Column(name = "pcr_lab")
    private String pcrLab;
    @Column(name = "final_recency_result")
    private String finalRecencyResult;
    @Column(name = "have_you_been_tested_for_hiv_before_within_this_year")
    private String haveYouBeenTestedForHivBeforeWithinThisYear;
    @Column(name = "hiv_request_and_result_form_signed_by_tester")
    private String hivRequestAndResultFormSignedByTester;
    @Column(name = "client_received_hiv_test_result")
    private String clientReceivedHivTestResult;
    @Column(name = "post_test_counseling_done")
    private String postTestCounselingDone;
    @Column(name = "client_use_fp_methods_other_than_condom")
    private String clientUseFpMethodsOtherThanCondom;
    @Column(name = "client_use_condoms_as_fp_method")
    private String clientUseCondomsAsFpMethod;
    @Column(name = "syphilis_test_result")
    private String syphilisTestResult;
    @Column(name = "hepatitisb_virus_test_result")
    private String hepatitisbVirusTestResult;
    @Column(name = "hepatitisc_virus_test_result")
    private String hepatitiscVirusTestResult;
    @Column(name = "client_referred_to_other_services")
    private String clientReferredToOtherServices;
    @Column(name = "risk_reduction_plan_developed")
    private String riskReductionPlanDeveloped;
    @Column(name = "post_test_disclosure_plan_developed")
    private String postTestDisclosurePlanDeveloped;
    @Column(name = "will_bring_partner_for_hiv_testing")
    private String willBringPartnerForHivTesting;
    @Column(name = "will_bring_own_children_less_than_5years_for_hiv_testing")
    private String willBringOwnChildrenLessThan5yearsForHivTesting;
    @Column(name = "provided_with_informationon_fp_and_dual_contraception")
    private String providedWithInformationonFpAndDualContraception;
    @Column(name = "correct_condom_use_demonstrated")
    private String correctCondomUseDemonstrated;
    @Column(name = "condoms_provided_to_client")
    private String condomsProvidedToClient;
    @Column(name = "key_population")
    private String keyPopulation;
    @Column(name = "kp_type")
    private String kpType;
    @Column(name = "additional_comment")
    private String additionalComment;
    @Column(name = "signature_date")
    @Temporal(TemporalType.DATE)
    private Date signatureDate;

    public HtsLinelist() {
    }

    public HtsLinelist(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpName() {
        return ipName;
    }

    public void setIpName(String ipName) {
        this.ipName = ipName;
    }

    public String getFacilityState() {
        return facilityState;
    }

    public void setFacilityState(String facilityState) {
        this.facilityState = facilityState;
    }

    public String getFacilityLga() {
        return facilityLga;
    }

    public void setFacilityLga(String facilityLga) {
        this.facilityLga = facilityLga;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getDatimCode() {
        return datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientLga() {
        return clientLga;
    }

    public void setClientLga(String clientLga) {
        this.clientLga = clientLga;
    }

    public String getHtsClientCode() {
        return htsClientCode;
    }

    public void setHtsClientCode(String htsClientCode) {
        this.htsClientCode = htsClientCode;
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        this.patientId = patientId;
    }

    public String getPepfarId() {
        return pepfarId;
    }

    public void setPepfarId(String pepfarId) {
        this.pepfarId = pepfarId;
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId;
    }

    public String getRecencyId() {
        return recencyId;
    }

    public void setRecencyId(String recencyId) {
        this.recencyId = recencyId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigInteger getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(BigInteger currentAge) {
        this.currentAge = currentAge;
    }

    public BigInteger getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(BigInteger ageGroup) {
        this.ageGroup = ageGroup;
    }

    public BigInteger getAgeAtVisit() {
        return ageAtVisit;
    }

    public void setAgeAtVisit(BigInteger ageAtVisit) {
        this.ageAtVisit = ageAtVisit;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public BigInteger getVisitId() {
        return visitId;
    }

    public void setVisitId(BigInteger visitId) {
        this.visitId = visitId;
    }

    public String getKindOfHts() {
        return kindOfHts;
    }

    public void setKindOfHts(String kindOfHts) {
        this.kindOfHts = kindOfHts;
    }

    public String getSettingOthersSpecify() {
        return settingOthersSpecify;
    }

    public void setSettingOthersSpecify(String settingOthersSpecify) {
        this.settingOthersSpecify = settingOthersSpecify;
    }

    public String getFirstTimeVisit() {
        return firstTimeVisit;
    }

    public void setFirstTimeVisit(String firstTimeVisit) {
        this.firstTimeVisit = firstTimeVisit;
    }

    public String getTypeOfSession() {
        return typeOfSession;
    }

    public void setTypeOfSession(String typeOfSession) {
        this.typeOfSession = typeOfSession;
    }

    public String getReferredFrom() {
        return referredFrom;
    }

    public void setReferredFrom(String referredFrom) {
        this.referredFrom = referredFrom;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNoOfOwnChildrenLessThan5() {
        return noOfOwnChildrenLessThan5;
    }

    public void setNoOfOwnChildrenLessThan5(String noOfOwnChildrenLessThan5) {
        this.noOfOwnChildrenLessThan5 = noOfOwnChildrenLessThan5;
    }

    public String getNoOfWives() {
        return noOfWives;
    }

    public void setNoOfWives(String noOfWives) {
        this.noOfWives = noOfWives;
    }

    public String getIsClientIdentifiedFromAnIndexClient() {
        return isClientIdentifiedFromAnIndexClient;
    }

    public void setIsClientIdentifiedFromAnIndexClient(String isClientIdentifiedFromAnIndexClient) {
        this.isClientIdentifiedFromAnIndexClient = isClientIdentifiedFromAnIndexClient;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getIndexClientId() {
        return indexClientId;
    }

    public void setIndexClientId(String indexClientId) {
        this.indexClientId = indexClientId;
    }

    public String getIsClientRetestingForResultVerification() {
        return isClientRetestingForResultVerification;
    }

    public void setIsClientRetestingForResultVerification(String isClientRetestingForResultVerification) {
        this.isClientRetestingForResultVerification = isClientRetestingForResultVerification;
    }

    public String getPreviouslyTestedHivNegative() {
        return previouslyTestedHivNegative;
    }

    public void setPreviouslyTestedHivNegative(String previouslyTestedHivNegative) {
        this.previouslyTestedHivNegative = previouslyTestedHivNegative;
    }

    public String getClientPregnant() {
        return clientPregnant;
    }

    public void setClientPregnant(String clientPregnant) {
        this.clientPregnant = clientPregnant;
    }

    public String getClientInformedAboutHivTransmissionRoutes() {
        return clientInformedAboutHivTransmissionRoutes;
    }

    public void setClientInformedAboutHivTransmissionRoutes(String clientInformedAboutHivTransmissionRoutes) {
        this.clientInformedAboutHivTransmissionRoutes = clientInformedAboutHivTransmissionRoutes;
    }

    public String getClientInformedAboutRiskFactorsForHivTransmission() {
        return clientInformedAboutRiskFactorsForHivTransmission;
    }

    public void setClientInformedAboutRiskFactorsForHivTransmission(String clientInformedAboutRiskFactorsForHivTransmission) {
        this.clientInformedAboutRiskFactorsForHivTransmission = clientInformedAboutRiskFactorsForHivTransmission;
    }

    public String getClientInformedOnPreventingHivTransmissionMethods() {
        return clientInformedOnPreventingHivTransmissionMethods;
    }

    public void setClientInformedOnPreventingHivTransmissionMethods(String clientInformedOnPreventingHivTransmissionMethods) {
        this.clientInformedOnPreventingHivTransmissionMethods = clientInformedOnPreventingHivTransmissionMethods;
    }

    public String getClientInformedAboutPossibleTestResults() {
        return clientInformedAboutPossibleTestResults;
    }

    public void setClientInformedAboutPossibleTestResults(String clientInformedAboutPossibleTestResults) {
        this.clientInformedAboutPossibleTestResults = clientInformedAboutPossibleTestResults;
    }

    public String getInformedConsentForHivTestingGiven() {
        return informedConsentForHivTestingGiven;
    }

    public void setInformedConsentForHivTestingGiven(String informedConsentForHivTestingGiven) {
        this.informedConsentForHivTestingGiven = informedConsentForHivTestingGiven;
    }

    public String getEverHadSexualIntercourse() {
        return everHadSexualIntercourse;
    }

    public void setEverHadSexualIntercourse(String everHadSexualIntercourse) {
        this.everHadSexualIntercourse = everHadSexualIntercourse;
    }

    public String getBloodTransfusioninLast3months() {
        return bloodTransfusioninLast3months;
    }

    public void setBloodTransfusioninLast3months(String bloodTransfusioninLast3months) {
        this.bloodTransfusioninLast3months = bloodTransfusioninLast3months;
    }

    public String getUnprotectedSexWithCasualPartnerinLast3months() {
        return unprotectedSexWithCasualPartnerinLast3months;
    }

    public void setUnprotectedSexWithCasualPartnerinLast3months(String unprotectedSexWithCasualPartnerinLast3months) {
        this.unprotectedSexWithCasualPartnerinLast3months = unprotectedSexWithCasualPartnerinLast3months;
    }

    public String getUnprotectedSexWithRegularPartnerInTheLast3months() {
        return unprotectedSexWithRegularPartnerInTheLast3months;
    }

    public void setUnprotectedSexWithRegularPartnerInTheLast3months(String unprotectedSexWithRegularPartnerInTheLast3months) {
        this.unprotectedSexWithRegularPartnerInTheLast3months = unprotectedSexWithRegularPartnerInTheLast3months;
    }

    public String getStiInLast3months() {
        return stiInLast3months;
    }

    public void setStiInLast3months(String stiInLast3months) {
        this.stiInLast3months = stiInLast3months;
    }

    public String getMoreThan1sexPartnerDuringLast3months() {
        return moreThan1sexPartnerDuringLast3months;
    }

    public void setMoreThan1sexPartnerDuringLast3months(String moreThan1sexPartnerDuringLast3months) {
        this.moreThan1sexPartnerDuringLast3months = moreThan1sexPartnerDuringLast3months;
    }

    public String getCurrentCough() {
        return currentCough;
    }

    public void setCurrentCough(String currentCough) {
        this.currentCough = currentCough;
    }

    public String getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(String weightLoss) {
        this.weightLoss = weightLoss;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getNightSweats() {
        return nightSweats;
    }

    public void setNightSweats(String nightSweats) {
        this.nightSweats = nightSweats;
    }

    public String getContactWithTbPatient() {
        return contactWithTbPatient;
    }

    public void setContactWithTbPatient(String contactWithTbPatient) {
        this.contactWithTbPatient = contactWithTbPatient;
    }

    public String getTbScreeningScore() {
        return tbScreeningScore;
    }

    public void setTbScreeningScore(String tbScreeningScore) {
        this.tbScreeningScore = tbScreeningScore;
    }

    public String getComplaintsOfVaginalDischargeOrBurningWhenUrinating() {
        return complaintsOfVaginalDischargeOrBurningWhenUrinating;
    }

    public void setComplaintsOfVaginalDischargeOrBurningWhenUrinating(String complaintsOfVaginalDischargeOrBurningWhenUrinating) {
        this.complaintsOfVaginalDischargeOrBurningWhenUrinating = complaintsOfVaginalDischargeOrBurningWhenUrinating;
    }

    public String getComplaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis() {
        return complaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis;
    }

    public void setComplaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis(String complaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis) {
        this.complaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis = complaintsOfLowerAbdominalPainsWithOrWithoutVaginalDis;
    }

    public String getComplaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith() {
        return complaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith;
    }

    public void setComplaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith(String complaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith) {
        this.complaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith = complaintsOfGenitalSoreOrSwollenInguinalLymphNodesWith;
    }

    public String getStiScreeningScore() {
        return stiScreeningScore;
    }

    public void setStiScreeningScore(String stiScreeningScore) {
        this.stiScreeningScore = stiScreeningScore;
    }

    public String getRiskAssesmentScore() {
        return riskAssesmentScore;
    }

    public void setRiskAssesmentScore(String riskAssesmentScore) {
        this.riskAssesmentScore = riskAssesmentScore;
    }

    public String getScreeningTestResult() {
        return screeningTestResult;
    }

    public void setScreeningTestResult(String screeningTestResult) {
        this.screeningTestResult = screeningTestResult;
    }

    public Date getScreeningTestDate() {
        return screeningTestDate;
    }

    public void setScreeningTestDate(Date screeningTestDate) {
        this.screeningTestDate = screeningTestDate;
    }

    public String getConfirmatoryTestResult() {
        return confirmatoryTestResult;
    }

    public void setConfirmatoryTestResult(String confirmatoryTestResult) {
        this.confirmatoryTestResult = confirmatoryTestResult;
    }

    public Date getConfirmatoryTestDate() {
        return confirmatoryTestDate;
    }

    public void setConfirmatoryTestDate(Date confirmatoryTestDate) {
        this.confirmatoryTestDate = confirmatoryTestDate;
    }

    public String getTieBreaker() {
        return tieBreaker;
    }

    public void setTieBreaker(String tieBreaker) {
        this.tieBreaker = tieBreaker;
    }

    public Date getTieBreakerDate() {
        return tieBreakerDate;
    }

    public void setTieBreakerDate(Date tieBreakerDate) {
        this.tieBreakerDate = tieBreakerDate;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getOptOutRtri() {
        return optOutRtri;
    }

    public void setOptOutRtri(String optOutRtri) {
        this.optOutRtri = optOutRtri;
    }

    public String getRecencyTestName() {
        return recencyTestName;
    }

    public void setRecencyTestName(String recencyTestName) {
        this.recencyTestName = recencyTestName;
    }

    public Date getRecencyTestDate() {
        return recencyTestDate;
    }

    public void setRecencyTestDate(Date recencyTestDate) {
        this.recencyTestDate = recencyTestDate;
    }

    public String getControlLine() {
        return controlLine;
    }

    public void setControlLine(String controlLine) {
        this.controlLine = controlLine;
    }

    public String getVerificationLine() {
        return verificationLine;
    }

    public void setVerificationLine(String verificationLine) {
        this.verificationLine = verificationLine;
    }

    public String getLongtermLine() {
        return longtermLine;
    }

    public void setLongtermLine(String longtermLine) {
        this.longtermLine = longtermLine;
    }

    public String getRecencyInterpretation() {
        return recencyInterpretation;
    }

    public void setRecencyInterpretation(String recencyInterpretation) {
        this.recencyInterpretation = recencyInterpretation;
    }

    public String getHasViralLoadBeenRequested() {
        return hasViralLoadBeenRequested;
    }

    public void setHasViralLoadBeenRequested(String hasViralLoadBeenRequested) {
        this.hasViralLoadBeenRequested = hasViralLoadBeenRequested;
    }

    public Date getDateSampleCollected() {
        return dateSampleCollected;
    }

    public void setDateSampleCollected(Date dateSampleCollected) {
        this.dateSampleCollected = dateSampleCollected;
    }

    public Date getDateSampleSent() {
        return dateSampleSent;
    }

    public void setDateSampleSent(Date dateSampleSent) {
        this.dateSampleSent = dateSampleSent;
    }

    public BigInteger getViralLoadResult() {
        return viralLoadResult;
    }

    public void setViralLoadResult(BigInteger viralLoadResult) {
        this.viralLoadResult = viralLoadResult;
    }

    public String getViralLoadResultClassification() {
        return viralLoadResultClassification;
    }

    public void setViralLoadResultClassification(String viralLoadResultClassification) {
        this.viralLoadResultClassification = viralLoadResultClassification;
    }

    public Date getDateOfViralLoadResult() {
        return dateOfViralLoadResult;
    }

    public void setDateOfViralLoadResult(Date dateOfViralLoadResult) {
        this.dateOfViralLoadResult = dateOfViralLoadResult;
    }

    public String getPcrLab() {
        return pcrLab;
    }

    public void setPcrLab(String pcrLab) {
        this.pcrLab = pcrLab;
    }

    public String getFinalRecencyResult() {
        return finalRecencyResult;
    }

    public void setFinalRecencyResult(String finalRecencyResult) {
        this.finalRecencyResult = finalRecencyResult;
    }

    public String getHaveYouBeenTestedForHivBeforeWithinThisYear() {
        return haveYouBeenTestedForHivBeforeWithinThisYear;
    }

    public void setHaveYouBeenTestedForHivBeforeWithinThisYear(String haveYouBeenTestedForHivBeforeWithinThisYear) {
        this.haveYouBeenTestedForHivBeforeWithinThisYear = haveYouBeenTestedForHivBeforeWithinThisYear;
    }

    public String getHivRequestAndResultFormSignedByTester() {
        return hivRequestAndResultFormSignedByTester;
    }

    public void setHivRequestAndResultFormSignedByTester(String hivRequestAndResultFormSignedByTester) {
        this.hivRequestAndResultFormSignedByTester = hivRequestAndResultFormSignedByTester;
    }

    public String getClientReceivedHivTestResult() {
        return clientReceivedHivTestResult;
    }

    public void setClientReceivedHivTestResult(String clientReceivedHivTestResult) {
        this.clientReceivedHivTestResult = clientReceivedHivTestResult;
    }

    public String getPostTestCounselingDone() {
        return postTestCounselingDone;
    }

    public void setPostTestCounselingDone(String postTestCounselingDone) {
        this.postTestCounselingDone = postTestCounselingDone;
    }

    public String getClientUseFpMethodsOtherThanCondom() {
        return clientUseFpMethodsOtherThanCondom;
    }

    public void setClientUseFpMethodsOtherThanCondom(String clientUseFpMethodsOtherThanCondom) {
        this.clientUseFpMethodsOtherThanCondom = clientUseFpMethodsOtherThanCondom;
    }

    public String getClientUseCondomsAsFpMethod() {
        return clientUseCondomsAsFpMethod;
    }

    public void setClientUseCondomsAsFpMethod(String clientUseCondomsAsFpMethod) {
        this.clientUseCondomsAsFpMethod = clientUseCondomsAsFpMethod;
    }

    public String getSyphilisTestResult() {
        return syphilisTestResult;
    }

    public void setSyphilisTestResult(String syphilisTestResult) {
        this.syphilisTestResult = syphilisTestResult;
    }

    public String getHepatitisbVirusTestResult() {
        return hepatitisbVirusTestResult;
    }

    public void setHepatitisbVirusTestResult(String hepatitisbVirusTestResult) {
        this.hepatitisbVirusTestResult = hepatitisbVirusTestResult;
    }

    public String getHepatitiscVirusTestResult() {
        return hepatitiscVirusTestResult;
    }

    public void setHepatitiscVirusTestResult(String hepatitiscVirusTestResult) {
        this.hepatitiscVirusTestResult = hepatitiscVirusTestResult;
    }

    public String getClientReferredToOtherServices() {
        return clientReferredToOtherServices;
    }

    public void setClientReferredToOtherServices(String clientReferredToOtherServices) {
        this.clientReferredToOtherServices = clientReferredToOtherServices;
    }

    public String getRiskReductionPlanDeveloped() {
        return riskReductionPlanDeveloped;
    }

    public void setRiskReductionPlanDeveloped(String riskReductionPlanDeveloped) {
        this.riskReductionPlanDeveloped = riskReductionPlanDeveloped;
    }

    public String getPostTestDisclosurePlanDeveloped() {
        return postTestDisclosurePlanDeveloped;
    }

    public void setPostTestDisclosurePlanDeveloped(String postTestDisclosurePlanDeveloped) {
        this.postTestDisclosurePlanDeveloped = postTestDisclosurePlanDeveloped;
    }

    public String getWillBringPartnerForHivTesting() {
        return willBringPartnerForHivTesting;
    }

    public void setWillBringPartnerForHivTesting(String willBringPartnerForHivTesting) {
        this.willBringPartnerForHivTesting = willBringPartnerForHivTesting;
    }

    public String getWillBringOwnChildrenLessThan5yearsForHivTesting() {
        return willBringOwnChildrenLessThan5yearsForHivTesting;
    }

    public void setWillBringOwnChildrenLessThan5yearsForHivTesting(String willBringOwnChildrenLessThan5yearsForHivTesting) {
        this.willBringOwnChildrenLessThan5yearsForHivTesting = willBringOwnChildrenLessThan5yearsForHivTesting;
    }

    public String getProvidedWithInformationonFpAndDualContraception() {
        return providedWithInformationonFpAndDualContraception;
    }

    public void setProvidedWithInformationonFpAndDualContraception(String providedWithInformationonFpAndDualContraception) {
        this.providedWithInformationonFpAndDualContraception = providedWithInformationonFpAndDualContraception;
    }

    public String getCorrectCondomUseDemonstrated() {
        return correctCondomUseDemonstrated;
    }

    public void setCorrectCondomUseDemonstrated(String correctCondomUseDemonstrated) {
        this.correctCondomUseDemonstrated = correctCondomUseDemonstrated;
    }

    public String getCondomsProvidedToClient() {
        return condomsProvidedToClient;
    }

    public void setCondomsProvidedToClient(String condomsProvidedToClient) {
        this.condomsProvidedToClient = condomsProvidedToClient;
    }

    public String getKeyPopulation() {
        return keyPopulation;
    }

    public void setKeyPopulation(String keyPopulation) {
        this.keyPopulation = keyPopulation;
    }

    public String getKpType() {
        return kpType;
    }

    public void setKpType(String kpType) {
        this.kpType = kpType;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
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
        if (!(object instanceof HtsLinelist)) {
            return false;
        }
        HtsLinelist other = (HtsLinelist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlservice.schedular.entities.HtsLinelist[ id=" + id + " ]";
    }
    
}
