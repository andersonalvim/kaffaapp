package com.kaffa.kaffaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.kaffa.kaffaapp"})
@EnableJpaRepositories("com.kaffaapp.repository")
public class KaffaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaffaappApplication.class, args);
	}

}
