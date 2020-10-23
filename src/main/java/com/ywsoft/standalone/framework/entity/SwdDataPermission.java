package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_data_permission database table.
 * 
 */
@Entity
@Table(name="swd_data_permission")
@NamedQuery(name="SwdDataPermission.findAll", query="SELECT s FROM SwdDataPermission s")
public class SwdDataPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdDataPermissionPK id;

	@Column(name="PERMISSION_EL")
	private String permissionEl;

	public SwdDataPermission() {
	}

	public SwdDataPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdDataPermissionPK id) {
		this.id = id;
	}

	public String getPermissionEl() {
		return this.permissionEl;
	}

	public void setPermissionEl(String permissionEl) {
		this.permissionEl = permissionEl;
	}

}