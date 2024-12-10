package com.saurav.jobService.entity;

import com.saurav.jobService.util.JobPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("job_table")
public class Job {

        @PrimaryKey
        private JobPrimaryKey jobPrimaryKey;


        private boolean recurring;

        @CassandraType(type = CassandraType.Name.TEXT)
        private  String description;

        @CassandraType(type = CassandraType.Name.TEXT)
        private String interval;

        private int maxRetryCount;

        @Column("createdtime")
        @CassandraType(type = CassandraType.Name.TIMESTAMP)
        private Instant createdTime; // Use TIMESTAMP for Instant

}
