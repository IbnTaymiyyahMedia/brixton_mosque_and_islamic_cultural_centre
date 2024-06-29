package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class ORDER_DETAILS_MESSAGE extends MESSAGE_MODEL {

	
	public final MESSAGE_MODEL AMOUNT = new MESSAGE_MODEL() {
		{
			put(KEY.value, 1000);
			put(KEY.offset, 100);
		}
	};
	
	public final MESSAGE_MODEL TAX = new MESSAGE_MODEL() {
		{
			put(KEY.value, 1000);
			put(KEY.offset, 100);
			put(KEY.description, "optional_text");
		}
	};
	
	public final MESSAGE_MODEL SHIPPING = new MESSAGE_MODEL() {
		{
			put(KEY.value, 1000);
			put(KEY.offset, 100);
			put(KEY.description, "optional_text");
		}
	};
	
	public final MESSAGE_MODEL DISCOUNT = new MESSAGE_MODEL() {
		{
			put(KEY.value, 1000);
			put(KEY.offset, 100);
			put(KEY.description, "optional_text");
			put(KEY.discount_program_name, "optional_text");
		}
	};
	
	public final MESSAGE_MODEL ITEM = new MESSAGE_MODEL() {
		{
			put(KEY.retailer_id, "1234567");
			put(KEY.name, "bread");
			put(KEY.amount, AMOUNT);
			put(KEY.quantity, 1);
			put(KEY.sale_amount, AMOUNT);
		}
	};
	
	public final MESSAGE_MODEL EXPIRATION = new MESSAGE_MODEL() {
		{
			put(KEY.timestamp, "utc_timestamp_in_seconds");
			put(KEY.description, "cancellation-explanation");
		}
	};
	
	List<MESSAGE_MODEL> ITEMS = Arrays.asList(ITEM, ITEM, ITEM);
	
	public final MESSAGE_MODEL ORDER = new MESSAGE_MODEL() {
		{
			put(KEY.status, "pending");
			put(KEY.items, ITEMS);
			put(KEY.subtotal, AMOUNT);
			put(KEY.tax, TAX);
			put(KEY.shipping, SHIPPING);
			put(KEY.discount, DISCOUNT);
			put(KEY.catalog_id, "optional-catalog_id");
			put(KEY.expiration, EXPIRATION);
		}
	};
	
	public final MESSAGE_MODEL PROVIDER = new MESSAGE_MODEL() {
		{
			put(KEY.name, "provider-name");
		}
	};
	
	public final MESSAGE_MODEL IMAGE = new MESSAGE_MODEL() {
		{
			put(KEY.link, "http(s)://the-url");
			put(KEY.provider, PROVIDER);
		}
	};
	
	public final MESSAGE_MODEL HEADER = new MESSAGE_MODEL() {
		{
			put(KEY.type, "image");
			put(KEY.body, IMAGE);
		}
	};
	
	public final MESSAGE_MODEL BODY = new MESSAGE_MODEL() {
		{
			put(KEY.text, "your-text-body-content");
		}
	};
	
	public final MESSAGE_MODEL FOOTER = new MESSAGE_MODEL() {
		{
			put(KEY.text, "your-text-footer-content");
		}
	};
	
	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.reference_id, "unique-reference-id");
			put(KEY.type, "digital-goods");
			put(KEY.payment_type, "p2m-lite:stripe");
			put(KEY.payment_configuration, "my-payment-config-name");
			put(KEY.currency, "GBP");
			put(KEY.total_amount, AMOUNT);
			put(KEY.order, ORDER);
			
		}
	};
	
	public final MESSAGE_MODEL ORDER_DETAILS = new MESSAGE_MODEL() {
		{
			put(KEY.header, HEADER);
			put(KEY.body, BODY);
			put(KEY.footer, FOOTER);
			put(KEY.action, ACTION);
		}
	};
	
	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "order_details");
			put(KEY.order_details, ORDER_DETAILS);
		}
	};
	
	public ORDER_DETAILS_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
