package com.saurav.jobService.util;


import com.saurav.jobService.JobServiceApplication;
import com.saurav.jobService.dto.JobDto;
import com.saurav.jobService.entity.Job;

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