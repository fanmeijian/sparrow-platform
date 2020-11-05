package com.ywsoft.standalone.framework.entity.ext;

import java.util.List;

import com.ywsoft.standalone.framework.entity.SwdGroup;
import com.ywsoft.standalone.framework.entity.SwdUser;

public class GroupMember extends SwdGroup{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<SwdGroup> subGroups;
	List<SwdUser> groupUser;
	
	public GroupMember(List<SwdGroup> subGroups, List<SwdUser> groupUser){
		this.subGroups = subGroups;
		this.groupUser = groupUser;
	}

	public List<SwdGroup> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<SwdGroup> subGroups) {
		this.subGroups = subGroups;
	}

	public List<SwdUser> getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(List<SwdUser> groupUser) {
		this.groupUser = groupUser;
	}
	
	
}
