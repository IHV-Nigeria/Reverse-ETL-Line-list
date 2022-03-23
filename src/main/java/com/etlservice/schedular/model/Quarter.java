package com.etlservice.schedular.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Quarter {

    List q2 = new ArrayList<Integer>(  Arrays.asList(1,2,3));
    List q3 = new ArrayList<Integer>(  Arrays.asList(4,5,6));
    List q4 = new ArrayList<Integer>(  Arrays.asList(7,8,9));
    List q1 = new ArrayList<Integer>(  Arrays.asList(10,11,12));

    private  String quarter;

    private  LocalDate qDate;

    public Quarter() {

    }

    public LocalDate convertDate(Date date){

        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();
        return localDate;
    }

    public String getQuarter() {
        LocalDate  quarterDate = convertDate(new Date());
        if(q1.contains(quarterDate.getMonth().getValue())) {
            quarter = "Q1";
            int month =Integer.parseInt(q1.get(0).toString());
            qDate = LocalDate.of(quarterDate.getYear(),month,1);

        }
        else if(q2.contains(quarterDate.getMonth().getValue())) {
            quarter = "Q2";
            int month =Integer.parseInt(q2.get(0).toString());
            qDate = LocalDate.of(2021,month,1);
        }
        else if(q3.contains(quarterDate.getMonth().getValue())){
            quarter = "Q3";
            int month =Integer.parseInt(q3.get(0).toString());
            qDate = LocalDate.of(quarterDate.getYear(),month,1);
        }
        else if(q4.contains(quarterDate.getMonth().getValue())){
            quarter = "Q4";
            int month =Integer.parseInt(q4.get(0).toString());
            qDate = LocalDate.of(quarterDate.getYear(),month,1);
        }
        return quarter;
    }

    public void setQuarter(String quarter1) {
        this.quarter = quarter1;
    }

    public LocalDate getQuarterDate() {
        getQuarter();
        return qDate;
    }

    public void setQuarterDate(LocalDate quarterDate) {
        this.qDate = quarterDate;
    }
}



