package com.example.stripe.nessages;

import java.util.List;

public class MSStatus {

	private String id;
	private String biz_opaque_callback_data;
	private MSConversation conversation;
	private List<MSError> errors;
	private MSPricing pricing;
	private String recipient_id;
	private  String status;
	private String timestamp;
	
	public String getBiz_opaque_callback_data() {
		return biz_opaque_callback_data;
	}

	public void setBiz_opaque_callback_data(String biz_opaque_callback_data) {
		this.biz_opaque_callback_data = biz_opaque_callback_data;
	}

	public MSConversation getConversation() {
		return conversation;
	}

	public void setConversation(MSConversation conversation) {
		this.conversation = conversation;
	}

	public List<MSError> getErrors() {
		return errors;
	}

	public void setErrors(List<MSError> errors) {
		this.errors = errors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MSPricing getPricing() {
		return pricing;
	}

	public void setPricing(MSPricing pricing) {
		this.pricing = pricing;
	}

	public String getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestampUnix(String timestamp) {
		this.timestamp = timestamp;
	}
}
