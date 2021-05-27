package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topics> topics=new ArrayList<> (Arrays.asList(
			new Topics("spring","spring framework","spring farmework description"),
			new Topics("spring boot","spring boot","spring booot description"),
			new Topics("java","core java","core java description")
			));

public List<Topics> getAllTopics(){
	return topics;
}

public Topics getTopic(String id) {
	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
}


}



