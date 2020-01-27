package com.dobatii.gworkummymodernjava.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MessageData {
	private String messageText;

	@Override
	public int hashCode() {
		return Objects.hash(messageText);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageData other = (MessageData) obj;
		return Objects.equals(messageText, other.messageText);
	}

}
