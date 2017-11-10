package com.wellpoint.microservices.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellpoint.microservices.services.service.IHelloWorldService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureStubRunner(ids = {"com.wellpoint.microservices:claimant-service:+:stubs:8082"}, workOffline = true)
@DirtiesContext
@ActiveProfiles("test")
/**
 * 
 * Test class on the consumer side. This test case will download producer stubs and use it for service virtualization
 *
 */
public class HelloWorldControllerTest  {
	
	@Autowired
    private IHelloWorldService service;

	@Test
    public void shouldGiveClaimantDetails() throws Exception {

       
        String lastName = "Portas";
        String helloString = service.helloWorld(lastName);
        assertTrue("Failed tested HelloWorldController()", "Hello Arthur , Portas".equalsIgnoreCase(helloString));
    }
	
}