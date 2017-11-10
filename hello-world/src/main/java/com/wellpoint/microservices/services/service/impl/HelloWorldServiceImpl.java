package com.wellpoint.microservices.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.wellpoint.microservices.services.service.gateway.Claimant;
import com.wellpoint.microservices.services.service.gateway.ClaimantGateway;

@Service
@RefreshScope
/*
 * Implementation class on the service side
 */
public class HelloWorldServiceImpl implements com.wellpoint.microservices.services.service.IHelloWorldService {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Value("${defaultName:World}")
    private String defaultName;
    
    @Autowired
    private ClaimantGateway claimantGateway;
    
    @Override
    public String helloWorld(String id) {
    	Claimant claimant = getClaimantDetails(id);
    	String name = defaultName;
    	if( claimant != null)
    	{
    		StringBuilder builder = new StringBuilder();
    		builder.append(claimant.getFirstName());
    		builder.append(" , ");
    		builder.append(claimant.getLastName());
    		name = builder.toString();
    		log.info("Name returned from claimant service is " + name);
    	}
    	
        final String result = "Hello " + name;
        log.info("[RESULT]:{}", result);
        return result;
    }
    
    
    public Claimant getClaimantDetails(String id)
    {
    	return claimantGateway.getClaimant(id);
    	
    }
	

}
