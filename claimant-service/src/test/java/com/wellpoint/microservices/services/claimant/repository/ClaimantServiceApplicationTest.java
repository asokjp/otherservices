package com.wellpoint.microservices.services.claimant.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

// Defined Spring Boot Main application for test profile to exclude auto-configuration
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,EmbeddedMongoAutoConfiguration.class})
public class ClaimantServiceApplicationTest {
	
	public static void main(String[] args) {
        SpringApplication.run(ClaimantServiceApplicationTest.class, args);
    }

}
