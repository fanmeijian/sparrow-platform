package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_unit_level database table.
 * 
 */
@Entity
@Table(name="swd_unit_level")
@NamedQuery(name="SwdUnitLevel.findAll", query="SELECT s FROM SwdUnitLevel s")
public class SwdUnitLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUnitLevelPK id;

	//uni-directional many-to-one association to SwdEmployee
	@ManyToOne
	@JoinColumn(name="USERNAME",insertable = false,updatable = false)
	private SwdEmployee swdEmployee;

	//uni-directional many-to-one association to SwdLevel
	@ManyToOne
	@JoinColumn(name="LEVEL_ID",insertable = false,updatable = false)
	private SwdLevel swdLevel;

	//uni-directional many-to-one association to SwdUnit
	@ManyToOne
	@JoinColumn(name="UNIT_ID",insertable = false,updatable = false)
	private SwdUnit swdUnit;

	public SwdUnitLevel() {
	}

	public SwdUnitLevelPK getId() {
		return this.id;
	}

	public void setId(SwdUnitLevelPK id) {
		this.id = id;
	}

	public SwdEmployee getSwdEmployee() {
		return this.swdEmployee;
	}

	public void setSwdEmployee(SwdEmployee swdEmployee) {
		this.swdEmployee = swdEmployee;
	}

	public SwdLevel getSwdLevel() {
		return this.swdLevel;
	}

	public void setSwdLevel(SwdLevel swdLevel) {
		this.swdLevel = swdLevel;
	}

	public SwdUnit getSwdUnit() {
		return this.swdUnit;
	}

	public void setSwdUnit(SwdUnit swdUnit) {
		this.swdUnit = swdUnit;
	}

}