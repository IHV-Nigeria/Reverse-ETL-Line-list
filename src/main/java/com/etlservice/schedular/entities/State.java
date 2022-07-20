package com.etlservice.schedular.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties( { "createDate" ,"updateDate" , })
public class State extends BaseClass implements Serializable {
    private String stateName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
    private Set<LGA> lgas;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
    private Set<Facility> facilities;
}
