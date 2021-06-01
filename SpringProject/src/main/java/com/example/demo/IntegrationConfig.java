package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.MessageChannel;



@Configuration
@EnableIntegration 
@IntegrationComponentScan
public class IntegrationConfig {

	@Bean
	public MessageChannel receiverChannel() {
		return new DirectChannel();
		
	}
	
	@Bean
	public MessageChannel replyChannel() {
		return new DirectChannel();
		
	}
	
	@ServiceActivator(inputChannel= "router.channel")
	@Bean
	public PayloadTypeRouter router() {
		PayloadTypeRouter router= new PayloadTypeRouter();
		router.setChannelMapping(Student.class.getName(), "student.channel");
		router.setChannelMapping(Address.class.getName(), "address.channel");
		return router;
	}
}
