package com.saurav.JobService.controller;
import com.saurav.JobService.dto.JobDto;
import com.saurav.JobService.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{user_id}/jobs")
    public ResponseEntity<JobDto> createJob(@PathVariable String user_id, @RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobService.createJob(user_id,jobDto));
    }
}
