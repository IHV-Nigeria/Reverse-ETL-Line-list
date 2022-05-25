/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlservice.schedular.mongorepo.postgres;

import com.etlservice.schedular.entities.FileUpload;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author MORRISON.I
 */
public interface FileUploadRepository extends JpaRepository<FileUpload, Integer> {

    @Query("select fu from FileUpload fu where fu.status = 'Consumed' ")
    List<FileUpload> findPendingFiles();
}
