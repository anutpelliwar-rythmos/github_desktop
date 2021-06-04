/*package com.example.demo;

import org.springframework.boot.ApplicationRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class MongoConfig {
	  @Bean
	    ApplicationRunner applicationRunner(StudentService studentService) {
	        return strings -> {
	            studentService.getAllStudent();
	           
	        };
	  }
}*/