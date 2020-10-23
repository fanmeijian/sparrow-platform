package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_unit_role database table.
 * 
 */
@Entity
@Table(name="swd_unit_role")
@NamedQuery(name="SwdUnitRole.findAll", query="SELECT s FROM SwdUnitRole s")
public class SwdUnitRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUnitRolePK id;

	private int type;

	//uni-directional many-to-one association to SwdEmployee
	@ManyToOne
	@JoinColumn(name="USERNAME",insertable = false,updatable = false)
	private SwdEmployee swdEmployee;

	//uni-directional many-to-one association to SwdRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID",insertable = false,updatable = false)
	private SwdRole swdRole;

	//uni-directional many-to-one association to SwdUnit
	@ManyToOne
	@JoinColumn(name="UNIT_ID",insertable = false,updatable = false)
	private SwdUnit swdUnit;

	public SwdUnitRole() {
	}

	public SwdUnitRolePK getId() {
		return this.id;
	}

	public void setId(SwdUnitRolePK id) {
		this.id = id;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public SwdEmployee getSwdEmployee() {
		return this.swdEmployee;
	}

	public void setSwdEmployee(SwdEmployee swdEmployee) {
		this.swdEmployee = swdEmployee;
	}

	public SwdRole getSwdRole() {
		return this.swdRole;
	}

	public void setSwdRole(SwdRole swdRole) {
		this.swdRole = swdRole;
	}

	public SwdUnit getSwdUnit() {
		return this.swdUnit;
	}

	public void setSwdUnit(SwdUnit swdUnit) {
		this.swdUnit = swdUnit;
	}

}