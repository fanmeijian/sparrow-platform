package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_organization_relation database table.
 * 
 */
@Entity
@Table(name="swd_organization_relation")
@NamedQuery(name="SwdOrganizationRelation.findAll", query="SELECT s FROM SwdOrganizationRelation s")
public class SwdOrganizationRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdOrganizationRelationPK id;

	private int relation;

	public SwdOrganizationRelation() {
	}

	public SwdOrganizationRelationPK getId() {
		return this.id;
	}

	public void setId(SwdOrganizationRelationPK id) {
		this.id = id;
	}

	public int getRelation() {
		return this.relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}

}