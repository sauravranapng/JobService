package com.saurav.jobService.repository;


import com.saurav.jobService.entity.Job;
import com.saurav.jobService.util.JobPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends CassandraRepository<Job, JobPrimaryKey> {
    Job findByJobPrimaryKey(JobPrimaryKey id);
    void deleteByJobPrimaryKey(JobPrimaryKey id);
}
