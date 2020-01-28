package com.dobatii.gworkummymodernjava.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dobatii.gworkummymodernjava.model.MessageData;
import com.dobatii.gworkummymodernjava.service.MessageService;

import lombok.extern.slf4j.Slf4j;

/**
 * Working with the new java.util.Objects
 * @author 9386-2142 Qc inc
 *
 */

@Slf4j
@Component
public class ObjectsUtil {
	
	private MessageService service;
	
	public ObjectsUtil(MessageService service) {
		this.service = service;
		log.info("Objects utility is ready.".toUpperCase());
	}
	
	public void useEquals() {
		
		// compare state of 2 nulls
		MessageData msg = service.getMessage(null).orElseGet(() -> null);
		log.info("\nis equals, null message data : {} \nis deppEquals, null message data: {}", Objects.equals(null, msg), 
				Objects.equals(null, msg));
		
		// compare state of 2 object not null 
		msg = service.getMessage("Hello world!").orElseGet(() -> null);
		log.info("\nis equals, message data : {} \nis deppEquals, message data : {}", Objects.equals(msg, service.getMessages().get(0)), 
				Objects.equals(msg, service.getMessages().get(0)));
	}
	
	public void useIsNull() {
		MessageData msg = service.getMessage(null).orElseGet(() -> null);
		log.info("\nis null, message data : {}", Objects.isNull(msg));
		
		msg = service.getMessages().get(1);
		log.info("\nis null, message data : {}", Objects.isNull(msg));
	}
	
	public void useRequireNonNull() {
		MessageData localObj = null;
		log.info("\nrequire not null, new message data without default value : {}", localObj);
		
		localObj = Objects.requireNonNull(new MessageData(null));
		log.info("\nrequire not null, new message data without default value : {}", localObj);
	}
	
	public void useCompare() {
		
		// get list of messagedata
		List<MessageData> datas = new ArrayList<>(service.getMessages());
		
		// print datas
		datas.forEach(d -> log.info("\nmessage to compare : {}", d.getMessageText()));
		
		// compare data
		Comparator<MessageData> comparator = (m, n) -> m.getMessageText().compareToIgnoreCase(n.getMessageText());
		var result = Objects.compare(datas.get(0), datas.get(1), comparator);
		log.info("\ncompare distinct message text : {}", result);
		
		result = Objects.compare(datas.get(1), datas.get(0), comparator);
		log.info("\ncompare distinct message data : {}", result);
		
		// get list of messageData's hashcode 
		var list = datas.stream()
		.map(MessageData::hashCode)
		.collect(Collectors.toList());
		
		// print hashcode
		list.forEach(i -> log.info("\ninteger to compare : {}", i));
		
		// compare hashcode
		result = Objects.compare(list.get(0), list.get(1), Comparator.naturalOrder());
		log.info("\ncompare distinct integer : {}", result);
		
		// compare null
		result = Objects.compare(null, null, Comparator.naturalOrder());
		log.info("\ncompare null : {}", result);
		
		// compare strings blank and empty
		String s = " ";
		result = Objects.compare(s.isBlank(), s.isEmpty(), Comparator.naturalOrder());
		log.info("\ncompare strings blank and empty : {}", result);
	}
	
}
