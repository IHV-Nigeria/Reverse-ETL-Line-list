package com.etlservice.schedular.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties( { "createDate" ,"updateDate" })
public class Facility extends BaseClass implements Serializable {
    private String partner;
    private String facilityName;
    @Column(unique = true)
    private String datimCode;
    private String facilityShortName;
    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName="id")
    @JsonIgnore
    private State state;
    @ManyToOne
    @JoinColumn(name="lga_id", referencedColumnName="id")
    @JsonIgnore
    private LGA lga;
}
