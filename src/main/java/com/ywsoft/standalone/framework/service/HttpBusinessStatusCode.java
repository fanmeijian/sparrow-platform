package com.ywsoft.standalone.framework.service;

public final class HttpBusinessStatusCode {
	
	
	/**
	 * 
	 * {@code 1001 用户不存在}.
	 */
	public static ApiResponse USER_NOT_FOUND = new ApiResponseError("1001","用户不存在");
	
	/**
	 * 
	 * {@code 1002 密码错误}.
	 */
	public static ApiResponse PASSWORD_NOT_MATCH = new ApiResponseError("1002","密码错误");
	
	/**
	 * 
	 * {@code 1003 组织不存在}.
	 */
	public static ApiResponse ORGANIZATION_NOT_FOUND = new ApiResponseError("1003","组织不存在");
	
}
