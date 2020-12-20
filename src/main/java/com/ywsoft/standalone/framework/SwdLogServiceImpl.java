package com.ywsoft.standalone.framework;

import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.internal.marshaller.optimized.OptimizedMarshaller;
import org.apache.ignite.lang.IgnitePredicate;
import org.apache.ignite.marshaller.Marshaller;
import org.apache.ignite.marshaller.MarshallerContext;
import org.apache.ignite.marshaller.jdk.JdkMarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ywsoft.standalone.framework.entity.SwdLoginLog;
import com.ywsoft.standalone.framework.entity.SwdOperationLog;

@Configuration
public class SwdLogServiceImpl implements SwdLogService {

	@Autowired
	LoginLogRepository loginLogRepository;
	
	@Autowired
	OperationLogRepository operationLogRepository;
	
	@Autowired
	Marshaller marsh;

	@Override
	public void loginLog(String username, String ip) {
//		Logger.getLogger(SwdLogServiceImpl.class.getName()).info(username + ip);
		SwdLoginLog loginLog = new SwdLoginLog();
		loginLog.setIp(ip);
		loginLog.setUsername(username);
		loginLogRepository.save(loginLog);
	}

	@Override
	public void operationLog(HttpServletRequest request, String opName, Object[] opArgs, Object result) {
		SwdOperationLog operationLog = new SwdOperationLog();
		
		operationLog.setOpTime(new Date());
		operationLog.setUri("["+request.getMethod()+"]" + request.getServletPath());
		operationLog.setIp(request.getRemoteAddr());
//		operationLog.setUsername(request.getRemoteUser());
		operationLog.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		try {
			operationLog.setModelBytearray(marsh.marshal(opArgs));
		} catch (IgniteCheckedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		operationLogRepository.save(operationLog);
		
	}

}
