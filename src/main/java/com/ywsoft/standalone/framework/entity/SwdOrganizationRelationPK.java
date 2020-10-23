package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_organization_relation database table.
 * 
 */
@Embeddable
public class SwdOrganizationRelationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORGANIZATION_ID", insertable=false, updatable=false)
	private String organizationId;

	@Column(name="TARTGET_ID", insertable=false, updatable=false)
	private String tartgetId;

	public SwdOrganizationRelationPK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getTartgetId() {
		return this.tartgetId;
	}
	public void setTartgetId(String tartgetId) {
		this.tartgetId = tartgetId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdOrganizationRelationPK)) {
			return false;
		}
		SwdOrganizationRelationPK castOther = (SwdOrganizationRelationPK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& this.tartgetId.equals(castOther.tartgetId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.tartgetId.hashCode();
		
		return hash;
	}
}