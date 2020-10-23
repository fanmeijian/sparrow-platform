package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sysrole_file database table.
 * 
 */
@Embeddable
public class SwdSysroleFilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	@Column(name="FILE_ID", insertable=false, updatable=false)
	private String fileId;

	private String permission;

	public SwdSysroleFilePK() {
	}
	public String getSysroleId() {
		return this.sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
	}
	public String getFileId() {
		return this.fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdSysroleFilePK)) {
			return false;
		}
		SwdSysroleFilePK castOther = (SwdSysroleFilePK)other;
		return 
			this.sysroleId.equals(castOther.sysroleId)
			&& this.fileId.equals(castOther.fileId)
			&& this.permission.equals(castOther.permission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sysroleId.hashCode();
		hash = hash * prime + this.fileId.hashCode();
		hash = hash * prime + this.permission.hashCode();
		
		return hash;
	}
}