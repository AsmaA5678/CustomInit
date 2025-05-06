package com.ady.initializr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching      // Add only if using caching
@EnableAsync        // Add only if using async methods
public class CustomSpringInitializrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomSpringInitializrApplication.class, args);
	}

	@Override
	public void run(String... args) {
	}
}