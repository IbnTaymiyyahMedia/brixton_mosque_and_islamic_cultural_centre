package com.example.stripe.http;

import java.util.Map;

public class MSPostHeader implements Map.Entry<String,String> {
	
	private final String key;
	private final String value;
	
	public MSPostHeader(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String setValue(String value) {
		// TODO Auto-generated method stub
		
		throw new  RuntimeException();
	}

}
