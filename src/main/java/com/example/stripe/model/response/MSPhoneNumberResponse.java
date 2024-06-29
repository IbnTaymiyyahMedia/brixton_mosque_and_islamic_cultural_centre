package com.example.stripe.model.response;

import java.util.List;
import java.util.Map;

public class MSPhoneNumberResponse {

	private List<Map<PHONE_NUMBER, Object>> data;
	private Map<PHONE_NUMBER, Object> paging;
	private enum PHONE_NUMBER {verified_name, code_verification_status, display_phone_number, quality_rating, platform_type, throughput, level, webhook_configuration, id, application, cursors, before, after};

	public List<Map<PHONE_NUMBER, Object>> getData() {
		return data;
	}

	public void setData(List<Map<PHONE_NUMBER, Object>> data) {
		this.data = data;
	}

	public Map<PHONE_NUMBER, Object> getPaging() {
		return paging;
	}

	public void setPaging(Map<PHONE_NUMBER, Object> paging) {
		this.paging = paging;
	}
}
