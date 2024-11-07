package com.saurav.JobService.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("job_table")
public class Job {
        @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
        private UUID userId;

        @PrimaryKeyColumn(name = "job_id", type = PrimaryKeyType.CLUSTERED, ordinal = 1)
        private UUID jobId;

        private boolean isRecurring;

        @CassandraType(type= CassandraType.Name.TEXT)
        private String interval;

        private int maxRetryCount;

        private Instant createdTime;

  /*
    @PrimaryKeyColumn(name = "job_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID jobId;

    @PrimaryKeyColumn(name = "execution_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Instant executionTime;

    @Column("status")
    @CassandraType(type= CassandraType.Name.TEXT)
    private String status;

    @Column("retry_count")
    private int retryCount;

    @Column("last_update_time")
    private Instant lastUpdateTime;

    @Column("description")
    @CassandraType(type= CassandraType.Name.TEXT)
    private String description;

    // Constructors, getters, and setters
*/
}
