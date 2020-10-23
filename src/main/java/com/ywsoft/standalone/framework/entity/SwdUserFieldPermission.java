package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_field_permission database table.
 * 
 */
@Entity
@Table(name="swd_user_field_permission")
@NamedQuery(name="SwdUserFieldPermission.findAll", query="SELECT s FROM SwdUserFieldPermission s")
public class SwdUserFieldPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserFieldPermissionPK id;

	@Column(name="PERMISSION_EL")
	private String permissionEl;

	public SwdUserFieldPermission() {
	}

	public SwdUserFieldPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdUserFieldPermissionPK id) {
		this.id = id;
	}

	public String getPermissionEl() {
		return this.permissionEl;
	}

	public void setPermissionEl(String permissionEl) {
		this.permissionEl = permissionEl;
	}

}