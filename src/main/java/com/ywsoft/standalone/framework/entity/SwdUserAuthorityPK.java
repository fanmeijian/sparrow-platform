package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_user_authority database table.
 * 
 */
@Embeddable
public class SwdUserAuthorityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(name="AUTHORITY_ID", insertable=false, updatable=false)
	private String authorityId;

	public SwdUserAuthorityPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		if (!(other instanceof SwdUserAuthorityPK)) {
			return false;
		}
		SwdUserAuthorityPK castOther = (SwdUserAuthorityPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.authorityId.equals(castOther.authorityId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.authorityId.hashCode();
		
		return hash;
	}
}