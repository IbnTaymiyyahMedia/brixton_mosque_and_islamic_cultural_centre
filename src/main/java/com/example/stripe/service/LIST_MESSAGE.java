package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class LIST_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL HEADER = new MESSAGE_MODEL() {
		{
			put(KEY.type, "text");
			put(KEY.text, "<HEADER_TEXT>");
		}
	};

	public final MESSAGE_MODEL BODY = new MESSAGE_MODEL() {
		{
			put(KEY.text, "<BODY_TEXT>");
		}
	};

	public final MESSAGE_MODEL FOOTER = new MESSAGE_MODEL() {
		{
			put(KEY.text, "<FOOTER_TEXT>");
		}
	};

	public final MESSAGE_MODEL ROW = new MESSAGE_MODEL() {
		{
			put(KEY.id, "<LIST_SECTION_1_ROW_1_ID>");
			put(KEY.title, "<SECTION_1_ROW_1_TITLE>");
			put(KEY.description, "<SECTION_1_ROW_1_DESC>");
		}
	};

	public List<MESSAGE_MODEL> ROWS = Arrays.asList(ROW, ROW);

	public final MESSAGE_MODEL SECTION = new MESSAGE_MODEL() {
		{
			put(KEY.title, "<LIST_SECTION_1_TITLE>");
			put(KEY.rows, ROWS);
		}
	};

	public List<MESSAGE_MODEL> SECTIONS = Arrays.asList(SECTION, SECTION);

	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.button, "<BUTTON_TEXT>");
			put(KEY.sections, SECTIONS);
		}
	};

	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "list");
			put(KEY.header, HEADER);
			put(KEY.body, BODY);
			put(KEY.footer, FOOTER);
			put(KEY.action, ACTION);
		}
	};

	public LIST_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
