package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sysrole_authority database table.
 * 
 */
@Entity
@Table(name="swd_sysrole_authority")
@NamedQuery(name="SwdSysroleAuthority.findAll", query="SELECT s FROM SwdSysroleAuthority s")
public class SwdSysroleAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSysroleAuthorityPK id;

	public SwdSysroleAuthority() {
	}

	public SwdSysroleAuthorityPK getId() {
		return this.id;
	}

	public void setId(SwdSysroleAuthorityPK id) {
		this.id = id;
	}

}