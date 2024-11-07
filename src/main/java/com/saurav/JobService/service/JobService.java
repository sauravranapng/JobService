package com.saurav.JobService.service;

import com.saurav.JobService.dto.JobDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface JobService {
    JobDto createJob(String userId, JobDto jobDto);
}

