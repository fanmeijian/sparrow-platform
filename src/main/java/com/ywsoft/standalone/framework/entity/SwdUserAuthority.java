package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_authority database table.
 * 
 */
@Entity
@Table(name="swd_user_authority")
@NamedQuery(name="SwdUserAuthority.findAll", query="SELECT s FROM SwdUserAuthority s")
public class SwdUserAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserAuthorityPK id;

	public SwdUserAuthority() {
	}

	public SwdUserAuthorityPK getId() {
		return this.id;
	}

	public void setId(SwdUserAuthorityPK id) {
		this.id = id;
	}

}