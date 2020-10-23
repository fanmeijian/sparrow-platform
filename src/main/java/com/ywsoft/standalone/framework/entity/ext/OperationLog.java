package com.ywsoft.standalone.framework.entity.ext;

import com.ywsoft.standalone.framework.entity.SwdOperationLog;

public class OperationLog extends SwdOperationLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object params;
	
	public OperationLog(SwdOperationLog operationLog){
		this.setId(operationLog.getId());
		this.setIp(operationLog.getIp());
		this.setUri(operationLog.getUri());
		this.setOpTime(operationLog.getOpTime());
		this.setUsername(operationLog.getUsername());
		
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}
	
	
}
