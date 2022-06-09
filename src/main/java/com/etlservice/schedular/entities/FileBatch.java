package com.etlservice.schedular.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileBatch {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long fileBatchId;
    private String zipFileName;
    private String batchNumber;
    private LocalDateTime uploadDate;
    private String status;
    private Long userId;
}
