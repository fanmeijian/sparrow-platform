package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_sysrole database table.
 * 
 */
@Entity
@Table(name="swd_user_sysrole")
@NamedQuery(name="SwdUserSysrole.findAll", query="SELECT s FROM SwdUserSysrole s")
public class SwdUserSysrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserSysrolePK id;

	public SwdUserSysrole() {
	}

	public SwdUserSysrolePK getId() {
		return this.id;
	}

	public void setId(SwdUserSysrolePK id) {
		this.id = id;
	}

}