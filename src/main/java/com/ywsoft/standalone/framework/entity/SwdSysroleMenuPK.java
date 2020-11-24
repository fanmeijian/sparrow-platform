package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_sysrole_menu database table.
 * 
 */
@Embeddable
public class SwdSysroleMenuPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYSROLE_ID", insertable=false, updatable=false)
	private String sysroleId;

	@Column(name="MENU_ID", insertable=false, updatable=false)
	private String menuId;

	public SwdSysroleMenuPK() {
	}
	public String getSysroleId() {
		return this.sysroleId;
	}
	public void setSysroleId(String sysroleId) {
		this.sysroleId = sysroleId;
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
		if (!(other instanceof SwdSysroleMenuPK)) {
			return false;
		}
		SwdSysroleMenuPK castOther = (SwdSysroleMenuPK)other;
		return 
			this.sysroleId.equals(castOther.sysroleId)
			&& this.menuId.equals(castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sysroleId.hashCode();
		hash = hash * prime + this.menuId.hashCode();
		
		return hash;
	}
}