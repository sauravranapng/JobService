package com.saurav.JobService.service.impl;
import com.saurav.JobService.dto.JobDto;
import com.saurav.JobService.entity.Job;
import com.saurav.JobService.exception.ResourceNotFoundException;
import com.saurav.JobService.repository.JobRepository;
import com.saurav.JobService.service.JobService;
import com.saurav.JobService.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;  // Assuming you have a repository to interact with Cassandra
    // Constructor

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Method to create a new job
    @Override
    public JobDto createJob(String userId, JobDto jobDto) {
        jobDto.setJobId(UUID.randomUUID());
        jobDto.setUserId(UUID.fromString(userId));
        jobDto.setCreatedTime(Instant.now());
        Job job = Mapper.mapToJobEntity(jobDto);
         return  Mapper.mapToJobDto(jobRepository.save(job));
    }
    // Method to retrieve a job by user ID and job ID
    @Override
    public JobDto getJob(String userId, String jobId) {
        Job job = jobRepository.findByUserIdAndJobId(UUID.fromString(userId), UUID.fromString(jobId));
        if (job == null) {
            throw new ResourceNotFoundException("Job","userId","jobId",userId,jobId);
        }
        return Mapper.mapToJobDto(job);
    }
    // Method to update an existing job (you can add more logic to update specific fields)
    @Override
    public JobDto updateJob( String userId ,String jobId,JobDto jobDto) {
        jobDto.setJobId(UUID.fromString(jobId));
        jobDto.setUserId(UUID.fromString(userId));
        jobDto.setCreatedTime(Instant.now());
        Job job = Mapper.mapToJobEntity(jobDto);
        return  Mapper.mapToJobDto(jobRepository.save(job));
    }
    @Override
    public void deleteJob(String  jobId ,String userId) {
        jobRepository.deleteByUserIdAndJobId(UUID.fromString(userId),UUID.fromString(jobId));
    }


}