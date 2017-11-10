package com.wellpoint.microservices.services.claimant.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.wellpoint.microservices.services.claimant.domain.Claimant;
import com.wellpoint.microservices.services.claimant.repository.ClaimantRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={ClaimantServiceApplicationTest.class,FongoClaimantConfiguration.class})
@Import(FongoClaimantConfiguration.class)
@ActiveProfiles("test")
// Test class for testing MongoDN repository interaction using in-memory MongoDB - Fongo
public class ClaimantRepositoryTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ClaimantRepositoryTest.class);
	
	 @Rule
	 public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("claimant");
	 
	 @Autowired
	 private ApplicationContext applicationContext;

	 @Autowired
	 private ClaimantRepository claimantRepository;

	    @Test
	    @UsingDataSet(locations = {"/test-claimant.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	    public void testCountAllUsers() {

	        LOGGER.info("testCountAllUsers");

	        long total = this.claimantRepository.findAll().size();
	        System.out.println("total is" + total);
	        assertTrue(total == 5);

	    }
	    
	    @Test
		@UsingDataSet(locations = {"/test-claimant1.json"})
		public void shouldFindByLastName(){
	    	List<Claimant> clmntLst = claimantRepository.findAll();
			assertNotNull(clmntLst);
			assertEquals("Portas", clmntLst.get(0).getLastName());
		}
}
