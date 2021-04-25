package com.techadam.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@OpenAPIDefinition(info =
	@Info(title = "Spring-Data-CRUD-Operations", version = "1.0", description = "Documentation Spring-Data CRUD API v1.0")
)
public class SpringDataRestApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
		LOGGER.info("Spring Data REST Service Started");
	}

}
