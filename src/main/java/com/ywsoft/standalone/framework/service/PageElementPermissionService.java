package com.ywsoft.standalone.framework.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageElementPermissionService {
	/**
	 * 判断按钮的权限，通过path和permission来检查是否拥有此操作权限
	 * @param path
	 * @param permission
	 * @return
	 */
	@GetMapping("/buttonPermission")
	public boolean buttonPermission(@RequestParam(name = "path") String path,@RequestParam(name = "permission") String permission) {
		return false;
		
	}
	
	@GetMapping("/fieldPermission")
	public boolean fieldPermission(@RequestParam(name = "path") String path,@RequestParam(name = "permission") String permission) {
		return false;
		
	}
}
