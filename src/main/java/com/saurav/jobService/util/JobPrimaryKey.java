package com.saurav.jobService.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyClass
public class JobPrimaryKey {
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private UUID userId;

    @PrimaryKeyColumn(name = "job_id", type = PrimaryKeyType.CLUSTERED, ordinal = 1)
    private UUID jobId;

}
