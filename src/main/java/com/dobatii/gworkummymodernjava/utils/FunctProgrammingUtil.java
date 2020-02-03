package com.dobatii.gworkummymodernjava.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dobatii.gworkummymodernjava.model.MessageData;
import com.dobatii.gworkummymodernjava.service.MessageService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Working with functional interfaces
 * 
 * @author 9386-2142 Qc inc
 * @version 1.0
 * 
 */

@Slf4j
@Component
public class FunctProgrammingUtil {

	private MessageService service;

	public FunctProgrammingUtil(MessageService service) {
		super();
		this.service = service;
		
		log.info("Functional interface utility is ready.".toUpperCase());
	}
	
	public void usePredicate() {
		log.info("Using predicate starts...");
		Predicate<MessageService> msgePredicate = new Predicate<MessageService>() {

			@Override
			public boolean test(MessageService messageService) {
				log.info("In the method test() : {}");
				String result = messageService.getMessages().stream()
					.filter(d -> !d.getMessageText().contains(Constant.PREDICATE_DONGONGO))
					.map(m -> m.getMessageText())
					.collect(Collectors.joining());
				log.info("result : {}".toUpperCase(), result);
				
				return result.isBlank();
			}
		};
		
		log.info("msgePredicate.test : {} ".toUpperCase(), msgePredicate.test(service));
		log.info("Using predicate terminates with success.");
	}
	
	public void useSupplier() {
		log.info("Using supplier starts...");
		Supplier<MessageService> msgeSupplier = new Supplier<MessageService>() {

			@Override
			public MessageService get() {
				log.info("In the method get() : {}");
				service.getMessages
					().forEach(m -> log.info(m.getMessageText().toUpperCase()));
				
				return null;
			}
		};
		
		log.info("msgeSupplier.get : {}".toUpperCase(), msgeSupplier.get());
		log.info("Using supplier terminates with success.");
	}
	
	public void useConsumer() {
		
		log.info("Using consumer starts...");
		Consumer<MessageService> msgeConsumer = new Consumer<MessageService>() {

			@Override
			public void accept(MessageService messageService) {
				log.info("In the method accept()");
				messageService.getMessages()
					.forEach(data -> log.info("{}", data.getMessageText().toUpperCase()));
			}
		}; 
		
		msgeConsumer.accept(service);
		log.info("Using consumer terminates with success.");
	}
	
	public void useFunction(){
		
		log.info("Using function starts...");
		Function<MessageService, String> msgeFuntion = new Function<MessageService, String>() {

			@Override
			public String apply(MessageService messageService) {
				log.info("In the method apply().");
				return messageService.getMessages().stream()
						.filter(m -> m.getMessageText().contains(Constant.PREDICATE_DONGONGO))
						.map(MessageData::getMessageText)
						.collect(Collectors.joining());
			}
			
		};
		
		log.info("msgeFuntion.apply : {}".toUpperCase(), msgeFuntion.apply(service));
		log.info("Using function terminates with success.");
	} 
	
	
	
}
