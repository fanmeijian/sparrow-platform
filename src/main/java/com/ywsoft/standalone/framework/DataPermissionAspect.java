package com.ywsoft.standalone.framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataPermissionAspect {
	private static final Logger logger = LoggerFactory.getLogger(DataPermissionAspect.class);

	/***
	 * spring自带的repository拦截
	 * 
	 * @param joinPoint
	 * @param result
	 */


	@Pointcut(value = "@annotation(com.ywsoft.standalone.framework.DataPermission)")
	public void pointCut() {
	}

	@AfterReturning(pointcut = ("execution(* com.ywsoft.standalone.framework.entity..*.*(..))"), returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
//		check(joinPoint, result);
//		System.out.println(result.getClass());
//		((List)result).removeAll(((List)result));
//		((List)result).add(new MenuTree(new SwdMenu()));
		logger.info("ActionResponse returned with message [{}]", "");
	}

//	@AfterReturning(pointcut = ("execution(* com.ywsoft.standalone.framework.entity.SwdMenu.*(..))"), returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		check(joinPoint,result);
//		System.out.println(result.getClass());
////		((List)result).add(new MenuTree(new SwdMenu()));
//		logger.info("ActionResponse returned with message [{}]", "");
//	}

	/***
	 * 自定义service的方法拦截；
	 * 
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value = "pointCut() && @annotation(dataPermission)", returning = "result")
	public void afterReturning1(DataPermission dataPermission, Object result) {

		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		String readExpression="";//构造mvel2读取权限的表达式
		
		Map<String, Object> varsMap = new HashMap<String, Object>();
		varsMap.put("curUsername", SecurityContextHolder.getContext().getAuthentication().getName());
		
		//从数据权限表里取出权限
		if(result instanceof java.util.List) {
			Iterator<?> iterator = ((List<?>) result).iterator();
			
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				varsMap.put("returnObject", o);
				

			}
			
			
		}
		
		

//		SwdDataPermissionPK id = new SwdDataPermissionPK();
//		id.setPath(dataPermission.path());
//		id.setPermission(dataPermission.permission());
//		SwdDataPermission swdDataPermission = dataPermissionRepository.findById(id).orElse(null);
//		String listPermissionEL = swdDataPermission == null ? null : swdDataPermission.getPermissionEl();
//
//		id.setPermission("READ");
//		swdDataPermission = dataPermissionRepository.findById(id).orElse(null);
//		String readPermissionEL = swdDataPermission == null ? null : swdDataPermission.getPermissionEl();
//
//		if ((dataPermission.permission().equals("LIST") || dataPermission.permission().equals("READ"))
//				&& (result instanceof java.util.List)) {
//			// LIST对象的控制
//			List<?> list = (List<?>) result;
//			Iterator<?> iterator = list.iterator();
//
//			while (iterator.hasNext()) {
//				Object o = (Object) iterator.next();
//				varsMap.put("returnObject", o);
//				if (listPermissionEL == null ? false : !(boolean) MVEL.eval(listPermissionEL, varsMap)) {
//					iterator.remove();
//				} else if (readPermissionEL != null) {
//					MVEL.eval(readPermissionEL, varsMap);
//				}
//
//			}
//
//		}
//
//		if (dataPermission.permission().equals("READ") && !(result instanceof java.util.List)) {
//			// 单个对象的读权限控制
//			varsMap.put("returnObject", result);
//			if (readPermissionEL != null) {
//				MVEL.eval(readPermissionEL, varsMap);
//			}
//		}

	}
}
