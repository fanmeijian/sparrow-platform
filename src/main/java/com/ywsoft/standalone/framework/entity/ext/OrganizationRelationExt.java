package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdOrganization;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;

public class OrganizationRelationExt{
	private OrganizationExt organizationExt;
	private OrganizationExt targetExt;
	private int relation;
	
	public OrganizationRelationExt(SwdOrganization organization, SwdOrganization target, int relation) {
		this.organizationExt = new OrganizationExt(organization);
		this.targetExt = new OrganizationExt(target);
		this.relation = relation;
	}

	public OrganizationExt getOrganizationExt() {
		return organizationExt;
	}

	public void setOrganizationExt(OrganizationExt organizationExt) {
		this.organizationExt = organizationExt;
	}

	public OrganizationExt getTargetExt() {
		return targetExt;
	}

	public void setTargetExt(OrganizationExt targetExt) {
		this.targetExt = targetExt;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}
	
}
