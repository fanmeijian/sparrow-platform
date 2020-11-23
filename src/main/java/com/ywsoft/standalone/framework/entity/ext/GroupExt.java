package com.ywsoft.standalone.framework.entity.ext;

import java.util.ArrayList;
import java.util.List;

import com.ywsoft.standalone.framework.entity.SwdGroup;

public class GroupExt extends SwdGroup {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GroupExt> subGroups;
	
	public GroupExt(SwdGroup group) {
		this.setId(group.getId());
		this.setName(group.getName());
//		this.setOwner(group.getOwner());
		this.setStat(group.getStat());
		subGroups = new ArrayList<GroupExt>();
	}

	public List<GroupExt> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<GroupExt> subGroups) {
		this.subGroups = subGroups;
	}

}
