package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_flow_no database table.
 * 
 */
@Embeddable
public class SwdFlowNoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String code;

	@Column(name="APP_ID", insertable=false, updatable=false)
	private String appId;

	public SwdFlowNoPK() {
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAppId() {
		return this.appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdFlowNoPK)) {
			return false;
		}
		SwdFlowNoPK castOther = (SwdFlowNoPK)other;
		return 
			this.code.equals(castOther.code)
			&& this.appId.equals(castOther.appId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.appId.hashCode();
		
		return hash;
	}
}