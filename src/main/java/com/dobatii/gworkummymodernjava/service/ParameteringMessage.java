package com.dobatii.gworkummymodernjava.service;

import java.util.Optional;

import com.dobatii.gworkummymodernjava.model.MessageData;

@FunctionalInterface
public interface ParameteringMessage {
	public Optional<MessageData> getMessage(String msgText);
}
