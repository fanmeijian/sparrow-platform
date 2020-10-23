package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_unit_role database table.
 * 
 */
@Embeddable
public class SwdUnitRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROLE_ID", insertable=false, updatable=false)
	private String roleId;

	@Column(name="UNIT_ID", insertable=false, updatable=false)
	private String unitId;

	@Column(insertable=false, updatable=false)
	private String username;

	public SwdUnitRolePK() {
	}
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUnitId() {
		return this.unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
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
		if (!(other instanceof SwdUnitRolePK)) {
			return false;
		}
		SwdUnitRolePK castOther = (SwdUnitRolePK)other;
		return 
			this.roleId.equals(castOther.roleId)
			&& this.unitId.equals(castOther.unitId)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId.hashCode();
		hash = hash * prime + this.unitId.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}