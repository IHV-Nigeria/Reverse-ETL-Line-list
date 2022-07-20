/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author MORRISON.I
 */
@Data
@Entity
@Table(name = "file_upload")
@NamedQueries({
    @NamedQuery(name = "FileUpload.findAll", query = "SELECT f FROM FileUpload f")})
public class FileUpload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fileUpload_id")
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
    @ManyToOne
    @JoinColumn(name = "file_batch_id",referencedColumnName = "fileBatchId")
    private FileBatch fileBatchId;

    public FileUpload() {
    }

    public FileUpload(Integer fileuploadId) {
        this.fileuploadId = fileuploadId;
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
