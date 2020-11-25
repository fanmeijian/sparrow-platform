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
	 * {@code 1003 两次输入密码不一致}.
	 */
	public static ApiResponse SECOND_PASSWORD_NOT_MATCH = new ApiResponseError("1003","两次输入密码不一致");
	
	/**
	 * 
	 * {@code 1004 旧密码输入不一致}.
	 */
	public static ApiResponse OLD_PASSWORD_NOT_MATCH = new ApiResponseError("1004","旧密码不一致");
	
	/**
	 * 
	 * {@code 1005 组织不存在}.
	 */
	public static ApiResponse ORGANIZATION_NOT_FOUND = new ApiResponseError("1005","组织不存在");
	
	/**
	 * 
	 * {@code 1010 组织不存在}.
	 */
	public static ApiResponse DATA_NOT_FOUND = new ApiResponseError("1010","数据不存在");
}
