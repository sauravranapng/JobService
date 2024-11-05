package com.saurav.JobService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
public class CassandraConfig {

    @Value("${datastax.astra.secure-connect-bundle}")
    private File cloudSecureBundle;

    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer() {
        return builder -> builder.withCloudSecureConnectBundle(cloudSecureBundle.toPath());
    }

}
