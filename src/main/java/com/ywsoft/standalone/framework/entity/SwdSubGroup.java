package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_sub_group database table.
 * 
 */
@Entity
@Table(name="swd_sub_group")
@NamedQuery(name="SwdSubGroup.findAll", query="SELECT s FROM SwdSubGroup s")
public class SwdSubGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdSubGroupPK id;

	public SwdSubGroup() {
	}

	public SwdSubGroupPK getId() {
		return this.id;
	}

	public void setId(SwdSubGroupPK id) {
		this.id = id;
	}

}