package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdAuthority;

public class Authority extends SwdAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean checked = false;

	public Authority(SwdAuthority o) {
		this.checked=false;
		this.setId(o.getId());
		this.setAuthority(o.getAuthority());
		this.setUri(o.getUri());
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
