package com.etlservice.schedular.mongorepo.postgres;

import com.etlservice.schedular.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {

    Facility findFacilityByDatimCode(String datimCode);
}
