package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_level database table.
 * 
 */
@Entity
@Table(name="swd_level")
@NamedQuery(name="SwdLevel.findAll", query="SELECT s FROM SwdLevel s")
public class SwdLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String code;

	private String name;

	private int stat;

	public SwdLevel() {
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

}