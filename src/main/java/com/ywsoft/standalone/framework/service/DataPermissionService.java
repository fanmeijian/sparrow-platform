package com.ywsoft.standalone.framework.service;

import java.util.List;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdDataPermission;
import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermissionPK;
import com.ywsoft.standalone.framework.repository.DataPermissionRepository;
import com.ywsoft.standalone.framework.repository.SysroleFieldPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserFieldPermissionRepository;

@RestController
public class DataPermissionService {

	@Autowired
	DataPermissionRepository dataPermissionRepository;



	@GetMapping("/dataPermission")
	public Iterable<SwdDataPermission> dataPermission() {
		return dataPermissionRepository.findAll();
				
	}	
	
	@PutMapping("/dataPermission")
	@PostMapping("/dataPermission")
	public SwdDataPermission dataPermission(@RequestBody final SwdDataPermission swdDataPermission) {
		return dataPermissionRepository.save(swdDataPermission);
	}
	
	
	@DeleteMapping("/dataPermission")
	public void dataPermission(@RequestBody final SwdDataPermissionPK id) {
		dataPermissionRepository.deleteById(id);
	}


}
