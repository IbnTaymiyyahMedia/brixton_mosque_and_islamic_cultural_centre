package com.example.stripe.http;

import java.util.Map;

public interface RestClientDelete {

	public void delete(String uri, Map<String,String> headers);
}
