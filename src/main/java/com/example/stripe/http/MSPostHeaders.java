package com.example.stripe.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MSPostHeaders implements Map<String,String> {

	private final Map<String,String> headers;
	
	public MSPostHeaders() {
		this.headers = new  HashMap<>();
	}
	
	public MSPostHeaders(MSPostHeader header) {
		this.headers = new  HashMap<>();
		this.headers.put(header.getKey(), header.getValue());
	}
	
	public MSPostHeaders(MSPostHeader... headers) {
		this.headers = new  HashMap<>();
		for(MSPostHeader header: headers) {
		this.headers.put(header.getKey(), header.getValue());
		}
	}
	
	public MSPostHeaders(String key, String value) {
		this.headers = new  HashMap<>();
		this.headers.put(key, value);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return headers.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return headers.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return headers.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return headers.containsValue(value);
	}

	@Override
	public String get(Object key) {
		// TODO Auto-generated method stub
		return headers.get(key);
	}

	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return headers.put(key, value);
	}

	@Override
	public String remove(Object key) {
		// TODO Auto-generated method stub
		return headers.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		// TODO Auto-generated method stub
		headers.putAll(m);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		headers.clear();
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return headers.keySet();
	}

	@Override
	public Collection<String> values() {
		// TODO Auto-generated method stub
		return headers.values();
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		// TODO Auto-generated method stub
		return headers.entrySet();
	}
	

}
