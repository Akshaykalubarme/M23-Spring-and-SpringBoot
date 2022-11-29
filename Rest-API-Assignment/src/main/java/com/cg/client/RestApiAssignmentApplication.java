package com.cg.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cg.entity")
@EnableJpaRepositories("com.cg.repository")
public class RestApiAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiAssignmentApplication.class, args);
	}

}
