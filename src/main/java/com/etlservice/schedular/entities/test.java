package com.etlservice.schedular.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class test {
    public static void main(String args[]){
        preeviousQuarter(new Date());
    }
    public static List<String> preeviousQuarter(Date today){

        List<String> Q1 = Arrays.asList("OCT","NOV","DEC");
        List<String> Q2 = Arrays.asList("JAN","FEB","MAR");
        List<String> Q3 = Arrays.asList("APR","MAY","JUN");
        List<String> Q4 = Arrays.asList("JUL","AUG","SEP");

        LocalDate localDate = convertDate(today);
        String month = localDate.getMonth().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.UK).toUpperCase();
        //System.out.println(localDate.getMonth().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.UK).toUpperCase());
        if(Q1.contains(month))
            return Q4;
        else  if(Q2.contains(month))
            return Q1;
        else  if(Q3.contains(month))
            return Q2;
        else  if(Q4.contains(month))
            return Q3;

        return Q1;
    }

    public static LocalDate convertDate(Date date) {

        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();

        return localDate;
    }
}
