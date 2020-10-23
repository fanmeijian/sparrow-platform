package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sysrole_field_permission database table.
 * 
 */
@Entity
@Table(name="swd_sysrole_field_permission")
@NamedQuery(name="SwdSysroleFieldPermission.findAll", query="SELECT s FROM SwdSysroleFieldPermission s")
public class SwdSysroleFieldPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSysroleFieldPermissionPK id;

	@Column(name="PERMISSION_EL")
	private String permissionEl;

	public SwdSysroleFieldPermission() {
	}

	public SwdSysroleFieldPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdSysroleFieldPermissionPK id) {
		this.id = id;
	}

	public String getPermissionEl() {
		return this.permissionEl;
	}

	public void setPermissionEl(String permissionEl) {
		this.permissionEl = permissionEl;
	}

}