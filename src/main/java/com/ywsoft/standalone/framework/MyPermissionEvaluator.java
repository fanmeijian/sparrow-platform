package com.ywsoft.standalone.framework;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;
import com.ywsoft.standalone.framework.service.DataPermissionService;

@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	DataPermissionService dataPermissionService;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		//可用于控制字段权限
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		//用于控制数据权限
		SwdDataPermissionPK dataPermissionPK = new SwdDataPermissionPK();
		dataPermissionPK.setModel(targetType);
		dataPermissionPK.setPkey(targetId.toString());
		dataPermissionPK.setPermission(permission.toString());
		return Boolean.valueOf(dataPermissionService.dataPermission(dataPermissionPK).getData().toString());
	}

}
