package com.saurav.JobService.controller;
import com.saurav.JobService.dto.JobDto;
import com.saurav.JobService.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobservice")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<JobDto> createJob(@PathVariable String user_id, @RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobService.createJob(user_id,jobDto));
    }
    @GetMapping("/{user_id}/{job_id}")
    public ResponseEntity<JobDto> getJob(@PathVariable String user_id, @PathVariable String job_id) {
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJob(user_id,job_id));
    }
    @PutMapping("/{user_id}/{job_id}")
    public ResponseEntity<JobDto> updateJob(
            @PathVariable String user_id,
            @PathVariable String job_id,
            @RequestBody JobDto jobDto) {
        JobDto updatedJob = jobService.updateJob(user_id, job_id, jobDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedJob);
    }
    @DeleteMapping("/{user_id}/{job_id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String user_id, @PathVariable String job_id) {
        jobService.deleteJob(user_id, job_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
