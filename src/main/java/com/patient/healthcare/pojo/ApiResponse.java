package com.patient.healthcare.pojo;

public class ApiResponse {
	private Object data;
	private boolean isValid;
	
	public ApiResponse() {
		
	}
	
	
	public ApiResponse(Object data, boolean isValid) {
		super();
		this.data = data;
		this.isValid = isValid;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

}
