package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the swd_login_log database table.
 * 
 */
@Entity
@Table(name="swd_login_log")
@NamedQuery(name="SwdLoginLog.findAll", query="SELECT s FROM SwdLoginLog s")
public class SwdLoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String ip;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGIN_TIME",insertable = false,updatable = false)
	private Date loginTime;

	private String username;

	public SwdLoginLog() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}