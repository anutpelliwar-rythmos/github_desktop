package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/integrate")
public class IntegrationController {

	@Autowired
	private IntegrationGateway integrationGateway;

	@PostMapping(path="/student",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public void processStudentDetails(@RequestBody Student student) {
		integrationGateway.process(student);
	}

	@PostMapping("/address")
	public void processAddressDetails(@RequestBody Address address) {
		integrationGateway.process(address);
	}
}