package com.dobatii.gworkummymodernjava.repository;

import java.util.List;
import java.util.Optional;

import com.dobatii.gworkummymodernjava.model.MessageData;

public interface MessageRepository {
	public List<MessageData> findAll();
	public Optional<MessageData> findOne(String msgText);
	
}
