package com.example.stripe.nessages;

import java.util.List;

public class MSEntry {

	private String id;
	private List<MSChange> changes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<MSChange> getChanges() {
		return changes;
	}
	public void setChanges(List<MSChange> changes) {
		this.changes = changes;
	}
}
