package com.example.demo.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.router.ErrorMessageExceptionTypeRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public class StudentService {

	@ServiceActivator(inputChannel="integration.student.objectToJson.channel",outputChannel="integration.student.jsonToObject.channel")
	public Message<?> receiverMessage(Message<?> message) throws MessagingException{
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
		System.out.println(message);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Object to Json" + message.getPayload());
		return message;
		
	}
	@ServiceActivator(inputChannel="integration.student.jsonToObject.fromTransformer.channel")
	public void processJsonToObject(Message<?> message) throws MessagingException{
	MessageChannel replyChannel=(MessageChannel)message.getHeaders().getReplyChannel();
	MessageBuilder.fromMessage(message);
	System.out.println("$$$$$$$$$$$$$$$$$$$$");
	System.out.println(" Json to Object" + message.getPayload());
	Student student=(Student)message.getPayload();
	Message<?> newMessage=MessageBuilder.withPayload(student.toString()).build();
	replyChannel.send(newMessage);
	}
}
