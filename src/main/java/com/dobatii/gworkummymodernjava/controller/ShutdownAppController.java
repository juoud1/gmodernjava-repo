package com.dobatii.gworkummymodernjava.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ShutdownAppController implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@PostMapping("shutdownApp")
	public void shutdownContext() {
		((ConfigurableApplicationContext) this.applicationContext).close();
		
		log.info("Application {} is closed with success!".toUpperCase(), applicationName);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
		log.info("Application shudown endpoint is ready to close the context!".toUpperCase());
	}
	
	
}
