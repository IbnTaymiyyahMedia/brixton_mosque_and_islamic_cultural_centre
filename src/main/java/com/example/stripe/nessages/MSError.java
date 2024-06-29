package com.example.stripe.nessages;

public class MSError {

	private Integer code;
	private String title;
	private String message;
	private  MSErrorData error_data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MSErrorData getError_data() {
		return error_data;
	}
	public void setError_data(MSErrorData error_data) {
		this.error_data = error_data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
