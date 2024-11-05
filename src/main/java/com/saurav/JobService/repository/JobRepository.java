package com.saurav.JobService.repository;


import com.saurav.JobService.entity.Job;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CassandraRepository<Job, Long> {
}
