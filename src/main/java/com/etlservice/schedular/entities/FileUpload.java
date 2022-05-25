/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "file_upload")
@NamedQueries({
    @NamedQuery(name = "FileUpload.findAll", query = "SELECT f FROM FileUpload f")})
public class FileUpload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fileupload_id")
    private Integer fileuploadId;
    @Column(name = "consumer_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consumerDate;
    @Column(name = "data_validation_report")
    private String dataValidationReport;
    @Column(name = "deduplication_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deduplicationDate;
    @Column(name = "etl_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDate;
    @Column(name = "facility_datimcode")
    private String facilityDatimcode;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileTimestamp;
    @Lob
    @Column(name = "patient_uuid")
    private String patientUuid;
    @Column(name = "schema_validation_report")
    private String schemaValidationReport;
    @Column(name = "status")
    private String status;
    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Column(name = "validator_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validatorDate;
    @Column(name = "filebatch_id")
    private Integer filebatchId;

    public FileUpload() {
    }

    public FileUpload(Integer fileuploadId) {
        this.fileuploadId = fileuploadId;
    }

    public Integer getFileuploadId() {
        return fileuploadId;
    }

    public void setFileuploadId(Integer fileuploadId) {
        this.fileuploadId = fileuploadId;
    }

    public Date getConsumerDate() {
        return consumerDate;
    }

    public void setConsumerDate(Date consumerDate) {
        this.consumerDate = consumerDate;
    }

    public String getDataValidationReport() {
        return dataValidationReport;
    }

    public void setDataValidationReport(String dataValidationReport) {
        this.dataValidationReport = dataValidationReport;
    }

    public Date getDeduplicationDate() {
        return deduplicationDate;
    }

    public void setDeduplicationDate(Date deduplicationDate) {
        this.deduplicationDate = deduplicationDate;
    }

    public Date getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(Date etlDate) {
        this.etlDate = etlDate;
    }

    public String getFacilityDatimcode() {
        return facilityDatimcode;
    }

    public void setFacilityDatimcode(String facilityDatimcode) {
        this.facilityDatimcode = facilityDatimcode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileTimestamp() {
        return fileTimestamp;
    }

    public void setFileTimestamp(Date fileTimestamp) {
        this.fileTimestamp = fileTimestamp;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }


    public String getSchemaValidationReport() {
        return schemaValidationReport;
    }

    public void setSchemaValidationReport(String schemaValidationReport) {
        this.schemaValidationReport = schemaValidationReport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getValidatorDate() {
        return validatorDate;
    }

    public void setValidatorDate(Date validatorDate) {
        this.validatorDate = validatorDate;
    }

    public Integer getFilebatchId() {
        return filebatchId;
    }

    public void setFilebatchId(Integer filebatchId) {
        this.filebatchId = filebatchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileuploadId != null ? fileuploadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileUpload)) {
            return false;
        }
        FileUpload other = (FileUpload) object;
        if ((this.fileuploadId == null && other.fileuploadId != null) || (this.fileuploadId != null && !this.fileuploadId.equals(other.fileuploadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlservice.schedular.entities.FileUpload[ fileuploadId=" + fileuploadId + " ]";
    }
    
}
