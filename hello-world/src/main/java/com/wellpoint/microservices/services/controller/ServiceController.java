package com.wellpoint.microservices.services.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellpoint.microservices.services.service.api.HelloWorldResponse;
import com.wellpoint.microservices.services.service.api.ResponseInfo;

/** 
 * Sample consumer class
 * 
 *
 */
@RefreshScope
@RestController
public class ServiceController {

    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
    
   @Value("${message}")
   private String message;

    @Autowired
    private com.wellpoint.microservices.services.service.IHelloWorldService service;

    @Autowired
	private HttpServletRequest request; 
    
    @RequestMapping(value="/helloWorld/{id}")
    public HelloWorldResponse helloWorld(
    		@PathVariable String id) {
        final StringBuilder tracking = new StringBuilder();
        tracking.append("[id]:").append(id);
        MDC.put("TRACKING", tracking.toString());
        log.info("Request");

        HelloWorldResponse response = new HelloWorldResponse();
        response.setHelloWorld(service.helloWorld(id));
        response.setResponseInfo(new ResponseInfo(ResponseInfo.CODE_OK, ResponseInfo.DESC_OK));

        log.info("Response: {}", response);

        return response;
    }
    
    /*
    **
	 * Returns message from respective property file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/message1")
	public String getMessage()
			throws Exception {

		return message;
	}
    
}