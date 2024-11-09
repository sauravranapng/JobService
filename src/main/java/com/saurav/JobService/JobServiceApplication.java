package com.saurav.JobService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@ComponentScan(basePackages = "com.saurav.JobService")
@SpringBootApplication(/*exclude = {CassandraDataAutoConfiguration.class, CassandraAutoConfiguration.class}*/)
@EnableCassandraRepositories(basePackages = "com.saurav.JobService.repository")
public class JobServiceApplication {
	@Bean
	public static ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(JobServiceApplication.class, args);
	}
}
