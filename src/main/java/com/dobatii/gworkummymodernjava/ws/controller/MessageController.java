package com.dobatii.gworkummymodernjava.ws.controller;

import org.springframework.web.bind.annotation.RestController;

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
	
}
