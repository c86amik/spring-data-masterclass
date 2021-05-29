package com.springcavaj.springmongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataMongoRestApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataMongoRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoRestApplication.class, args);
		LOGGER.info("Spring Data REST Service Started");
	}

}
