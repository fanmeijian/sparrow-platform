package com.ywsoft.standalone.framework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdFieldPermissionPK;
import com.ywsoft.standalone.framework.repository.FieldPermissionRepository;
import com.ywsoft.standalone.framework.service.FieldPermissionService;

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

	@Autowired
	FieldPermissionService fieldPermissionService;

	@Autowired
	FieldPermissionRepository fieldPermissionRepository;

	@Pointcut(value = "@annotation(com.ywsoft.standalone.framework.DataPermissionInterface)")
	public void pointCut() {
	}

//	@AfterReturning(pointcut = ("execution(* com.ywsoft.standalone.framework.entity..*.*(..))"), returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		check(joinPoint, result);
//		System.out.println(result.getClass());
//		((List)result).removeAll(((List)result));
//		((List)result).add(new MenuTree(new SwdMenu()));
//		logger.info("ActionResponse returned with message [{}]", "");
//	}

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
//	@AfterReturning(value = "pointCut() && @annotation(dataPermission)", returning = "result")
//	public void afterReturning1(DataPermissionInterface dataPermission, Object result) {
//
//		String username=SecurityContextHolder.getContext().getAuthentication().getName();
//		String readExpression="";//构造mvel2读取权限的表达式
//		
//		Map<String, Object> varsMap = new HashMap<String, Object>();
//		varsMap.put("curUsername", SecurityContextHolder.getContext().getAuthentication().getName());
//		
//		//从数据权限表里取出权限
//		if(result instanceof java.util.List) {
//			Iterator<?> iterator = ((List<?>) result).iterator();
//			
//			while (iterator.hasNext()) {
//				Object o = (Object) iterator.next();
//				varsMap.put("returnObject", o);
//				
//
//			}
//			
//			
//		}

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

//	}

//	@Around(value = "pointCut() && @annotation(DataPermissionInterface)")
//	public Object around(ProceedingJoinPoint point){
//		Object result = null;
//		try {
//			result = point.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<?> list = null;
//		int pageNo = 0;
//		int pageSize = 20;
//		if(result instanceof Page){
//			list = ((Page<?>)result).toList();
//			pageNo = ((Page<?>)result).getNumber();
//			pageSize = ((Page<?>)result).getSize();
//		}else {
//			list = (List<?>) result;
//		}
//
//		Iterator<?> iterator = list.iterator();
//		List<Object> filteredList = new ArrayList<Object>();
//		Map<String, Object> varsMap = new HashMap<String, Object>();
//		varsMap.put("curUsername", SecurityContextHolder.getContext().getAuthentication().getName());
//		
//		while (iterator.hasNext()) {
//			Object o = (Object) iterator.next();
//			varsMap.put("returnObject", o);
//			
//			if(!((boolean) MVEL.eval("returnObject.id == 1", varsMap))) 
//				filteredList.add(iterator);
//		}
//		result = new PageImpl<>(filteredList, PageRequest.of(pageNo, pageSize),filteredList.size());
//		
//		return result;
//	}
	@AfterReturning(value = "pointCut() && @annotation(dataPermissionInterface)", returning = "result")
	public void afterReturning1(DataPermissionInterface dataPermissionInterface, Object result) {

		if (dataPermissionInterface.permission().equals("LIST")) {
			List<?> list = null;
			int pageNo = 0;
			int pageSize = 20;
			if (result instanceof Page) {
				list = ((Page<?>) result).toList();
				pageNo = ((Page<?>) result).getNumber();
				pageSize = ((Page<?>) result).getSize();
			} else {
				list = (List<?>) result;
			}

			Iterator<?> iterator = list.iterator();
			List<Object> filteredList = new ArrayList<Object>();
			Map<String, Object> varsMap = new HashMap<String, Object>();
			varsMap.put("curUsername", SecurityContextHolder.getContext().getAuthentication().getName());

			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				varsMap.put("returnObject", o);

				if (!((boolean) MVEL.eval("returnObject.id == 1", varsMap)))
					filteredList.add(iterator);

			}

			result = new PageImpl<>(filteredList, PageRequest.of(pageNo, pageSize), filteredList.size());
		}

		if (dataPermissionInterface.permission().equals("READ")) {
			Object oo = ((Optional<?>) result).get();
			// 找出这个model所有的权限控制
			fieldPermissionRepository
					.findByIdModelAndIdPermission(oo.getClass().getName().replaceAll("class ", ""), dataPermissionInterface.permission())
					.forEach(fieldPermission -> {

						if (!Boolean.valueOf(
								fieldPermissionService.fieldPermission(fieldPermission.getId()).getData().toString())) {
							MVEL.eval("this."+ fieldPermission.getId().getField() +" = null", oo);
						}
					});

		}
	}

}
