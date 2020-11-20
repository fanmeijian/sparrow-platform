package com.ywsoft.standalone.framework.service;

import javax.annotation.ManagedBean;

@ManagedBean
public class ApiResponseError extends ApiResponse{
	public ApiResponseError(String code, String message) {
		this.setType("error");
		this.setCode(code);
		this.setMessage(message);
	}
	
	public ApiResponseError() {
		this.setType("error");
	}
}
