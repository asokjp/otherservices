package com.wellpoint.microservices.services.claimant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.service.IClaimantService;

@RefreshScope
@RestController
public class ClaimantController {

	@Autowired
	private IClaimantService claimantservice;
	
	@Value("${message}")
	private String message;

	private static final Logger log = LoggerFactory
			.getLogger(ClaimantController.class);

	/**
	 * Entry point for updating claimant
	 * @param claimant
	 * @throws Exception
	 */
	@RequestMapping(value = "/claimant", method = RequestMethod.POST, consumes="application/json")
	public void updateClaimant(@RequestBody Claimant claimant) throws Exception

	{
		log.info("update claimant details for id" + claimant);
		claimantservice.updateClaimant(claimant);
	}
	/**
	 * Entry point for retrieving claimant based on last name
	 * @param lastName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/claimant",method=RequestMethod.GET,params="lastName")
	public Claimant getClaimantDetails(@RequestParam("lastName") String lastName)
			throws Exception {

		log.info("retrieving claimant details for lastName " + lastName);
		List<Claimant> clmntLst = claimantservice
				.getClaimantByLastName(lastName);
		if (clmntLst != null && !CollectionUtils.isEmpty(clmntLst)) {
			Claimant claimant = clmntLst.get(0);
			log.info("Returning claimant details :" + claimant);
			return claimant;
		}

		return new Claimant();

	}
	
	/**
	 * Returns message from respective property file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/message")
	public String getMessage()
			throws Exception {

		return message;

	}
}