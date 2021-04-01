package com.test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BowlingAlley {

	public static void main(String[] args) {
		SpringApplication.run(BowlingAlley.class, args);
	}

	@Bean
	public ObjectMapper myObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		return objectMapper;
	}

}
