package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class TEMPLATE_TEXT_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL CURRENCY = new MESSAGE_MODEL() {
		{
			put(KEY.fallback_value, "$100.99");
			put(KEY.code, "USD");
			put(KEY.amount_1000, 100990);
		}
	};

	public final MESSAGE_MODEL DATE_TIME = new MESSAGE_MODEL() {
		{
			put(KEY.fallback_value, "February 25, 1977");
			put(KEY.day_of_week, 5);
			put(KEY.year, 1977);
			put(KEY.month, 2);
			put(KEY.day_of_month, 25);
			put(KEY.hour, 15);
			put(KEY.minute, 33);
			put(KEY.calendar, "GREGORIAN");
		}
	};

	public final MESSAGE_MODEL PARAMETER = new MESSAGE_MODEL() {
		{
			put(KEY.type, "body");
			put(KEY.type, "text");
			put(KEY.text, "text-string");
			put(KEY.currency, CURRENCY);
			put(KEY.date_time, DATE_TIME);
		}
	};
	public final List<MESSAGE_MODEL> PARAMETERS = Arrays.asList(PARAMETER);

	public final MESSAGE_MODEL COMPONENT = new MESSAGE_MODEL() {
		{
			put(KEY.type, "body");
			put(KEY.parameters, PARAMETERS);
		}
	};

	public final List<MESSAGE_MODEL> COMPONENTS = Arrays.asList(COMPONENT);

	public final MESSAGE_MODEL LANGUAGE = new MESSAGE_MODEL() {
		{
			put(KEY.code, "language-and-locale-code");
		}
	};

	public final MESSAGE_MODEL TEMPLATE = new MESSAGE_MODEL() {
		{
			put(KEY.name, "template-name");
			put(KEY.language, LANGUAGE);
			put(KEY.components, COMPONENTS);
		}
	};

	public TEMPLATE_TEXT_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "template");
		put(KEY.template, TEMPLATE);
	}
}
