package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sysrole_authority database table.
 * 
 */
@Embeddable
public class SwdSysroleAuthorityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	@Column(name="AUTHORITY_ID", insertable=false, updatable=false)
	private String authorityId;

	public SwdSysroleAuthorityPK() {
	}
	public String getSysroleId() {
		return this.sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
	}
	public String getAuthorityId() {
		return this.authorityId;
	}
	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdSysroleAuthorityPK)) {
			return false;
		}
		SwdSysroleAuthorityPK castOther = (SwdSysroleAuthorityPK)other;
		return 
			this.sysroleId.equals(castOther.sysroleId)
			&& this.authorityId.equals(castOther.authorityId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sysroleId.hashCode();
		hash = hash * prime + this.authorityId.hashCode();
		
		return hash;
	}
}