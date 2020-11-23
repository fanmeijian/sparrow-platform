package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the swd_role database table.
 * 
 */
@Entity
@Table(name = "swd_role")
@NamedQuery(name = "SwdRole.findAll", query = "SELECT s FROM SwdRole s")
public class SwdRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String code;

	private String name;

	private int stat;

	// uni-directional many-to-one association to SwdOrganization
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private SwdOrganization swdOrganization;

	public SwdRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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