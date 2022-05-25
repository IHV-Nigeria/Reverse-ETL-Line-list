package com.etlservice.schedular.mongorepo;

import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.Test;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepos extends MongoRepository<Container,String> {

// @Query( "select c from Container c where c.id in :ids" )
// List<Container> getAllContainer(@Param("ids") List<String> ids);

}
