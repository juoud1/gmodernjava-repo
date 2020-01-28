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
	public ApplicationRunner objectsRunner(ObjectsUtil objects) {
		return args ->   {
			objects.useIsNull();
			objects.useCompare();
			objects.useRequireNonNull();
			objects.useEquals();
			return;
		};
		
	}
	
	@Bean
	public ApplicationRunner messagingRunner(MessageService service) {
		
		return args -> service.getMessages().
				forEach(m -> log.info(m.getMessageText()));
	}
}
