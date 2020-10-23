package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the swd_operation_log database table.
 * 
 */
@Entity
@Table(name="swd_operation_log")
@NamedQuery(name="SwdOperationLog.findAll", query="SELECT s FROM SwdOperationLog s")
public class SwdOperationLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Lob
	@Column(name="MODEL_BYTEARRAY")
	private byte[] modelBytearray;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OP_TIME")
	private Date opTime;

	private String uri;

	private String username;
	
	private String ip;
	

	public SwdOperationLog() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getModelBytearray() {
		return this.modelBytearray;
	}

	public void setModelBytearray(byte[] modelBytearray) {
		this.modelBytearray = modelBytearray;
	}

	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}