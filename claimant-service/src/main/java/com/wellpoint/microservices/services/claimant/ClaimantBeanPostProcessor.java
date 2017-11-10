package com.wellpoint.microservices.services.claimant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClaimantBeanPostProcessor //implements BeanPostProcessor {
{
	/*boolean isMongoInitialized = false;
	 
    @Value("${spring.cloud.kubernetes.secrets.paths}")
    String trustFilePath;
 
    @Value("${trust.file.name}")
    String trustFileName;
 
    @Value("${trust.file.password}")
    String trustFilePassword;
    
    private static final Logger log = LoggerFactory.getLogger(ClaimantBeanPostProcessor.class);
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (!isMongoInitialized &&
            beanName.endsWith("MongoProperties")) {
            isMongoInitialized = true;
            if (trustFilePath != null && trustFilePath.length() > 0 &&
                trustFileName != null && trustFileName.length() > 0 &&
                trustFilePassword != null && trustFilePassword.length() > 0) {
                System.setProperty("javax.net.ssl.trustStore", trustFilePath + "/" + trustFileName);
                System.setProperty("javax.net.ssl.trustStorePassword", trustFilePassword);
                log.info("setting trust store file name as: " + trustFilePath + "/" + trustFileName);
                log.info("setting trust store file password as: " + trustFilePassword);
            }
        }
        return bean;
    }
 
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
*/
}
