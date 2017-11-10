package com.wellpoint.microservices.services.claimant;

import io.undertow.UndertowOptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ClaimantServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(ClaimantServiceApplication.class);
	 public static void main(String[] args) {
		/* String kubeSvcHost, kubeSvcPort;
		 if ((kubeSvcHost = System.getenv("KUBERNETES_SERVICE_HOST")) != null &&
		        (kubeSvcPort = System.getenv("KUBERNETES_SERVICE_PORT_HTTPS")) != null) {
		        System.setProperty("kubernetes.master", kubeSvcHost + ":" + kubeSvcPort);
		        log.info("The value of kubernetes.master is : " + kubeSvcHost + ":" + kubeSvcPort);
		    }*/
	        SpringApplication application = new SpringApplication(ClaimantServiceApplication.class);
	        application.addListeners(new ApplicationPidFileWriter());
	        application.setWebEnvironment(true);
	        application.run(args);
	    }
	   
	 @Bean
		UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
			UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
			factory.addBuilderCustomizers(
					builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
			return factory;
		}

}
