package com.saurav.JobService.service.impl;

import com.saurav.JobService.dto.JobDto;
import com.saurav.JobService.service.JobService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Override
    public JobDto createJob() {
        return new JobDto();
    }
}