package com.etlservice.schedular.mongorepo;

import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepos extends MongoRepository<Container,String> {
}
