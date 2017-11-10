package com.wellpoint.microservices.services;

import io.undertow.UndertowOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceApplication {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	 public static void main(String[] args) {
	        SpringApplication application = new SpringApplication(ServiceApplication.class);
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
