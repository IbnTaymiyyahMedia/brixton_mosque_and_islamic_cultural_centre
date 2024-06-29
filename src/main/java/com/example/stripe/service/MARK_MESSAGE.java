package com.example.stripe.service;

public class MARK_MESSAGE extends MESSAGE_MODEL {

	public MARK_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.status, "read");
		put(KEY.message_id, "wamid.234123");
	}
}
