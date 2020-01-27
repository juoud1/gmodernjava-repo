package com.dobatii.gworkummymodernjava.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dobatii.gworkummymodernjava.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfiguration {
	
	@Bean
	public ApplicationRunner MessagingRunner(MessageService service) {
		
		return args -> service.getMessages().
				forEach(m -> log.info(m.getMessageText()));
	}
}
