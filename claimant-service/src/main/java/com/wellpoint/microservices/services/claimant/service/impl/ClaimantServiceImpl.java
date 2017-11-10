package com.wellpoint.microservices.services.claimant.service.impl;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.exception.ClaimantException;
import com.wellpoint.microservices.services.claimant.repository.ClaimantRepository;
import com.wellpoint.microservices.services.claimant.service.IClaimantService;


/**
 * Service implementation class for claimants
 */
@Service
public class ClaimantServiceImpl implements IClaimantService {
	
	@Autowired
	ClaimantRepository claimantRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ClaimantServiceImpl.class);
	/**
	 * Retrieving claimant information for the given claimant Id
	 */
	@Override
	public Claimant getClaimantInfo(String id) throws ClaimantException {
		
		try {
			log.info("going to retrieve claimant with claimant id" + id);
			Claimant claimant =  claimantRepository.findByClaimantId(id);
			if(claimant != null)
			{
				log.info("claimant name is " + claimant.getFirstName() + " ," + claimant.getLastName());
			}
			return claimant;
		} catch (Exception e)
		{
			throw new ClaimantException("Error occured while retrieving findBy", "CLMNT_003",e);
		}
				
	}
	/**
	 * create/update the claimant
	 */
	@Override
	public void updateClaimant(Claimant claimant) throws ClaimantException {
		log.info("going to update claimant with claimant id" + claimant.getClaimantId());
		claimantRepository.updateClaimant(claimant);
		
	}
	/**
	 * Retrieve the claimant details for the given last name
	 */
	@Override
	public List<Claimant> getClaimantByLastName(String lastName) throws ClaimantException {
		try {
			log.info("Retrieving claimants for last name " + lastName);
			List<Claimant> lstClmt = claimantRepository.findByLastName(lastName);
			if(lstClmt != null && lstClmt.size() > 0)
			{
				log.info("Retrieving claimants with last name " + ReflectionToStringBuilder.toString(lstClmt));
			}
			return claimantRepository.findByLastName(lastName);
		} catch (Exception e)
		{
			throw new ClaimantException("Error ocuured while invoking getClaimantByLastName", "CLMNT_004",e);
		}
	}
	/**
	 * Retrieve all claimants
	 * @return
	 * @throws ClaimantException
	 */
	public List<Claimant> getAllClaimants() throws ClaimantException  {
		
		try {
			return claimantRepository.findAll();
		} catch (Exception e)
		{
			throw new ClaimantException("Error ocuured while invoking findAll", "CLMNT_005",e);
		}
	}

}
