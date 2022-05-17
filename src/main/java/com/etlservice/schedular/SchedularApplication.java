package com.etlservice.schedular;

import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.mongorepo.MongoRepos;
import com.etlservice.schedular.serviceImpl.ARTLineListETLImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedularApplication implements CommandLineRunner {
    
    @Autowired
    MongoRepos mongoRepos;
    
    @Autowired
    ARTLineListETLImpl aRTLineListETLImpl;
    
    public static void main(String[] args) {
        SpringApplication.run(SchedularApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        //quick test
         System.out.println("starting testing");
         
        Pageable pageRequest = PageRequest.of(0, 1000);
        
        List<Container> onePage = mongoRepos.findAll();
        
        System.out.println("total container found: "+onePage.size());
        
        aRTLineListETLImpl.extractData(onePage);
        
    }
    
}
