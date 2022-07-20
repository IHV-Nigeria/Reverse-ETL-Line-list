package com.etlservice.schedular.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties( { "createDate" ,"updateDate" , })
public class LGA extends BaseClass implements Serializable {
    private String lga;
    @Column(unique = true)
    private String datimCode;
    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName="id")
    @JsonIgnore
    private State state;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lga")
    private Set<Facility> facilities;
}
