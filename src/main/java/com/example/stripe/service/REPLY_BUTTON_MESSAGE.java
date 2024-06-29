package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class REPLY_BUTTON_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL BODY = new MESSAGE_MODEL() {
		{
			put(KEY.text, "<BODY_TEXT>");
		}
	};

	public final MESSAGE_MODEL REPLY = new MESSAGE_MODEL() {
		{
			put(KEY.id, "<UNIQUE_BUTTON_ID_1>");
			put(KEY.title, "<BUTTON_TITLE_1>");
		}
	};

	public final MESSAGE_MODEL BUTTON = new MESSAGE_MODEL() {
		{
			put(KEY.type, "reply");
			put(KEY.reply, REPLY);
		}
	};

	public List<MESSAGE_MODEL> BUTTONS = Arrays.asList(BUTTON, BUTTON);

	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.buttons, BUTTONS);
		}
	};

	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "button");
			put(KEY.body, BODY);
			put(KEY.action, ACTION);
		}
	};

	public REPLY_BUTTON_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
