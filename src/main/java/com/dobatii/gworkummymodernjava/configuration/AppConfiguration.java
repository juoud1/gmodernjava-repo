package com.dobatii.gworkummymodernjava.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dobatii.gworkummymodernjava.service.MessageService;
import com.dobatii.gworkummymodernjava.utils.ObjectsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfiguration {
	
	@Bean
	public ApplicationRunner messagingRunner(MessageService service, ObjectsUtil objects) {
		
		return args -> {
				// Working with service
				log.info("Working with the service".toUpperCase());
				service.getMessages().
				forEach(m -> log.info(m.getMessageText()));
				
				// Working with new Objects utility
				log.info("Working with new Objects utility".toUpperCase());
				objects.useIsNull();
				objects.useCompare();
				objects.useRequireNonNull();
				objects.useEquals();
				
				return;
		};
	}
}
