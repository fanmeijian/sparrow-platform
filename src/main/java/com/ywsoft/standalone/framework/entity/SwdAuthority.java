package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_authority database table.
 * 
 */
@Entity
@Table(name="swd_authority")
@NamedQuery(name="SwdAuthority.findAll", query="SELECT s FROM SwdAuthority s")
public class SwdAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String authority;

	private String uri;
	
	private String permission;
	
	private String method;
	
	private String clientId;

	public SwdAuthority() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	

}