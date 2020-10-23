package com.ywsoft.standalone.framework;

import javax.servlet.http.HttpServletRequest;

public interface SwdLogService {
	public void loginLog(String username, String ip);

	public void operationLog(HttpServletRequest request, String opName, Object[] opArgs, Object result);

}
