package com.ywsoft.standalone.framework.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdFieldPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdSysroleFieldPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdUserSysrole;
import com.ywsoft.standalone.framework.repository.FieldPermissionRepository;
import com.ywsoft.standalone.framework.repository.SysroleFieldPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserFieldPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserSysroleRepository;

@RestController
public class FieldPermissionService {

	@Autowired
	FieldPermissionRepository fieldPermissionRepository;
	@Autowired
	UserSysroleRepository userSysroleRepository;
	@Autowired
	UserFieldPermissionRepository userFieldPermissionRepository;
	@Autowired
	SysroleFieldPermissionRepository sysroleFieldPermissionRepository;

	@PostMapping("/fieldPermission")
	public ApiResponse fieldPermission(@RequestBody final SwdFieldPermissionPK fieldPermissionPK) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, Object> mapMvel = new HashMap<String, Object>();
		mapMvel.put("curUsername", username);

		boolean elPermission = false;// 检查el是否有权限
		boolean userPermission = false;// 检查用户是否有权限
		boolean sysrolePermission = false;// 检查用户的角色里是否有权限
		Optional<SwdFieldPermission> optional = fieldPermissionRepository.findById(fieldPermissionPK);
		if (optional.isEmpty())
			elPermission = true;

		// 检查用户是否有此权限
		SwdUserFieldPermissionPK userFieldPermissionPK = new SwdUserFieldPermissionPK();
		userFieldPermissionPK.setModel(fieldPermissionPK.getModel());
		userFieldPermissionPK.setField(fieldPermissionPK.getField());
		userFieldPermissionPK.setPermission(fieldPermissionPK.getPermission());
		userFieldPermissionPK.setUsername(username);
		if (!userFieldPermissionRepository.findById(userFieldPermissionPK).isEmpty())
			userPermission = true;

		// 检查用户的角色是否有此权限
		for (SwdUserSysrole userSysrole : userSysroleRepository.findByIdUsername(username, Pageable.unpaged())
				.toList()) {
			SwdSysroleFieldPermissionPK sysroleFieldPermissionPK = new SwdSysroleFieldPermissionPK();
			sysroleFieldPermissionPK.setModel(fieldPermissionPK.getModel());
			sysroleFieldPermissionPK.setField(fieldPermissionPK.getField());
			sysroleFieldPermissionPK.setPermission(fieldPermissionPK.getPermission());
			sysroleFieldPermissionPK.setSysroleId(userSysrole.getId().getSysroleId());
			if (!sysroleFieldPermissionRepository.findById(sysroleFieldPermissionPK).isEmpty()) {
				sysrolePermission = true;
				break;
			}

		}

		return ApiResponseFactory.getNormalReponse(elPermission || userPermission || sysrolePermission);

	}

}
