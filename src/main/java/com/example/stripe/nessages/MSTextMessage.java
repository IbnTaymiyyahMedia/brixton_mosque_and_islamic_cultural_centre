package com.example.stripe.nessages;

import java.util.List;

public class MSTextMessage {

	private String object;
	private List<MSEntry> entry;
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public List<MSEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<MSEntry> entry) {
		this.entry = entry;
	}
}
