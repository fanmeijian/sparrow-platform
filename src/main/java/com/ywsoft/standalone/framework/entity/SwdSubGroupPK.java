package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sub_group database table.
 * 
 */
@Embeddable
public class SwdSubGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GROUP_ID", insertable=false, updatable=false)
	private String groupId;

	@Column(name="SUB_GROUP_ID", insertable=false, updatable=false)
	private String subGroupId;

	public SwdSubGroupPK() {
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSubGroupId() {
		return this.subGroupId;
	}
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdSubGroupPK)) {
			return false;
		}
		SwdSubGroupPK castOther = (SwdSubGroupPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.subGroupId.equals(castOther.subGroupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.subGroupId.hashCode();
		
		return hash;
	}
}