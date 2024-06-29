package com.example.stripe.service;

public class LOCATION_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL LOCATION = new MESSAGE_MODEL() {
		{
			put(KEY.latitude, 37.758056);
			put(KEY.longitude, -122.425332);
			put(KEY.name, "META HQ");
			put(KEY.address, "1 Hacker Way, Menlo Park, CA 94025");
		}
	};

	LOCATION_MESSAGE() {
		put(KEY.messaging_product, "whatsapp");
		put(KEY.recipient_type, "individual");
		put(KEY.to, "{{Recipient-Phone-Number}}");
		put(KEY.type, "location");
		put(KEY.location, LOCATION);
	}

}
