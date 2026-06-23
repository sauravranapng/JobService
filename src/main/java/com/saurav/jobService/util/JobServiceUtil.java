package com.saurav.jobService.util;

import java.util.UUID;

import static com.saurav.jobService.util.Constants.TOTAL_SEGMENTS;

public class JobServiceUtil {
    private JobServiceUtil(){

    }
    /*
     This method calculates the segment number for a given jobId.
     */
    public static int calculateSegment(UUID jobId) {
        return Math.abs(jobId.hashCode()) % TOTAL_SEGMENTS;
    }
}
