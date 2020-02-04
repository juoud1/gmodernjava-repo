package com.dobatii.gworkummymodernjava.service;

import java.util.List;
import com.dobatii.gworkummymodernjava.model.MessageData;

public interface MessageService extends ParameteringMessage {
	
	public List<MessageData> getMessages();
	
	enum MessageType {
		CLASSICAL (1, "That's the classic"),
		OWNER (2, "");
		
		private int index;
		private String type;
		
		MessageType(int index, String type) {
			this.index = index;
			this.type = type;

		}

		public int getIndex() {
			return this.index;
		}

		public String getType() {
			return this.type;
		}
		
	}
}
