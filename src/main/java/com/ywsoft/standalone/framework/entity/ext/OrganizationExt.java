package com.ywsoft.standalone.framework.entity.ext;

import java.util.ArrayList;
import java.util.List;

import com.ywsoft.standalone.framework.entity.SwdOrganization;

public class OrganizationExt extends SwdOrganization {
	/**
	 * 
	 */
	public OrganizationExt(SwdOrganization swdOrganization) {
		this.setCode(swdOrganization.getCode());
		this.setId(swdOrganization.getId());
		this.setName(swdOrganization.getName());
		this.setStat(swdOrganization.getStat());
		this.sources = new ArrayList<OrganizationRelationExt>();
		this.targets = new ArrayList<OrganizationRelationExt>();	
	}
	private static final long serialVersionUID = 1L;
	List<OrganizationRelationExt> sources;//往上的列表
	List<OrganizationRelationExt> targets;//往下的列表
	public List<OrganizationRelationExt> getTargets() {
		return targets;
	}
	public void setTargets(List<OrganizationRelationExt> targets) {
		this.targets = targets;
	}
	public List<OrganizationRelationExt> getSources() {
		return sources;
	}
	public void setSources(List<OrganizationRelationExt> sources) {
		this.sources = sources;
	}
	
	
}
