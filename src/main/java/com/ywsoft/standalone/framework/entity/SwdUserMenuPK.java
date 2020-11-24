package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_user_menu database table.
 * 
 */
@Embeddable
public class SwdUserMenuPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(name="MENU_ID", insertable=false, updatable=false)
	private String menuId;

	public SwdUserMenuPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMenuId() {
		return this.menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdUserMenuPK)) {
			return false;
		}
		SwdUserMenuPK castOther = (SwdUserMenuPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.menuId.equals(castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.menuId.hashCode();
		
		return hash;
	}
}