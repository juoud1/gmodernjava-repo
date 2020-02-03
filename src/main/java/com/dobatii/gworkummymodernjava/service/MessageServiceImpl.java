package com.dobatii.gworkummymodernjava.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dobatii.gworkummymodernjava.model.MessageData;
import com.dobatii.gworkummymodernjava.repository.MessageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
	
	private final MessageRepository messageRepository;
	
	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
		log.info("message service ready!".toUpperCase());
	}

	@Override
	public List<MessageData> getMessages() {
		
		List<MessageData> datas = new ArrayList<>(messageRepository.findAll());
		log.info("get all {} messages.", datas.size());
		
		return datas;
	}
}
