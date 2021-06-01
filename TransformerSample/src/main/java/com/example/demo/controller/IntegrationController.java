package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.IntegrationGateway;

@RestController 
@RequestMapping("/integrate")
public class IntegrationController {

	
	@Autowired
	private IntegrationGateway integrationGateway;
	
	
	@PostMapping
	public String ProcessStudentDetails(@RequestBody Student student) {
		return integrationGateway.processStudentDetails(student);
	}
}
