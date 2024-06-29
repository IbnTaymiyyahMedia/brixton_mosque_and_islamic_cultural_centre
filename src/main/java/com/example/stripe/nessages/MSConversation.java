package com.example.stripe.nessages;

public class MSConversation {

	private MSOrigin origin;
	private String expiration_timestamp;

	public MSOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(MSOrigin origin) {
		this.origin = origin;
	}

	public String getExpiration_timestamp() {
		return expiration_timestamp;
	}

	public void setExpiration_timestamp(String expiration_timestamp) {
		this.expiration_timestamp = expiration_timestamp;
	}
}
