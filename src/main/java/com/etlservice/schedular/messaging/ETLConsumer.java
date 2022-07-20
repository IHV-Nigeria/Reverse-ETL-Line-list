/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.etlservice.schedular.messaging;

import com.etlservice.schedular.model.Container;
import com.etlservice.schedular.service.ARTLineListETL;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author MORRISON.I
 */
@Component
@RequiredArgsConstructor
public class ETLConsumer {
    private final MongoTemplate mongoTemplate;
    private final ARTLineListETL aRTLineListETL;

    @RabbitListener(queues = "${etl.queue}")
    public void receive(List<Container> containerList) {
        // System.out.println("Got this");
//        ObjectMapper mm = new ObjectMapper();
//        List<String> Ids = mm.readValue(body, new TypeReference<List<String>>() {
//        });
//        System.out.println("total ids gotten: " + Ids.size());
        aRTLineListETL.extractData(containerList);
    }
//    public void receive(@Payload String body) throws JsonProcessingException {
//        // System.out.println("Got this");
//        ObjectMapper mm = new ObjectMapper();
//        List<String> Ids = mm.readValue(body, new TypeReference<List<String>>() {
//        });
//        System.out.println("total ids gotten: " + Ids.size());
//        aRTLineListETL.extractData(retrieveContainers(Ids));
//    }

    private List<Container> retrieveContainers(List<String> ids) {

        Query q = new Query();
        q.addCriteria(Criteria.where("id").in(ids));
        return mongoTemplate.find(q, Container.class);

        //  System.out.println("total container found: " + mongoData.size());
    }

}
