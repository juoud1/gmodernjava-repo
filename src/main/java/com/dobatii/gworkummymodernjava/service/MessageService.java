package com.dobatii.gworkummymodernjava.service;

import java.util.List;
import java.util.Optional;

import com.dobatii.gworkummymodernjava.model.MessageData;

public interface MessageService {
	public List<MessageData> getMessages();
	public Optional<MessageData> getMessage(String msgText);
}
