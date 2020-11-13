package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_group database table.
 * 
 */
@Entity
@Table(name="swd_group")
@NamedQuery(name="SwdGroup.findAll", query="SELECT s FROM SwdGroup s")
public class SwdGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	private String stat;

	//uni-directional many-to-one association to SwdEmployee
	@ManyToOne
	@JoinColumn(name="OWNER",updatable=false,insertable=false)
	private SwdEmployee owner;

	public SwdGroup() {
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

	public String getStat() {
		return this.stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public SwdEmployee getOwner() {
		return this.owner;
	}

	public void setOwner(SwdEmployee owner) {
		this.owner = owner;
	}

}