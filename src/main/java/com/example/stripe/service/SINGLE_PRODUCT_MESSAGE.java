package com.example.stripe.service;

public class SINGLE_PRODUCT_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.catalog_id, "367025965434465");
			put(KEY.product_retailer_id, "<ID_TEST_ITEM_1>");
		}
	};

	public final MESSAGE_MODEL BODY = new MESSAGE_MODEL() {
		{
			put(KEY.text, "<OPTIONAL_BODY_TEXT>");
		}
	};

	public final MESSAGE_MODEL FOOTER = new MESSAGE_MODEL() {
		{
			put(KEY.text, "<OPTIONAL_FOOTER_TEXT>");
		}
	};

	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "product");
			put(KEY.body, BODY);
			put(KEY.footer, FOOTER);
			put(KEY.action, ACTION);
		}
	};

	public SINGLE_PRODUCT_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
