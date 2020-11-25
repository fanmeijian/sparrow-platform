package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sysrole_data_permission database table.
 * 
 */
@Embeddable
public class SwdSysroleDataPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	@Column(insertable=false, updatable=false)
	private String permission;

	@Column(insertable=false, updatable=false)
	private String model;

	@Column(insertable=false, updatable=false)
	private String pkey;

	public SwdSysroleDataPermissionPK() {
	}
	public String getSysroleId() {
		return this.sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPkey() {
		return this.pkey;
	}
	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdSysroleDataPermissionPK)) {
			return false;
		}
		SwdSysroleDataPermissionPK castOther = (SwdSysroleDataPermissionPK)other;
		return 
			this.sysroleId.equals(castOther.sysroleId)
			&& this.permission.equals(castOther.permission)
			&& this.model.equals(castOther.model)
			&& this.pkey.equals(castOther.pkey);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sysroleId.hashCode();
		hash = hash * prime + this.permission.hashCode();
		hash = hash * prime + this.model.hashCode();
		hash = hash * prime + this.pkey.hashCode();
		
		return hash;
	}
}