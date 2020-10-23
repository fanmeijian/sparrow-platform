package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdSysroleFilePK;

public class SysroleFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SysroleFile(SwdSysroleFilePK swdSysroleFilePK, String sysroleName) {
		this.id = swdSysroleFilePK;
		this.sysroleName = sysroleName;
	}

	private SwdSysroleFilePK id;
	private String sysroleName;

	public SwdSysroleFilePK getId() {
		return id;
	}

	public void setId(SwdSysroleFilePK id) {
		this.id = id;
	}

	public String getSysroleName() {
		return sysroleName;
	}

	public void setSysroleName(String sysroleName) {
		this.sysroleName = sysroleName;
	}
	
	

}
