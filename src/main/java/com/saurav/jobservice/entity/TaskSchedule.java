package com.saurav.jobService.entity;

import com.saurav.jobService.util.TaskSchedulePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("task_schedule")
public class TaskSchedule{

    @PrimaryKey
    private TaskSchedulePrimaryKey key;

    @Column("user_id")
    private UUID userId;

}