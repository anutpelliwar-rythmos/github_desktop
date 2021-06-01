package com.example.demo.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.example.demo.model.Student;

@MessagingGateway
public interface IntegrationGateway {

	
	@Gateway(requestChannel="integration.student.gateway.channel")
	public String processStudentDetails(Student student);
	
}
