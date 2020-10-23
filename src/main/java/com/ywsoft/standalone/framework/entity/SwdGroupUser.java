package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_group_user database table.
 * 
 */
@Entity
@Table(name="swd_group_user")
@NamedQuery(name="SwdGroupUser.findAll", query="SELECT s FROM SwdGroupUser s")
public class SwdGroupUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdGroupUserPK id;

	public SwdGroupUser() {
	}

	public SwdGroupUserPK getId() {
		return this.id;
	}

	public void setId(SwdGroupUserPK id) {
		this.id = id;
	}

}