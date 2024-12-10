package com.saurav.jobService;
import com.saurav.jobService.dto.JobDto;
import com.saurav.jobService.entity.Job;
import com.saurav.jobService.util.JobPrimaryKey;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.UUID;


@ComponentScan(basePackages = "com.saurav.JobService")
@SpringBootApplication(/*exclude = {CassandraDataAutoConfiguration.class, CassandraAutoConfiguration.class}*/)
@EnableCassandraRepositories(basePackages = "com.saurav.JobService.repository")
public class JobServiceApplication {
	@Bean
	public static ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}


	public static void main(String[] args) {
		SpringApplication.run(JobServiceApplication.class, args);
	}
}
