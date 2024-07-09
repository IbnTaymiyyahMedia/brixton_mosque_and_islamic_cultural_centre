package com.example.stripe.http;

import java.util.Map;

public interface RestClientGet {

	public String get(String uri, Map<String,String> headers);
}
