package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_data_permission database table.
 * 
 */
@Entity
@Table(name="swd_user_data_permission")
@NamedQuery(name="SwdUserDataPermission.findAll", query="SELECT s FROM SwdUserDataPermission s")
public class SwdUserDataPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserDataPermissionPK id;

	public SwdUserDataPermission() {
	}

	public SwdUserDataPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdUserDataPermissionPK id) {
		this.id = id;
	}

}