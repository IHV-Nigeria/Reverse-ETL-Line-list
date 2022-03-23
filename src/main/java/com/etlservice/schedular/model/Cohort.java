/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.model;

import com.google.common.collect.Sets;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author The Bright
 */
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(allocationSize = 1,initialValue = 1, name = "idgen", sequenceName = "entityaseq")
    private  Integer id;

    private String cohortName = "";
    private String cohortDescription = "";
    @Transient
    private String datimCode = "";

    public String getDatimCode() {
        return datimCode;
    }

    public void setDatimCode(String datimCode) {
        this.datimCode = datimCode;
    }

    // @ElementCollection
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Set<Integer> memberPatients;

    public Cohort() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cohortName
     */
    public String getCohortName() {
        return cohortName;
    }

    public String getCohortDescription() {
        return cohortDescription;
    }

    public void setCohortDescription(String cohortDescription) {
        this.cohortDescription = cohortDescription;
    }

    /**
     * @param cohortName the cohortName to set
     */
    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }



    /**
     * @return the memberPatients
     */
    public Set<Integer> getMemberPatients() {
        return memberPatients;
    }

    /**
     * @param memberPatients the memberPatients to set
     */
    public void setMemberPatients(Set<Integer> memberPatients) {
        Set<Integer> memberPatient = new HashSet<>();

        memberPatient.addAll( memberPatients);
        this.memberPatients = memberPatient;

    }

    public void setMemberPatients(List<Radet> memberPatients) {
        Set<Integer> memberPatient = new HashSet<>();
        for(int i = 0; i< memberPatients.size(); i++)
        {
            memberPatient.add(memberPatients.get(i).getPatientID());
        }
            this.memberPatients = memberPatient;

    }

    
    public static Cohort intersect(Cohort a, Cohort b, Cohort c, String cohortName){
        Cohort d=new Cohort();
        d.setCohortName(cohortName);
        d.setCohortDescription(cohortName);
        Set<Integer> aset=a.getMemberPatients();
        Set<Integer> bset=b.getMemberPatients();
        Set<Integer> cset=Sets.intersection(aset, bset);

        Set<Integer> dset=c.getMemberPatients();
        Set<Integer> rset=Sets.intersection(cset, dset);
        d.setMemberPatients(rset);
        if(!a.getDatimCode().equals("") )
            d.setDatimCode(a.getDatimCode());
        else if(!b.getDatimCode().equals("") )
            d.setDatimCode(b.getDatimCode());
        else if(!c.getDatimCode().equals("") )
            d.setDatimCode(c.getDatimCode());
        return d;
        
    }
    public static Cohort union(Cohort a, Cohort b, Cohort c, String cohortName){
        Cohort d=new Cohort();
        d.setCohortName(cohortName);
        d.setCohortDescription(cohortName);
        Set<Integer> aset=a.getMemberPatients();
        Set<Integer> bset=b.getMemberPatients();
        Set<Integer> cset=c.getMemberPatients();
        Set<Integer> dset=Sets.union(aset,bset);
        Set<Integer> rset= Sets.union(dset,cset);
        d.setMemberPatients(rset);
        if(!a.getDatimCode().equals("") )
            d.setDatimCode(a.getDatimCode());
        else if(!b.getDatimCode().equals("") )
            d.setDatimCode(a.getDatimCode());
        else if(!c.getDatimCode().equals("") )
            d.setDatimCode(a.getDatimCode());
        return d;
    }
    public static Cohort minus(Cohort a, Cohort b, String cohortName){
        Cohort c=new Cohort();
        Set<Integer> aset= a.getMemberPatients();
        Set<Integer> bset= b.getMemberPatients();
        Set<Integer> cset= Sets.difference(aset, bset);
        c.setCohortDescription(cohortName);
        c.setCohortName(cohortName);
        c.setMemberPatients(cset);
        if(!a.getDatimCode().equals("") )
            c.setDatimCode(a.getDatimCode());
        else if(!b.getDatimCode().equals("") )
            c.setDatimCode(a.getDatimCode());

        return c;
    }
    public static Cohort createCohort(Integer[] patientMemberArray,String cohortName){
        Set<Integer> set=new HashSet<Integer>(Arrays.asList(patientMemberArray));
        Cohort c=new Cohort();
        c.setMemberPatients(set);
        c.setCohortName(cohortName);
        return c;
        
        
    }
    public static Cohort createCohort(Set<Integer> patientSet,String cohortName){
        //Set<Integer> set=new HashSet<Integer>(Arrays.asList(patientMemberArray));
        Cohort c=new Cohort();
        c.setMemberPatients(patientSet);
        c.setCohortName(cohortName);
        return c;
        
        
    }
}
