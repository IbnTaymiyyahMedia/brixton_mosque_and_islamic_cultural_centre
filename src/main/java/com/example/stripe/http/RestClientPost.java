package com.example.stripe.http;

import java.util.Map;

public interface RestClientPost {

	public String post(String uri, Map<String,Object> body, Map<String,String> headers);
}
