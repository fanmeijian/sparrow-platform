package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_unit_level database table.
 * 
 */
@Embeddable
public class SwdUnitLevelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="UNIT_ID", insertable=false, updatable=false)
	private String unitId;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(name="LEVEL_ID", insertable=false, updatable=false)
	private String levelId;

	public SwdUnitLevelPK() {
	}
	public String getUnitId() {
		return this.unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLevelId() {
		return this.levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdUnitLevelPK)) {
			return false;
		}
		SwdUnitLevelPK castOther = (SwdUnitLevelPK)other;
		return 
			this.unitId.equals(castOther.unitId)
			&& this.username.equals(castOther.username)
			&& this.levelId.equals(castOther.levelId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.unitId.hashCode();
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.levelId.hashCode();
		
		return hash;
	}
}