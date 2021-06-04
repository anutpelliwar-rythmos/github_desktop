package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;



@RestController
@RequestMapping("/integrate")
public class IntegrationController {

	@Autowired
	private IntegrationGateway integrationGateway;
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RabbitTemplate template;

	@PostMapping(path="/student",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public void processStudentDetails(@RequestBody Student student) {
		integrationGateway.process(student);
		studentRepository.save(student);
	}

	@PostMapping("/{details}")
    public String savedetails(@RequestBody Address address,@PathVariable String details) {
     address.setId(UUID.randomUUID().toString());
     template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTING_KEY, address);
        return "Success !!";
    }
}