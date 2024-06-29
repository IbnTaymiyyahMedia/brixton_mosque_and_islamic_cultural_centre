package com.example.stripe.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MESSAGE_MODEL implements Map<com.example.stripe.service.MESSAGE_MODEL.KEY,Object> {

	private final Map<KEY,Object> map = new HashMap<>();
	
	public Map<String,Object> toMap(){
		return toMap(map);
	}
	
	private Map<String,Object> toMap(Map<KEY,Object> entries) {
		Map<String,Object> map = new HashMap<>();
		Set<KEY> keys = entries.keySet();
		for(KEY key: keys) {
			Object obj = entries.get(key);
			if(obj instanceof HashMap) {
				Map<String,Object> entry = toMap((Map<KEY, Object>) obj);
				map.put(key.name(), entry);
			} else if (obj instanceof ArrayList) {
				List<Object> items = new ArrayList<>();
				List<Object> list = (List) obj;
				for (Object item: list) {
					if(obj instanceof HashMap) {
						Map<String,Object> entry = toMap((Map<KEY, Object>) item);
						items.add(entry);
					} else {
						items.add(item);
					}
				}
				map.put(key.name(), items);
			} else {
				map.put(key.name(), obj);
			}
		}
		return map;
	}
	
	public void setContext(String messageId) {
		Map<KEY,Object> context = new HashMap<>() {
			{
				put(KEY.message_id, messageId);
			}
		};
		put(KEY.context, context);
	}
	
	public enum KEY {contacts,urls,phones,org,name,birthday,addresses,type,url,country_code,country,zip,street,state,city,prefix,suffix,middle_name,first_name,last_name,formatted_name,phone,company,title,department, to, context, message_id, messaging_product, recipient_type, location, address, longitude, latitude, template, language, components, code, parameters, text, currency, amount_1000, fallback_value, day_of_week, year, month, day_of_month, minute, hour, calendar, date_time, image, link, interactive, header, body, footer, action, button, sections, description, id, rows, buttons, reply, status, catalog_id, product_retailer_id, product_items, thumbnail_product_retailer_id, sub_type, index, code_method, locale, pin, override_callback_uri, verify_token, reference_id, payment_type, payment_configuration, total_amount, order, value, offset, provider, retailer_id, amount, quantity, sale_amount, items, subtotal, tax, shipping, discount, discount_program_name, expiration, timestamp, order_details, vertical, about, email, websites, profile_picture_handle, cc, phone_number, verified_name}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}

	@Override
	public Object put(KEY key, Object value) {
		// TODO Auto-generated method stub
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends KEY, ? extends Object> m) {
		// TODO Auto-generated method stub
		map.putAll(m);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}

	@Override
	public Set<KEY> keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return map.values();
	}

	@Override
	public Set<Entry<KEY, Object>> entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	};
	
}
