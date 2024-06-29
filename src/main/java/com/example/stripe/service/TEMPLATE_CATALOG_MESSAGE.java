package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class TEMPLATE_CATALOG_MESSAGE extends MESSAGE_MODEL {

	public MESSAGE_MODEL LANGUAGE = new MESSAGE_MODEL() {
		{
			put(KEY.code, "en_US");
		}
	};

	public MESSAGE_MODEL ACTION = new MESSAGE_MODEL() {
		{
			put(KEY.thumbnail_product_retailer_id, "2lc20305pt");
		}
	};

	public MESSAGE_MODEL PARAMETER = new MESSAGE_MODEL() {
		{
			put(KEY.type, "text");
			put(KEY.text, "100");
			put(KEY.action, ACTION);
		}
	};

	List<MESSAGE_MODEL> PARAMETERS = Arrays.asList(PARAMETER, PARAMETER);

	public MESSAGE_MODEL COMPONENT = new MESSAGE_MODEL() {
		{
			put(KEY.type, "body");
			put(KEY.sub_type, "CATALOG");
			put(KEY.index, 0);
			put(KEY.parameters, PARAMETERS);
		}
	};

	List<MESSAGE_MODEL> COMPONENTS = Arrays.asList(COMPONENT, COMPONENT);

	public MESSAGE_MODEL TEMPLATE = new MESSAGE_MODEL() {
		{
			put(KEY.name, "intro_catalog_offer");
			put(KEY.language, LANGUAGE);
			put(KEY.components, COMPONENTS);
		}
	};

	public TEMPLATE_CATALOG_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "+16505551234");
		put(KEY.type, "template");
		put(KEY.template, TEMPLATE);
	}
}
