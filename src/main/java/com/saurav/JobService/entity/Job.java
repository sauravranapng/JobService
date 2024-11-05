package com.saurav.JobService.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("job_table")
public class Job {
    @PrimaryKey  // Cassandra-specific primary key annotation
    private Long id;
    private String description;
    private String status;
}
