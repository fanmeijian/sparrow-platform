package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_field_permission database table.
 * 
 */
@Entity
@Table(name="swd_field_permission")
@NamedQuery(name="SwdFieldPermission.findAll", query="SELECT s FROM SwdFieldPermission s")
public class SwdFieldPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdFieldPermissionPK id;

	@Column(name="FIELD_NAME")
	private String fieldName;

	@Column(name="MODEL_NAME")
	private String modelName;

	public SwdFieldPermission() {
	}

	public SwdFieldPermissionPK getId() {
		return this.id;
	}

	public void setId(SwdFieldPermissionPK id) {
		this.id = id;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}