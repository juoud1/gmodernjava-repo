package com.dobatii.gworkummymodernjava.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dobatii.gworkummymodernjava.model.MessageData;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MessageRepositoryImpl implements MessageRepository{
	
	private static List<MessageData> datas = new ArrayList<>();
	
	public MessageRepositoryImpl() {
		var builder = MessageData.builder();
		
		datas = List.of(builder.messageText("Hello world!").build(),
						builder.messageText("Hello world from Dongongo's familly!").build());
		log.info("\n{} data in the repository.".toUpperCase(), datas.size());
		
		log.info("message repository ready!".toUpperCase());
	}
	
	@Override
	public List<MessageData> findAll() {
		return null != datas ? datas : Collections.emptyList();
	}

	@Override
	public Optional<MessageData> findOne(String msgText) {
		
		if (null == msgText || null == datas)
			return Optional.empty();
		
		return datas.stream()
				.filter(m -> msgText.trim().equalsIgnoreCase(m.getMessageText().trim()))
				.findAny();
	}

}
