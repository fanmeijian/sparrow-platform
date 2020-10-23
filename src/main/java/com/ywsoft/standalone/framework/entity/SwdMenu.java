package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the swd_menu database table.
 * 
 */
@Entity
@Table(name="swd_menu")
@NamedQuery(name="SwdMenu.findAll", query="SELECT s FROM SwdMenu s")
public class SwdMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	@Column(name="PARENT_ID")
	private BigInteger parentId;

	private BigInteger sort;

	private String url;

	public SwdMenu() {
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

	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public BigInteger getSort() {
		return this.sort;
	}

	public void setSort(BigInteger sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}