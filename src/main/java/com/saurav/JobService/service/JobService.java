package com.saurav.JobService.service;

import com.saurav.JobService.dto.JobDto;


public interface JobService {
    JobDto createJob(String userId, JobDto jobDto);
    JobDto getJob(String userId, String jobId);
    JobDto updateJob( String userId ,String jobId,JobDto jobDto);
    void deleteJob(String  userId ,String jobId);


}

