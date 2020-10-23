package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_unit database table.
 * 
 */
@Entity
@Table(name="swd_unit")
@NamedQuery(name="SwdUnit.findAll", query="SELECT s FROM SwdUnit s")
public class SwdUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	@Column(name="PARENT_ID")
	private java.math.BigInteger parentId;

	private int stat;

	//uni-directional many-to-one association to SwdOrganization
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID")
	private SwdOrganization swdOrganization;

	public SwdUnit() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.math.BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(java.math.BigInteger parentId) {
		this.parentId = parentId;
	}

	public int getStat() {
		return this.stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public SwdOrganization getSwdOrganization() {
		return this.swdOrganization;
	}

	public void setSwdOrganization(SwdOrganization swdOrganization) {
		this.swdOrganization = swdOrganization;
	}

}