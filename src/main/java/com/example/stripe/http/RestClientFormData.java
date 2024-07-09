package com.example.stripe.http;

import java.util.Map;

public interface RestClientFormData {

	String postFormData(String url, Map<String, String> data, Map<String, String> postHeaders);

}
