/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.mongorepo.postgres;

import com.etlservice.schedular.entities.ArtLinelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author MORRISON.I
 */
@Repository
public interface ArtLineListRepository extends JpaRepository<ArtLinelist, Integer>{
    Optional<ArtLinelist> findByPatientUuid(String patientUuid);
}
