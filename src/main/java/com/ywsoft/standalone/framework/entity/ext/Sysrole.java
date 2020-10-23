package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdSysrole;

/***
 * 用来显示用户已用于的角色，做复选框用。
 * @author sword
 *
 */
public class Sysrole extends SwdSysrole {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean checked = false;

	public Sysrole(SwdSysrole o) {
		this.setName(o.getName());
		this.setId(o.getId());
		this.setSwdAuthorities(o.getSwdAuthorities());
		this.setSwdMenus(o.getSwdMenus());
		this.setSwdAuthorities(o.getSwdAuthorities());
		this.checked=false;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
