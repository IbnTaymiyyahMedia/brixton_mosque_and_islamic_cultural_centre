package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class MULTI_PRODUCT_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL PRODUCT_ITEM = new MESSAGE_MODEL() {
		{
			put(KEY.product_retailer_id, "<YOUR_PRODUCT1_SKU_IN_CATALOG>");
		}
	};
	
	List<MESSAGE_MODEL> PRODUCT_ITEMS = Arrays.asList(PRODUCT_ITEM, PRODUCT_ITEM);
	
	public final MESSAGE_MODEL SECTION = new MESSAGE_MODEL() {
		{
			put(KEY.title, "<SECTION1_TITLE>");
            put(KEY.product_items, PRODUCT_ITEMS);
		}
	};
	
	List<MESSAGE_MODEL> SECTIONS = Arrays.asList(SECTION, SECTION);
	
	public final MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.catalog_id, "367025965434465");
			put(KEY.sections, SECTIONS);
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

	public final MESSAGE_MODEL HEADER = new MESSAGE_MODEL() {
		{
			put(KEY.type, "<HEADER_TYPE>");
			put(KEY.text, "<YOUR_TEXT_HEADER_CONTENT>");
		}
	};

	public final MESSAGE_MODEL INTERACTIVE = new MESSAGE_MODEL() {
		{
			put(KEY.type, "product");
			put(KEY.header, HEADER);
			put(KEY.body, BODY);
			put(KEY.footer, FOOTER);
			put(KEY.action, ACTION);
		}
	};

	public MULTI_PRODUCT_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "interactive");
		put(KEY.interactive, INTERACTIVE);
	}
}
