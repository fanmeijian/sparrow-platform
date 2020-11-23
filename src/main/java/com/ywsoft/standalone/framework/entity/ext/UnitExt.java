package com.ywsoft.standalone.framework.entity.ext;

import java.util.ArrayList;
import java.util.List;

import com.ywsoft.standalone.framework.entity.SwdUnit;

public class UnitExt extends SwdUnit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UnitExt> children;
	
	public UnitExt(SwdUnit unit) {
		this.setId(unit.getId());
		this.setName(unit.getName());
		this.setParentId(unit.getParentId());
		this.setStat(unit.getStat());
		this.setSwdOrganization(unit.getSwdOrganization());
		this.children = new ArrayList<UnitExt>();
	}

	public List<UnitExt> getChildren() {
		return children;
	}
	public void setChildren(List<UnitExt> children) {
		this.children = children;
	}
	
	
	

}
