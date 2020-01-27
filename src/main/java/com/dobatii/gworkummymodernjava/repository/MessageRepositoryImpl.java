package com.dobatii.gworkummymodernjava.repository;

import java.util.ArrayList;
import java.util.Arrays;
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
		datas = Arrays.asList(MessageData.builder()
				.messageText("Hello world!")
				.build(),
				MessageData.builder()
				.messageText("Hello word from Dongongo's familly!")
				.build());
		log.info("{} data in the repository.".toUpperCase(), datas.size());
		log.info("message repository ready!".toUpperCase());
	}
	
	@Override
	public List<MessageData> findAll() {
		return null != datas ? new ArrayList<>(datas) : Collections.emptyList();
	}

	@Override
	public Optional<MessageData> findOne(String msgText) {
		
		if (null == msgText)
			return Optional.empty();
		
		List<MessageData> messages = new ArrayList<>(datas);
		
		return messages.stream()
				.filter(m -> msgText.trim().equalsIgnoreCase(m.getMessageText().trim()))
				.findAny();
	}

}
