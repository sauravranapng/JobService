package com.saurav.jobService.entity;

import com.saurav.jobService.util.TaskSchedulePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("task_schedule")
public class TaskSchedule{

    // Getters and Setters
    @PrimaryKey
    private TaskSchedulePrimaryKey key;

}