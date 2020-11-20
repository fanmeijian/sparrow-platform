package com.ywsoft.standalone.framework.service;

public final class ApiResponseFactory {
	public static ApiResponse getErrorReponse() {
		return new ApiResponseError();
	}
	
	public static ApiResponse getNormalReponse() {
		return new ApiResponseNormal();
	}
	
	public static ApiResponse getNormalReponse(Object data) {
		return new ApiResponseNormal(data);
	}

	public static ApiResponse getErrorReponse(String code) {
		ApiResponse o = new ApiResponseError();
		o.setCode(code);
		return o;
	}
}
