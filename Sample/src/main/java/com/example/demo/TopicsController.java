package com.example.demo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicService topicService;
	@RequestMapping(path="/topics",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Topics> getAllTopics(){
		
		return topicService.getAllTopics();
	}
	@RequestMapping(path="/topics/{id}")
	public Topics getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	

}
