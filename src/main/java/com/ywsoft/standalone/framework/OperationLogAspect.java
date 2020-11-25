package com.ywsoft.standalone.framework;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSONObject;
import com.ywsoft.standalone.framework.entity.SwdUser;

@Aspect
@Component
public class OperationLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

	@Autowired
	private HttpServletRequest request; // 直接注入

	@Autowired
	private SwdLogServiceImpl logService;
	
//	@Before("execution(* com.ywsoft.standalone.framework.repository..*.*(..))")
//	public void logBefore(JoinPoint joinPoint) {
//
//	    logger.info("***************************************************************************");
//	    logger.info("Before executing method : " + joinPoint.getSignature().getDeclaringTypeName() + joinPoint.getSignature().getName()+joinPoint.getArgs());
//	}

	@Around("execution(* com.ywsoft.standalone.framework.repository..*.*(..))")
	public Object around(ProceedingJoinPoint point) {
		if(MethodSignature.class.cast(point.getSignature()).getMethod().getName().equals("operationLog")) {
			try {
				return point.proceed();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		long start = System.currentTimeMillis();
		Object result = null;
		try {
			result = point.proceed();
			logger.info("{} {}->{}({}): {} in {}", "",
					point.getSignature().getDeclaringTypeName(),
					MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(),
					result, System.currentTimeMillis() - start);
			// 需通过requestcontextholder来判断httprequest是否有效，否则启动的时候会报错；同时只记录保存的
			if (RequestContextHolder.getRequestAttributes() != null) {
				if (!request.getMethod().equals(HttpMethod.GET.toString())
						&& !point.getSignature().getName().startsWith("find")
						&& !point.getSignature().getName().startsWith("get")) {
//					logger.info("{} {}->{}({}): {} in {}", request.getUserPrincipal().getName(),
//							point.getSignature().getDeclaringTypeName(),
//							MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(),
//							result, System.currentTimeMillis() - start);
					
					logService.operationLog(request, MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(), result);
				}
			}		

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}

//	
//	@Around("execution(* com.ywsoft.standalone.framework.repository..*.delete*(..))")
//	 public Object around2(ProceedingJoinPoint point) {
//		    long start = System.currentTimeMillis();
//		    Object result = null;
//			try {
//				result = point.proceed();
//				logger.info(
//					      "{}{}->{}({}): {} in {}",
//					      request.getUserPrincipal().getName(),
//					      point.getSignature().getDeclaringTypeName(),
//					      MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
//					      point.getArgs(),
//					      result,
//					      System.currentTimeMillis() - start
//					    );					  
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return result;
//	 }
//	
	@Around("execution(* com.ywsoft.standalone.framework.service..*.*(..))")
	public Object around3(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		Object result = null;
		try {
			logger.info("{} {}->{}({}): {} in {}", "",
					point.getSignature().getDeclaringTypeName(),
					MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(),
					result, System.currentTimeMillis() - start);
			result = point.proceed();
			if (!request.getMethod().equals(HttpMethod.GET.toString())) {
//				logger.info("{}{}->{}({}): {} in {}", request.getMethod(), point.getSignature().getDeclaringTypeName(),
//						MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(), result,
//						System.currentTimeMillis() - start);
				logService.operationLog(request, MethodSignature.class.cast(point.getSignature()).getMethod().getName(), point.getArgs(), result);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
