package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_user_data_permission database table.
 * 
 */
@Embeddable
public class SwdUserDataPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(insertable=false, updatable=false)
	private String permission;

	@Column(insertable=false, updatable=false)
	private String pkey;

	@Column(insertable=false, updatable=false)
	private String model;

	public SwdUserDataPermissionPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPkey() {
		return this.pkey;
	}
	public void setPkey(String pkey) {
		this.pkey = pkey;
	}
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdUserDataPermissionPK)) {
			return false;
		}
		SwdUserDataPermissionPK castOther = (SwdUserDataPermissionPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.permission.equals(castOther.permission)
			&& this.pkey.equals(castOther.pkey)
			&& this.model.equals(castOther.model);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.permission.hashCode();
		hash = hash * prime + this.pkey.hashCode();
		hash = hash * prime + this.model.hashCode();
		
		return hash;
	}
}