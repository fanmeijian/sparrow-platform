package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_menu database table.
 * 
 */
@Entity
@Table(name="swd_user_menu")
@NamedQuery(name="SwdUserMenu.findAll", query="SELECT s FROM SwdUserMenu s")
public class SwdUserMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserMenuPK id;

	public SwdUserMenu() {
	}

	public SwdUserMenuPK getId() {
		return this.id;
	}

	public void setId(SwdUserMenuPK id) {
		this.id = id;
	}

}