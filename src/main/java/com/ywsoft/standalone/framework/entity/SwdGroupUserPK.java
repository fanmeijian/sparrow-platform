package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_group_user database table.
 * 
 */
@Embeddable
public class SwdGroupUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GROUP_ID", insertable=false, updatable=false)
	private String groupId;

	@Column(insertable=false, updatable=false)
	private String username;

	public SwdGroupUserPK() {
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdGroupUserPK)) {
			return false;
		}
		SwdGroupUserPK castOther = (SwdGroupUserPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}