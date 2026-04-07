package com.edudrolhe.desafio_uber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DesafioUberApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioUberApplication.class, args);
	}

}
