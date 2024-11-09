package com.saurav.JobService.repository;


import com.saurav.JobService.entity.Job;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends CassandraRepository<Job, UUID> {
    Job findByUserIdAndJobId(UUID userId, UUID jobId);
    Job findByJobId(UUID jobId);
    void deleteByUserIdAndJobId(UUID userId, UUID jobId);


}
