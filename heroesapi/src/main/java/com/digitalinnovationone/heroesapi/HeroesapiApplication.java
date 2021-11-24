package com.digitalinnovationone.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(HeroesapiApplication.class, args);
	}

}
