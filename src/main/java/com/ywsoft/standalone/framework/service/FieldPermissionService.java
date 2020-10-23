package com.ywsoft.standalone.framework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.FinalArrayList;
import com.ywsoft.standalone.framework.entity.SwdField;
import com.ywsoft.standalone.framework.entity.SwdFieldPK;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermissionPK;
import com.ywsoft.standalone.framework.repository.FieldRepository;
import com.ywsoft.standalone.framework.repository.SysroleFieldPermissionRepository;
import com.ywsoft.standalone.framework.repository.UserFieldPermissionRepository;

@RestController
public class FieldPermissionService {

	@Autowired
	UserFieldPermissionRepository userFieldPermissionRepository;

	@Autowired
	SysroleFieldPermissionRepository sysroleFieldPermissionRepository;

	@Autowired
	FieldRepository fieldRepository;

	/**
	 * 获取当前登录用户下的指定model的所有权限
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/myFieldPermission/{model}")
	public Iterable<SwdUserFieldPermission> myModelDataPermissions(@PathVariable("model") String model) {
		return userFieldPermissionRepository
				.findByUsernameAndModel(SecurityContextHolder.getContext().getAuthentication().getName(), model);

	}

	/**
	 * 获取当前登录用户指定字段的所有权限
	 * 
	 * @param model
	 * @param field
	 * @return
	 */
	@GetMapping("/myFieldPermission/{model}/{field}")
	public List<SwdUserFieldPermission> myModelFieldDataPermissions(@PathVariable("model") String model,
			@PathVariable("field") String field) {

		return userFieldPermissionRepository.findByUsernameAndModelAndField(
				SecurityContextHolder.getContext().getAuthentication().getName(), model, field);

	}

	/***
	 * 检查当前登录用户是否拥有指定的字段权限
	 * 
	 * @param model
	 * @param field
	 * @param permission
	 * @return
	 */
	@GetMapping("/myFieldPermission/{model}/{field}/{permission}")
	public SwdUserFieldPermission myModelFielDataPermission(@PathVariable("model") String model,
			@PathVariable("field") String field, @PathVariable("permission") String permission) {

		SwdUserFieldPermissionPK id = new SwdUserFieldPermissionPK();
		id.setModel(model);
		id.setField(field);
		id.setPermission(permission);
		id.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		return userFieldPermissionRepository.findById(id).orElse(null);
	}

	/**
	 * 获取某个字段下的所有权限设置
	 * 
	 * @param model
	 * @param field
	 * @return
	 */
	@GetMapping("/userFieldPermission/{model}/{field}")
	public Iterable<SwdUserFieldPermission> userFieldPermission(@PathVariable("model") String model,
			@PathVariable("field") String field) {

		return userFieldPermissionRepository.findByModelAndField(model, field);

	}

	/**
	 * 设置用户的字段权限
	 * 
	 * @param swdUserFieldPermission
	 * @return
	 */
	@PostMapping("/userFieldPermission")
	public SwdUserFieldPermission UserFieldPermission(@RequestBody SwdUserFieldPermission swdUserFieldPermission) {
		return userFieldPermissionRepository.save(swdUserFieldPermission);
	}
	
	
	@DeleteMapping("/userFieldPermission")
	public void UserFieldPermission(@RequestBody final SwdUserFieldPermissionPK id) {
		userFieldPermissionRepository.deleteById(id);	
	}
	
	@DeleteMapping("/userFieldPermission/{username}/{model}/{field}/{permission}")
	public void UserFieldPermission(@PathVariable(name = "id") String username,@PathVariable(name = "model") String model,@PathVariable(name = "field") String field,@PathVariable(name = "permission") String permission) {
		
	
	}

	/***
	 * 获取某个model对象下的所有字段的所有权限设置
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/userFieldPermission/{model}")
	public Iterable<SwdUserFieldPermission> userFieldPermission(@PathVariable("model") String model) {

		return userFieldPermissionRepository.findByModel(model);

	}

	/**
	 * 
	 * 获取所有字段
	 * 
	 * @return
	 */
	@GetMapping("/fields")
	public Iterable<SwdField> fields() {
		return fieldRepository.findAll();
	}

	/**
	 * 增加字段
	 * 
	 * @param swdField
	 * @return
	 */
	@PutMapping("/fields")
	public SwdField fields(@RequestBody SwdField swdField) {
		return fieldRepository.save(swdField);
	}
	
	
	@PostMapping("/fields")
	public SwdField newFields(@RequestBody SwdField swdField) {
		return fieldRepository.save(swdField);
	}

	@DeleteMapping("/fields")
	public void delFields(@RequestBody SwdFieldPK id) {
		fieldRepository.deleteById(id);
	}
	
	
	/**
	 * 删除字段
	 * @param model
	 * @param field
	 */
	@DeleteMapping("/fields/{model}/{field}")
	public void fields(@PathVariable(name = "model") String model, @PathVariable(name = "field") String field) {
		SwdFieldPK swdFieldPK = new SwdFieldPK();
		swdFieldPK.setModel(model);
		swdFieldPK.setField(field);
		fieldRepository.deleteById(swdFieldPK);
	}
	
	
	/**
	 * 删除model
	 * @param model
	 */
	@Transactional
	@DeleteMapping("/fields/{model}")
	public void fields(@PathVariable(name = "model") String model) {
		
		fieldRepository.deleteByModel(model);
	}
	

}
