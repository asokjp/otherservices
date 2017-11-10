package com.wellpoint.microservices.services.claimant.repository;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@ComponentScan(basePackages = "com.wellpoint.microservices.services.claimant")
@EnableMongoRepositories(basePackages = "com.wellpoint.microservices.services.claimant.repository")
@Profile("test")
@TestConfiguration
@Configuration
// configuration class for FongoDB
public class FongoClaimantConfiguration extends AbstractMongoConfiguration {

	@Bean
	@Override
	protected String getDatabaseName() {
		return "claimant";
	}
	

	@Bean
	@Override
	public Mongo mongo() throws Exception {
		return new Fongo("claimant").getMongo();
	}

	@Bean
	@Override
    protected String getMappingBasePackage() {
        return "com.wellpoint.microservices.services.claimant.domain";
    }
	
	@Bean
    @Override
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
