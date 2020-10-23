package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sysrole_field_permission database table.
 * 
 */
@Embeddable
public class SwdSysroleFieldPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String field;

	@Column(insertable=false, updatable=false)
	private String model;

	private String permission;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	public SwdSysroleFieldPermissionPK() {
	}
	public String getField() {
		return this.field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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
		if (!(other instanceof SwdSysroleFieldPermissionPK)) {
			return false;
		}
		SwdSysroleFieldPermissionPK castOther = (SwdSysroleFieldPermissionPK)other;
		return 
			this.field.equals(castOther.field)
			&& this.model.equals(castOther.model)
			&& this.permission.equals(castOther.permission)
			&& this.sysroleId.equals(castOther.sysroleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.field.hashCode();
		hash = hash * prime + this.model.hashCode();
		hash = hash * prime + this.permission.hashCode();
		hash = hash * prime + this.sysroleId.hashCode();
		
		return hash;
	}
}