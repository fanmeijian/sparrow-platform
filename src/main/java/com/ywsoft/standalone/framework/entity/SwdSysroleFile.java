package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sysrole_file database table.
 * 
 */
@Entity
@Table(name="swd_sysrole_file")
@NamedQuery(name="SwdSysroleFile.findAll", query="SELECT s FROM SwdSysroleFile s")
public class SwdSysroleFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSysroleFilePK id;

	public SwdSysroleFile() {
	}

	public SwdSysroleFilePK getId() {
		return this.id;
	}

	public void setId(SwdSysroleFilePK id) {
		this.id = id;
	}

}