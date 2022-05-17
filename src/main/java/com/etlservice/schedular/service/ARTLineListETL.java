/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.service;

import com.etlservice.schedular.model.Container;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author MORRISON.I
 */

@Service
public interface ARTLineListETL {
    
    void extractData(List<Container> mongoContainers);
    
}
