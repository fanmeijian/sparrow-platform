package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_user_file database table.
 * 
 */
@Entity
@Table(name="swd_user_file")
@NamedQuery(name="SwdUserFile.findAll", query="SELECT s FROM SwdUserFile s")
public class SwdUserFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdUserFilePK id;

	public SwdUserFile() {
	}

	public SwdUserFilePK getId() {
		return this.id;
	}

	public void setId(SwdUserFilePK id) {
		this.id = id;
	}

}