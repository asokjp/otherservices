package com.wellpoint.microservices.services.claimant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wellpoint.microservices.services.claimant.domain.Claimant;

@Repository
/**
 * 
 * spring Data MongoDB Claimant repository interface
 *
 */
public interface ClaimantRepository extends MongoRepository<Claimant, String> , ClaimantRepositoryCustom {
			
	Claimant findByClaimantId(String claimantId);
		
	List<Claimant> findByLastName(String lastName);

}
