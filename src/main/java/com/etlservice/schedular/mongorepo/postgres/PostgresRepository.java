package com.etlservice.schedular.mongorepo.postgres;

import com.etlservice.schedular.model.Radet;
import com.etlservice.schedular.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostgresRepository extends JpaRepository<Radet, Integer> {

    List<Radet> findRadetsByArtStartDateBetween(Date start, Date end);

    //@Query(value="select id, patientid from radet r where r.current_age_years between  :ageStart and :ageStop ", nativeQuery=true)
    List<Radet> findRadetsByCurrentAgeYearsBetween(Integer ageStart, Integer ageStop);
    List<Radet> findRadetsByCurrentAgeYearsGreaterThanEqual( Integer age);
    List<Radet> findRadetsByCurrentAgeYearsLessThan( Integer age);
    List<Radet> findRadetsBySexEquals(String sex);
    List<Radet> findRadetsByPatientOutcomeEquals(String status);
    List<Radet> findRadetsByCareEntryPointEquals(String status);
    List<Radet> findRadetsByDateReturnedToCareIsNotNull();

//    List<Radet> findRadetsByCurrentAgeYearsBetweenAndArtStartDateExists(Integer ageStart, Integer ageStop);
//    List<Radet> findRadetsByCurrentAgeYearsGreaterThanEqualAndArtStartDateExists( Integer age);
//    List<Radet> findRadetsByCurrentAgeYearsLessThanAndArtStartDateExists( Integer age);
//    List<Radet> findRadetsBySexEqualsAndArtStartDateExists(String sex);
//    List<Radet> findRadetsByPatientOutcomeEqualsAndArtStartDateExists(String status);
//    List<Radet> findRadetsByCareEntryPointEqualsAndArtStartDateExists(String status);
//    List<Radet> findRadetsByDateReturnedToCareIsNotNullAndArtStartDateExists();



}
