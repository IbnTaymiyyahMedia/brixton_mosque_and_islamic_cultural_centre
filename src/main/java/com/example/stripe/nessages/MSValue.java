package com.example.stripe.nessages;

import java.util.List;

public class MSValue {
	private String message_product;
	private List<MSContact> contacts;
	private List<MSMessage> messages;
	private List<MSError> errors;
	private List<MSStatus> statuses;
	
	private MSMetadata metadata;

	public String getMessage_product() {
		return message_product;
	}

	public void setMessage_product(String message_product) {
		this.message_product = message_product;
	}

	public MSMetadata getMetadata() {
		// TODO Auto-generated method stub
		return metadata;
	}

	public void setMSMetadata(MSMetadata metadata) {
		this.metadata = metadata;
	}
	
	public List<MSContact> getContacts() {
		return contacts;
	}

	public void setContacts(List<MSContact> contacts) {
		this.contacts = contacts;
	}
	
	public List<MSMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<MSMessage> messages) {
		this.messages = messages;
	}
	
	public List<MSError> getErrors() {
		return errors;
	}

	public void setErrors(List<MSError> errors) {
		this.errors = errors;
	}

	public List<MSStatus> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<MSStatus> statuses) {
		this.statuses = statuses;
	}
}
