package com.saurav.jobService.repository;

import com.saurav.jobService.entity.TaskSchedule;
import com.saurav.jobService.util.TaskSchedulePrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskScheduleRepository extends CassandraRepository<TaskSchedule, TaskSchedulePrimaryKey> {
}
