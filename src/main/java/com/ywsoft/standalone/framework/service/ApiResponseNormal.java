package com.ywsoft.standalone.framework.service;

import javax.annotation.ManagedBean;

@ManagedBean
public class ApiResponseNormal extends ApiResponse {
	public ApiResponseNormal(Object data) {
		this.setType("successful");
		this.setCode("200");
		this.setMessage("成功");
		this.setData(data);
	}
	public ApiResponseNormal() {
		this.setType("successful");
		this.setCode("200");
		this.setMessage("成功");
	}
}
