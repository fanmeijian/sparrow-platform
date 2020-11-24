package com.ywsoft.standalone.framework.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ywsoft.standalone.framework.entity.SwdAuthority;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.entity.SwdUserAuthority;
import com.ywsoft.standalone.framework.entity.SwdUserMenu;
import com.ywsoft.standalone.framework.entity.SwdUserSysrole;
import com.ywsoft.standalone.framework.repository.AuthorityRepository;
import com.ywsoft.standalone.framework.repository.MenuRepository;
import com.ywsoft.standalone.framework.repository.SysroleRepository;
import com.ywsoft.standalone.framework.repository.UserAuthorityRepository;
import com.ywsoft.standalone.framework.repository.UserMenuRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;
import com.ywsoft.standalone.framework.repository.UserSysroleRepository;


@RestController
public class UserService {

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	SysroleRepository sysroleRepository;

	@Autowired
	UserMenuRepository userMenuRepository;

	@Autowired
	UserAuthorityRepository userAuthorityRepository;
	
	@Autowired
	UserSysroleRepository userSysroleRepository;
	
	/**
	 * {"username":"","menuId":""}
	 * 设置用户菜单
	 * @param jObject
	 */
	@PostMapping("/userMenu")
	public void addUserMenu(@RequestBody JSONObject jObject) {

		SwdUser user = userRepository.getOne(jObject.getString("username"));
		user.getSwdMenus().add(menuRepository.getOne(jObject.getString("menuId")));
		userRepository.save(user);

	}
	
	

	/***
	 * 设置用户菜单
	 * {"username":"","menus":[]}
	 * 
	 * @param jObject
	 */
	@Deprecated
	@PostMapping("/userMenus")
	public void addUserMenus(@RequestBody JSONObject jObject) {

		SwdUser user = userRepository.getOne(jObject.getString("username"));

		JSONArray jArray = jObject.getJSONArray("menus");
		user.getSwdMenus().removeAll(user.getSwdMenus());
		jArray.forEach(o -> {

			user.getSwdMenus().add(menuRepository.getOne(((Map) o).get("id").toString()));

		});

		userRepository.save(user);

	}
	
	

	/***
	 * 设置用户功能权限
	 * @param jObject
	 */
	@PostMapping("/userAuthorities")
	public void addUserAuthorities(@RequestBody JSONObject jObject) {

		SwdUser user = userRepository.getOne(jObject.getString("username"));
		user.getSwdAuthorities().removeAll(user.getSwdAuthorities());
		JSONArray jArray = jObject.getJSONArray("authorities");
		jArray.forEach(o -> {
			user.getSwdAuthorities().add(authorityRepository.getOne(((Map) o).get("id").toString()));
		});

		userRepository.save(user);

	}
	
	
	/***
	 * 设置用户角色
	 * @param jObject
	 */
	@PostMapping("/userSysroles")
	public void addUserSysroles(@RequestBody JSONObject jObject) {

		SwdUser user = userRepository.getOne(jObject.getString("username"));
		user.getSwdSysroles().removeAll(user.getSwdSysroles());
		JSONArray jArray = jObject.getJSONArray("sysroles");
		jArray.forEach(o -> {
			user.getSwdSysroles().add(sysroleRepository.getOne(((Map) o).get("id").toString()));
		});

		userRepository.save(user);

	}

	
	/**
	 * 设置用户功能权限
	 * @param jObject
	 */
	@PostMapping("/userAuthority")
	public void addUserAuthority(@RequestBody JSONObject jObject) {

		SwdUser user = userRepository.getOne(jObject.getString("username"));
		user.getSwdAuthorities().add(authorityRepository.getOne(jObject.getString("authorityId")));

		userRepository.save(user);

	}

	
	@GetMapping("/users")
	public List<SwdUser> users() {
		return userRepository.findAll();
	}
	
	
	@PutMapping("/userMenus")
	public ApiResponse userMenus(@RequestBody final List<SwdUserMenu> userMenus) {
		SwdUser user = userRepository.getOne(userMenus.get(0).getId().getUsername());
		user.getSwdMenus().removeAll(user.getSwdMenus());
		userMenuRepository.saveAll(userMenus);
		return ApiResponseFactory.getNormalReponse();
	}
	
	@PutMapping("/userAuthorities")
	public ApiResponse userAuthorities(@RequestBody final List<SwdUserAuthority> userAuthorities) {
		SwdUser user = userRepository.getOne(userAuthorities.get(0).getId().getUsername());
		user.getSwdAuthorities().removeAll(user.getSwdAuthorities());
		userAuthorityRepository.saveAll(userAuthorities);
		return ApiResponseFactory.getNormalReponse();
	}
	
	@PutMapping("/userSysroles")
	public ApiResponse userSysroles(@RequestBody final List<SwdUserSysrole> userSysroles) {
		SwdUser user = userRepository.getOne(userSysroles.get(0).getId().getUsername());
		user.getSwdSysroles().removeAll(user.getSwdSysroles());
		userSysroleRepository.saveAll(userSysroles);
		return ApiResponseFactory.getNormalReponse();
	}
}
