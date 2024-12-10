package com.saurav.jobService.service.impl;
import com.saurav.jobService.dto.JobDto;
import com.saurav.jobService.entity.Job;
import com.saurav.jobService.entity.TaskSchedule;
import com.saurav.jobService.exception.ResourceNotFoundException;
import com.saurav.jobService.repository.JobRepository;
import com.saurav.jobService.repository.TaskScheduleRepository;
import com.saurav.jobService.service.JobService;
import com.saurav.jobService.util.JobPrimaryKey;
import com.saurav.jobService.util.Mapper;
import com.saurav.jobService.util.TaskSchedulePrimaryKey;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final TaskScheduleRepository taskScheduleRepository;// Assuming you have a repository to interact with Cassandra
    // Constructor
    public JobServiceImpl(JobRepository jobRepository ,TaskScheduleRepository taskScheduleRepository) {
        this.jobRepository = jobRepository;
        this.taskScheduleRepository=taskScheduleRepository;
    }

    // Method to create a new job
    @Override
    public JobDto createJob(String userId, JobDto jobDto) {
        jobDto.getJobDtoPrimaryKey().setJobId(UUID.randomUUID());
        jobDto.getJobDtoPrimaryKey().setUserId(UUID.fromString(userId));
        jobDto.setCreatedTime(Instant.now());
        Job job = Mapper.mapToJobEntity(jobDto);

        long nextExecutionTime = LocalDateTime.now()
                .plus(Duration.parse(job.getInterval()))
                .atZone(ZoneOffset.systemDefault())
                .toInstant()
                .getEpochSecond() / 60;
        int segment = ThreadLocalRandom.current().nextInt(1, 4);
        TaskSchedulePrimaryKey taskSchedulePrimaryKey = new TaskSchedulePrimaryKey(nextExecutionTime, segment, job.getJobPrimaryKey().getJobId());
        TaskSchedule taskSchedule = new TaskSchedule(taskSchedulePrimaryKey);

        taskScheduleRepository.save(taskSchedule);

        return  Mapper.mapToJobDto(jobRepository.save(job));

    }
    // Method to retrieve a job by user ID and job ID
    @Override
    public JobDto getJob(String userId, String jobId) {
        Job job = jobRepository.findByJobPrimaryKey(new JobPrimaryKey(UUID.fromString(userId), UUID.fromString(jobId)));
        if (job == null) {
            throw new ResourceNotFoundException("Job","userId","jobId",userId,jobId);
        }
        return Mapper.mapToJobDto(job);
    }
    // Method to update an existing job (you can add more logic to update specific fields)
    @Override
    public JobDto updateJob( String userId ,String jobId,JobDto jobDto) {
        jobDto.getJobDtoPrimaryKey().setJobId(UUID.fromString(jobId));
        jobDto.getJobDtoPrimaryKey().setUserId(UUID.fromString(userId));
        jobDto.setCreatedTime(Instant.now());
        Job job = Mapper.mapToJobEntity(jobDto);
        return  Mapper.mapToJobDto(jobRepository.save(job));
    }
    @Override
    public void deleteJob(String  userId ,String jobId) {
        jobRepository.deleteByJobPrimaryKey(new JobPrimaryKey(UUID.fromString(userId), UUID.fromString(jobId)));
    }


}