package com.saurav.jobService.dto;

import com.saurav.jobService.util.JobDtoPrimaryKey;
import com.saurav.jobService.util.JobPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;


@Getter
@Setter
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
