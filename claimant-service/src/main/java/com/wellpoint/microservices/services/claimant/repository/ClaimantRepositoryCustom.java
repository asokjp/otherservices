package com.wellpoint.microservices.services.claimant.repository;

import org.springframework.stereotype.Repository;

import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.exception.ClaimantException;

@Repository
/**
 * 
 * Spring data mongo DB Claimant custom interface for extending additional capabilities
 *
 */
public interface ClaimantRepositoryCustom {
	
	void updateClaimant(Claimant claimant) throws ClaimantException;

}
