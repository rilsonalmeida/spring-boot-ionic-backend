package com.pulsar.cursomc.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.pulsar.cursomc"})
@EntityScan({"com.pulsar.cursomc.domain"})
@EnableJpaRepositories({"com.pulsar.cursomc.repositories"})

public class CursomcApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
}
