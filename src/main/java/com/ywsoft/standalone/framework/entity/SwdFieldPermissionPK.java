package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_field_permission database table.
 * 
 */
@Embeddable
public class SwdFieldPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String model;

	private String field;

	private String permission;

	public SwdFieldPermissionPK() {
	}
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getField() {
		return this.field;
	}
	public void setField(String field) {
		this.field = field;
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
		if (!(other instanceof SwdFieldPermissionPK)) {
			return false;
		}
		SwdFieldPermissionPK castOther = (SwdFieldPermissionPK)other;
		return 
			this.model.equals(castOther.model)
			&& this.field.equals(castOther.field)
			&& this.permission.equals(castOther.permission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.model.hashCode();
		hash = hash * prime + this.field.hashCode();
		hash = hash * prime + this.permission.hashCode();
		
		return hash;
	}
}