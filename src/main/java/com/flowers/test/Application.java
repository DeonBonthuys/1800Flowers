package com.flowers.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.flowers.test.services.TestService;

@SpringBootApplication
public class Application 
{
	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner init(RestTemplate restTemplate, TestService tService) throws Exception {
		return args -> {
			tService.populate(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Post[].class));
		};
	}
}
