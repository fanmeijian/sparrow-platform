package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdUser;

public class UserExt extends SwdUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oldPassword;
	private String secondPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}
	
	
}
