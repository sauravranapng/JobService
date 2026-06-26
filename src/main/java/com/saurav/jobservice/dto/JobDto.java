package com.saurav.jobService.dto;

import com.saurav.jobService.util.JobDtoPrimaryKey;
import com.saurav.jobService.util.JobPrimaryKey;
import lombok.*;

import java.time.Instant;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {

    private JobDtoPrimaryKey jobDtoPrimaryKey;
    private String description;
    private boolean recurring;
    private String interval;
    private int maxRetryCount;
    private Instant createdTime;
}
