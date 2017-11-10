package com.wellpoint.microservices.services.claimant;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.repository.ClaimantRepository;
import com.wellpoint.microservices.services.claimant.repository.ClaimantServiceApplicationTest;
import com.wellpoint.microservices.services.claimant.repository.FongoClaimantConfiguration;


@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ClaimantServiceApplicationTest.class,FongoClaimantConfiguration.class})
@Import(FongoClaimantConfiguration.class)
@ActiveProfiles("test")
/**
 * 
 * Base class for generating automated contract test case from consumer contracts
 * 
 */
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    ClaimantRepository repository;
    
	
	 @Rule
	 public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("claimant");
	 
    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(context);
        // Priority given in the contract seems to be not working, because of which retrieve is called prior to update and testing is getting failed
        //As an alternate mechanism, will have to first set the test data by saving a sample claimant. 
        Claimant claimant = new Claimant();
        claimant.setClaimantId("119bbacd-9c03-4044-867f-4c26e8f715f6");
        claimant.setFirstName("Arthur");
        claimant.setLastName("Portas");
        claimant.setEmail("Arthur@test.com");
        claimant.setAge(45);
        repository.updateClaimant(claimant);
    }
}