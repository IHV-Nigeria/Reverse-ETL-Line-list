package com.etlservice.schedular.mongorepo.postgres;

import com.etlservice.schedular.model.FlatFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatFileRepository extends JpaRepository<FlatFile, Integer> {
}
