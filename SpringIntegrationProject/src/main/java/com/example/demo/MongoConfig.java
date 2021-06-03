package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class MongoConfig {
	  @Bean
	    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
	        return strings -> {
	            studentRepository.save(new Student("1", "Peter", "Development"));
	            studentRepository.save(new Student("2", "Sam", "Operations"));
	        };
	  }
}