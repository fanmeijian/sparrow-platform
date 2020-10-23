package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the swd_user_file database table.
 * 
 */
@Embeddable
public class SwdUserFilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String username;

	@Column(name="FILE_ID", insertable=false, updatable=false)
	private String fileId;

	private String permission;

	public SwdUserFilePK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFileId() {
		return this.fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SwdUserFilePK)) {
			return false;
		}
		SwdUserFilePK castOther = (SwdUserFilePK)other;
		return 
			this.username.equals(castOther.username)
			&& this.fileId.equals(castOther.fileId)
			&& this.permission.equals(castOther.permission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.fileId.hashCode();
		hash = hash * prime + this.permission.hashCode();
		
		return hash;
	}
}