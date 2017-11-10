package com.wellpoint.microservices.services.claimant.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.exception.ClaimantException;
import com.wellpoint.microservices.services.claimant.repository.ClaimantRepositoryCustom;
import com.wellpoint.microservices.services.claimant.service.impl.ClaimantServiceImpl;

public class ClaimantRepositoryImpl implements ClaimantRepositoryCustom {
	
	 @Autowired
	 MongoTemplate mongoTemplate;
	 
	 private static final Logger log = LoggerFactory.getLogger(ClaimantServiceImpl.class);
	 
	/**
	 * Update or create a claimant
	 */
	 @Override
	public void updateClaimant(Claimant claimant) throws ClaimantException {
		// TODO Auto-generated method stub
	
		Query query = new Query(Criteria.where("claimant").is(claimant.getClaimantId()));
		
        Update update = new Update();
        update.set("firstName", claimant.getFirstName());
        update.set("lastName", claimant.getLastName());
        update.set("email", claimant.getEmail());
        update.set("age",claimant.getAge());
        
        WriteResult result= mongoTemplate.upsert(query, update, Claimant.class, "claimant");
        
        if(result == null)
        {
        	throw new ClaimantException("Error in updating Claimant", "CLM_001", null);
        }
        if(result.getN() <=0)
        {
        	throw new ClaimantException("No records got updated", "CLM_002", null);
        }
        
        log.info("Claimant got updated sucessfully for claimant id " + claimant.getClaimantId() + " and update count is " + result.getN());
      
	}
}
