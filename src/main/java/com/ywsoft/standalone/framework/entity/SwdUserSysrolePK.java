package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_user_sysrole database table.
 * 
 */
@Embeddable
public class SwdUserSysrolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	public SwdUserSysrolePK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSysroleId() {
		return this.sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdUserSysrolePK)) {
			return false;
		}
		SwdUserSysrolePK castOther = (SwdUserSysrolePK)other;
		return 
			this.username.equals(castOther.username)
			&& this.sysroleId.equals(castOther.sysroleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.sysroleId.hashCode();
		
		return hash;
	}
}