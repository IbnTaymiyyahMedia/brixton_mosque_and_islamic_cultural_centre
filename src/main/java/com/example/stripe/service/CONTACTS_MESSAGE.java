package com.example.stripe.service;

import java.util.Arrays;
import java.util.List;

public class CONTACTS_MESSAGE extends MESSAGE_MODEL {

	public final MESSAGE_MODEL ORG = new MESSAGE_MODEL() {
		{
			put(KEY.company, "WhatsApp");
			put(KEY.department, "Design");
			put(KEY.title, "Manager");
		}
	};

	private final MESSAGE_MODEL PHONE = new MESSAGE_MODEL() {
		{
			put(KEY.phone, "+1 (940) 555-1234");
			put(KEY.type, "HOME");
		}
	};
	
	public final MESSAGE_MODEL NAME = new MESSAGE_MODEL() {
		{

			put(KEY.formatted_name, "John Smith");
			put(KEY.first_name, "John");
			put(KEY.last_name, "Smith");
			put(KEY.middle_name, "D.");
			put(KEY.suffix, "Jr");
			put(KEY.prefix, "Dr");
		}
	};
	
	public final MESSAGE_MODEL ADDRESS = new MESSAGE_MODEL() {
		{
			put(KEY.street, "1 Hacker Way");
			put(KEY.city, "Menlo Park");
			put(KEY.state, "CA");
			put(KEY.zip, "94025");
			put(KEY.country, "United States");
			put(KEY.country_code, "us");
			put(KEY.type, "HOME");
		}
	};
	
	public final List<MESSAGE_MODEL> ADRESSES = Arrays.asList(ADDRESS, ADDRESS);
	
	public final List<MESSAGE_MODEL> PHONES = Arrays.asList(PHONE, PHONE);

	public final MESSAGE_MODEL UNIFORM_RESOURCE_LOCATOR = new MESSAGE_MODEL() {
		{
			put(KEY.url, "https://www.facebook.com");
			put(KEY.type, "WORK");
		}
	};
	
	public final List<MESSAGE_MODEL> URLS = Arrays.asList(UNIFORM_RESOURCE_LOCATOR,
			UNIFORM_RESOURCE_LOCATOR);
	
	public final MESSAGE_MODEL CONTACT = new MESSAGE_MODEL() {
		{
			put(KEY.addresses, ADRESSES);
			put(KEY.birthday, "2012-08-18");
			put(KEY.name, NAME);
			put(KEY.org, ORG);
			put(KEY.phones, PHONES);
			put(KEY.urls, URLS);
		}
	};
	
	public final List<MESSAGE_MODEL> CONTACTS = Arrays.asList(CONTACT, CONTACT);
	

	public CONTACTS_MESSAGE() {
		put(KEY.type, "contacts");
		put(KEY.contacts, CONTACTS);
	}
}
