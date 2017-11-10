package com.wellpoint.microservices.services.claimant.service;

import java.util.List;

import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.exception.ClaimantException;

public interface IClaimantService {
	
	Claimant getClaimantInfo(String id) throws ClaimantException;
	
	void updateClaimant(Claimant claimant) throws ClaimantException;
	
	List<Claimant> getClaimantByLastName(String lastName) throws ClaimantException;
	
}
