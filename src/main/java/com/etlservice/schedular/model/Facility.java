package com.etlservice.schedular.model;

import javax.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(allocationSize = 1,initialValue = 1, name = "idgen", sequenceName = "facilityseq")
    private String Id;

    @Column(name = "state")
    private String state;

    @Column(name = "lga")
    private String lga;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "facility_short_name")
    private String facilityShortName;

    @Column(name = "datim_code")
    private String datimCode;

    public Facility() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityShortName() {
        return facilityShortName;
    }

    public void setFacilityShortName(String facilityShortName) {
        this.facilityShortName = facilityShortName;
    }

    public String getDatimCode() {
        return datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }
}
