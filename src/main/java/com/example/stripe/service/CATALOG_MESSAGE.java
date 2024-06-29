package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class CATALOG_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL BODY = new MESSAGE_MODEL() {
		{
			put(KEY.text,
					"Hello! Thanks for your interest. Ordering is easy. Just visit our catalog and add items to purchase.");
		}
	};

	public final MESSAGE_MODEL FOOTER = new MESSAGE_MODEL() {
		{
			put(KEY.text, "Best grocery deals on WhatsApp!");
		}
	};

	public final MESSAGE_MODEL PARAMETER = new MESSAGE_MODEL() {
		{
			put(KEY.thumbnail_product_retailer_id, "2lc20305pt!");
		}
	};

	List<MESSAGE_MODEL> PARAMETERS = Arrays.asList(PARAMETER);

	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.name, "catalog_message");
			put(KEY.parameters, PARAMETERS);
		}
	};

	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "catalog_message");
			put(KEY.body, BODY);
			put(KEY.footer, FOOTER);
			put(KEY.action, ACTION);
		}
	};

	public CATALOG_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "+16505551234");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
