package com.saurav.JobService.util;


import com.saurav.JobService.JobServiceApplication;
import com.saurav.JobService.dto.JobDto;
import com.saurav.JobService.entity.Job;

public class Mapper {
    // map the job entity to job dto
    public static JobDto mapToJobDto(Job job) {
        return JobServiceApplication.modelMapper().map(job, JobDto.class);
    }

    // map the user entity to user dto
    public static Job mapToJobEntity(JobDto jobDto) {
        return JobServiceApplication.modelMapper().map(jobDto, Job.class);
    }

}