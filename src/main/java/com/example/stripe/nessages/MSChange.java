package com.example.stripe.nessages;

public class MSChange {
	private MSValue value;
	private String field;
	
	
	public MSValue getValue() {
		return value;
	}

	public void setValue(MSValue value) {
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
