package com.dobatii.gworkummymodernjava.ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dobatii.gworkummymodernjava.model.MessageData;
import com.dobatii.gworkummymodernjava.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MessageController {
	private final MessageService service;
	
	public MessageController(MessageService service) {
		this.service = service;
		
		log.info("message controller ready!".toUpperCase());
	}
	
	@GetMapping
	public List<MessageData> getMessages() {
		
		return service.getMessages();
	}
}
