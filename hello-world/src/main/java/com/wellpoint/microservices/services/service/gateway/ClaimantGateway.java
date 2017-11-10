package com.wellpoint.microservices.services.service.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * Gateway component for invoking claimant service
 *
 */
@Component
@RefreshScope
public class ClaimantGateway {

	
	private static final Logger log = LoggerFactory
			.getLogger(ClaimantGateway.class);
	
	@Value("${claimantserver.host}")
	private String claimantServer;
	
	@Value("${claimantserver.port}")
	private String claimantServerPort;
	
	private RestTemplate restTemplate;
	
	 @Autowired
	 private HttpServletRequest request; 
	
	public ClaimantGateway(RestTemplate restTemplate)
	{
		this.restTemplate =restTemplate;
	}

	public Claimant getClaimant(String id)
    {
		
		String claimantURI = "http://" + claimantServer + ":" +  claimantServerPort + "/claimant?lastName=" + id;
		log.info("Claimant URI: " + claimantURI );
		//Claimant claimant = restTemplate.getForObject(claimantURI, Claimant.class,id);
		Claimant claimant = null;
		HttpEntity entity = getNewRequest();
		try {
			ResponseEntity<Claimant> response =restTemplate.exchange(claimantURI, HttpMethod.GET, entity, Claimant.class,id);
			 claimant =response.getBody();
		}
		catch(RestClientException re)
		{
			log.error("An error has occured while retrieving the claimant with last name: " + id + " and the error detail is:" + re.getMessage() );
			 claimant = getFallbackClaimant(id);
		}
		catch (Exception e)
		{
			log.error("An error has occured while retrieving the claimant with last name: " + id + " and the error detail is:" + e.getMessage() );
			 claimant = getFallbackClaimant(id);
		}
    	if(claimant != null)
    		log.info("Claimant detail is " + claimant );
    	
    	return claimant;
    }
	
	public HttpEntity getNewRequest()
	{
		HttpHeaders headers = new HttpHeaders();
		log.info("setting header for x-request-id  " + request.getHeader("x-request-id") );
		headers.set("x-request-id", request.getHeader("x-request-id"));
		log.info("setting header for x-b3-traceid  " + request.getHeader("x-b3-traceid") );
		headers.set("x-b3-traceid", request.getHeader("x-b3-traceid"));
		log.info("setting header for x-b3-spanid  " + request.getHeader("x-b3-spanid") );
		headers.set("x-b3-spanid", request.getHeader("x-b3-spanid"));
		log.info("setting header for x-b3-parentspanid  " + request.getHeader("x-b3-parentspanid") );
		headers.set("x-b3-parentspanid", request.getHeader("x-b3-parentspanid"));
		log.info("setting header for x-b3-sampled  " + request.getHeader("x-b3-sampled") );
		headers.set("x-b3-sampled", request.getHeader("x-b3-sampled"));
		log.info("setting header for x-b3-flags  " + request.getHeader("x-b3-flags") );
		headers.set("x-b3-flags", request.getHeader("x-b3-flags"));
		log.info("setting header for x-ot-span-context  " + request.getHeader("x-ot-span-context") );
		headers.set("x-ot-span-context", request.getHeader("x-ot-span-context"));
		HttpEntity entity = new HttpEntity(headers);
		return entity;
	}
    
    public Claimant getFallbackClaimant(String lastName)
    {
    	log.info("invoking  fallback while retrieving claimant details for claimant lastName " + lastName);
     Claimant claimant = new Claimant();
     	claimant.setLastName(lastName);
     	claimant.setClaimantId("");
     	claimant.setEmail("");
     	claimant.setClaimantId("");
     	
     	return claimant;
    }
}
