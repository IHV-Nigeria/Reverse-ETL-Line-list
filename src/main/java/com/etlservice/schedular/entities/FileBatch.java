package com.etlservice.schedular.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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
    @ManyToOne
    private User user;
}
