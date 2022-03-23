package com.etlservice.schedular.model;

import javax.persistence.*;

@Entity
@Table(name = "flatfile")
public class FlatFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "idgen", sequenceName = "flatfileseq")
    private Integer id;

    private String dataElement;

    private String dataElementName;

    private String period;

    private String categoryOptionCombo;

    private String categoryOptionComboName;

    private String attributeOptionCombo;

    private String value;

    private String implementingPartnerName;

    private String orgUnit;

    private String orgUnitName;

    private String stateName;

    private String lgaName;

    public FlatFile() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataElement() {
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    public String getDataElementName() {
        return dataElementName;
    }

    public void setDataElementName(String dataElementName) {
        this.dataElementName = dataElementName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCategoryOptionCombo() {
        return categoryOptionCombo;
    }

    public void setCategoryOptionCombo(String categoryOptionCombo) {
        this.categoryOptionCombo = categoryOptionCombo;
    }

    public String getCategoryOptionComboName() {
        return categoryOptionComboName;
    }

    public void setCategoryOptionComboName(String categoryOptionComboName) {
        this.categoryOptionComboName = categoryOptionComboName;
    }

    public String getAttributeOptionCombo() {
        return attributeOptionCombo;
    }

    public void setAttributeOptionCombo(String attributeOptionCombo) {
        this.attributeOptionCombo = attributeOptionCombo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImplementingPartnerName() {
        return implementingPartnerName;
    }

    public void setImplementingPartnerName(String implementingPartnerName) {
        this.implementingPartnerName = implementingPartnerName;
    }

    public String getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    public String getOrgUnitName() {
        return orgUnitName;
    }

    public void setOrgUnitName(String orgUnitName) {
        this.orgUnitName = orgUnitName;
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
}
