package com.example.demo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		boolean result = false;

		if (!"create".equals(strategy)) {
			result = false;
		} else {
			dbService.instantiateTestDatabase();
			result = true;
		}

		return result;
	}

	// @Bean
	// public EmailService emailService() {
	// return new MockEmailService();
	// }
}