package com.ywsoft.standalone.framework.entity.ext;

import java.util.ArrayList;
import java.util.List;

import com.ywsoft.standalone.framework.entity.SwdGroup;
import com.ywsoft.standalone.framework.entity.SwdUser;

public class GroupExt extends SwdGroup {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GroupExt> subGroups;
	private List<SwdUser> groupUsers;
	
	public GroupExt(SwdGroup group) {
		this.setId(group.getId());
		this.setName(group.getName());
//		this.setOwner(group.getOwner());
		this.setStat(group.getStat());
		subGroups = new ArrayList<GroupExt>();
		groupUsers = new ArrayList<SwdUser>();
	}

	public List<GroupExt> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<GroupExt> subGroups) {
		this.subGroups = subGroups;
	}

	public List<SwdUser> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<SwdUser> groupUsers) {
		this.groupUsers = groupUsers;
	}
	
	

}
