package com.techadam.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
		LOGGER.info("Spring Data REST Service Started");
	}

}
