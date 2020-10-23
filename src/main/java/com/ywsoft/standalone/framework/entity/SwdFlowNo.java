package com.ywsoft.standalone.framework.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

import java.math.BigInteger;


/**
 * The persistent class for the swd_flow_no database table.
 * 
 */
@Entity
@Table(name="swd_flow_no")
@NamedQuery(name="SwdFlowNo.findAll", query="SELECT s FROM SwdFlowNo s")
public class SwdFlowNo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwdFlowNoPK id;

	private String el;

	private String remark;

	private int reset;

	@Column(name="SEQUENCE_LENGTH")
	private int sequenceLength;

	@Column(name="SEQUENCE_NO")
	private BigInteger sequenceNo;

	//uni-directional many-to-one association to SwdApp
	@ManyToOne
	@JoinColumn(name="APP_ID",insertable = false,updatable = false)
	private SwdApp swdApp;

	public SwdFlowNo() {
	}

	public SwdFlowNoPK getId() {
		return this.id;
	}

	public void setId(SwdFlowNoPK id) {
		this.id = id;
	}

	public String getEl() {
		return this.el;
	}

	public void setEl(String el) {
		this.el = el;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getReset() {
		return this.reset;
	}

	public void setReset(int reset) {
		this.reset = reset;
	}

	public int getSequenceLength() {
		return this.sequenceLength;
	}

	public void setSequenceLength(int sequenceLength) {
		this.sequenceLength = sequenceLength;
	}

	public BigInteger getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(BigInteger sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public SwdApp getSwdApp() {
		return this.swdApp;
	}

	public void setSwdApp(SwdApp swdApp) {
		this.swdApp = swdApp;
	}

}