package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the swd_field database table.
 * 
 */
@Entity
@Table(name="swd_field")
@NamedQuery(name="SwdField.findAll", query="SELECT s FROM SwdField s")
public class SwdField implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdFieldPK id;

	@Column(name="FIELD_NAME")
	private String fieldName;

	@Column(name="MODEL_NAME")
	private String modelName;

	public SwdField() {
	}

	public SwdFieldPK getId() {
		return this.id;
	}

	public void setId(SwdFieldPK id) {
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