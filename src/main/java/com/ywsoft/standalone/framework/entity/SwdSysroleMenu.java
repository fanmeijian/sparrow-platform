package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sysrole_menu database table.
 * 
 */
@Entity
@Table(name="swd_sysrole_menu")
@NamedQuery(name="SwdSysroleMenu.findAll", query="SELECT s FROM SwdSysroleMenu s")
public class SwdSysroleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSysroleMenuPK id;

	public SwdSysroleMenu() {
	}

	public SwdSysroleMenuPK getId() {
		return this.id;
	}

	public void setId(SwdSysroleMenuPK id) {
		this.id = id;
	}

}