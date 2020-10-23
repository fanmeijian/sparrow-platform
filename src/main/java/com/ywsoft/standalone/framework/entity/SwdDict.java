package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_dict database table.
 * 
 */
@Entity
@Table(name="swd_dict")
@NamedQuery(name="SwdDict.findAll", query="SELECT s FROM SwdDict s")
public class SwdDict implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String code;

	private String name;

	//uni-directional many-to-one association to SwdApp
	@ManyToOne
	@JoinColumn(name="APP_ID",insertable = false,updatable = false)
	private SwdApp swdApp;

	//uni-directional many-to-one association to SwdDict
	@ManyToOne
	@JoinColumn(name="PARENT_ID",insertable = false,updatable = false)
	private SwdDict swdDict;

	public SwdDict() {
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

	public SwdApp getSwdApp() {
		return this.swdApp;
	}

	public void setSwdApp(SwdApp swdApp) {
		this.swdApp = swdApp;
	}

	public SwdDict getSwdDict() {
		return this.swdDict;
	}

	public void setSwdDict(SwdDict swdDict) {
		this.swdDict = swdDict;
	}

}