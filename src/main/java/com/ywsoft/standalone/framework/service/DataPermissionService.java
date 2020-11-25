package com.ywsoft.standalone.framework.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mvel2.MVEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdDataPermission;
import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdUserDataPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdUserSysrole;
import com.ywsoft.standalone.framework.repository.DataPermissionRepository;
import com.ywsoft.standalone.framework.repository.SysroleDataPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserDataPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserSysroleRepository;

@RestController
public class DataPermissionService {

	@Autowired
	UserDataPermissionRepository userDataPermissionRepository;
	@Autowired
	SysroleDataPermissionRepository sysroleDataPermissionRepository;
	@Autowired
	DataPermissionRepository dataPermissionRepository;
	@Autowired
	UserSysroleRepository userSysroleRepository;
	@Autowired
	List<BackendIdConverter> backendIdConverters;

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * 检查当前用户是否含有这个权限 model,pkey,permission
	 */
	@PostMapping("/dataPermission")
	public ApiResponse dataPermission(@RequestBody final SwdDataPermissionPK dataPermissionPK) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, Object> mapMvel = new HashMap<String, Object>();
		backendIdConverters.size();
		mapMvel.put("curUsername", username);
		try {
			Class<?> dataClass = Class.forName(dataPermissionPK.getModel());
			Object id = null;
			for (BackendIdConverter converter : backendIdConverters) {
				if (converter.supports(dataClass)) {
					id = converter.fromRequestId(dataPermissionPK.getPkey(), dataClass);
				}
			}
			if (id == null)
				id = dataPermissionPK.getPkey();
			Object modelData = entityManager.find(dataClass, id);
			mapMvel.put("data", modelData);// 数据的模型值
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		boolean elPermission = false;// 检查el是否有权限
		boolean userPermission = false;// 检查用户是否有权限
		boolean sysrolePermission = false;// 检查用户的角色里是否有权限
		Optional<SwdDataPermission> optional = dataPermissionRepository.findById(dataPermissionPK);
		if (optional.isEmpty())
			return HttpBusinessStatusCode.DATA_NOT_FOUND;

		// 检查公式表达式是否有此权限
		String el = optional.get().getPermissionEl();
		if (el != null) {
			elPermission = (boolean) MVEL.eval(el, mapMvel);
		}

		// 检查用户是否有此权限
		SwdUserDataPermissionPK userDataPermissionPK = new SwdUserDataPermissionPK();
		userDataPermissionPK.setModel(dataPermissionPK.getModel());
		userDataPermissionPK.setPkey(dataPermissionPK.getPkey());
		userDataPermissionPK.setPermission(dataPermissionPK.getPermission());
		userDataPermissionPK.setUsername(username);
		if (!userDataPermissionRepository.findById(userDataPermissionPK).isEmpty())
			userPermission = true;

		// 检查用户的角色是否由此权限
		for (SwdUserSysrole userSysrole : userSysroleRepository.findByIdUsername(username, Pageable.unpaged())
				.toList()) {
			SwdSysroleDataPermissionPK sysroleDataPermissionPK = new SwdSysroleDataPermissionPK();
			sysroleDataPermissionPK.setModel(dataPermissionPK.getModel());
			sysroleDataPermissionPK.setPkey(dataPermissionPK.getPkey());
			sysroleDataPermissionPK.setPermission(dataPermissionPK.getPermission());
			sysroleDataPermissionPK.setSysroleId(userSysrole.getId().getSysroleId());
			if (!sysroleDataPermissionRepository.findById(sysroleDataPermissionPK).isEmpty()) {
				sysrolePermission = true;
				break;
			}

		}

		return ApiResponseFactory.getNormalReponse(elPermission || userPermission || sysrolePermission);
	}
}
