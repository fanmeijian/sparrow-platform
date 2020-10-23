package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_employee database table.
 * 
 */
@Entity
@Table(name="swd_employee")
@NamedQuery(name="SwdEmployee.findAll", query="SELECT s FROM SwdEmployee s")
public class SwdEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;

	private String employeeno;

	private String stat;

	@Column(name="UPLINE_MANAGER")
	private String uplineManager;

	//uni-directional many-to-one association to SwdUnit
	@ManyToOne
	@JoinColumn(name="UNIT_ID")
	private SwdUnit swdUnit;

	public SwdEmployee() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmployeeno() {
		return this.employeeno;
	}

	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}

	public String getStat() {
		return this.stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getUplineManager() {
		return this.uplineManager;
	}

	public void setUplineManager(String uplineManager) {
		this.uplineManager = uplineManager;
	}

	public SwdUnit getSwdUnit() {
		return this.swdUnit;
	}

	public void setSwdUnit(SwdUnit swdUnit) {
		this.swdUnit = swdUnit;
	}

}