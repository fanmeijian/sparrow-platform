package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sysrole_data_permission database table.
 * 
 */
@Entity
@Table(name="swd_sysrole_data_permission")
@NamedQuery(name="SwdSysroleDataPermission.findAll", query="SELECT s FROM SwdSysroleDataPermission s")
public class SwdSysroleDataPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSysroleDataPermissionPK id;

	public SwdSysroleDataPermission() {
	}

	public SwdSysroleDataPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdSysroleDataPermissionPK id) {
		this.id = id;
	}

}