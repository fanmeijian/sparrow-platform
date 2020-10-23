package com.ywsoft.standalone.framework.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ywsoft.standalone.framework.entity.SwdSysrole;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.entity.ext.Sysrole;
import com.ywsoft.standalone.framework.repository.AuthorityRepository;
import com.ywsoft.standalone.framework.repository.MenuRepository;
import com.ywsoft.standalone.framework.repository.SysroleRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;

@RestController
public class SysroleService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	SysroleRepository sysroleRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	MenuRepository menuRepository;

	@GetMapping("/sysrolesWithCheckByUser")
	public List<Sysrole> authoritiesWithCheckByUser(@RequestParam(name = "username") String username) {
		List<Sysrole> list = new ArrayList<Sysrole>();
		sysroleRepository.findAll().forEach(o -> {
			Sysrole sysrole = new Sysrole(o);
			userRepository.findById(username).get().getSwdSysroles().forEach(j -> {
				if (sysrole.getId().equals(j.getId())) {
					sysrole.setChecked(true);
				}
			});
			list.add(sysrole);
		});
		return list;
	}

	@PostMapping("/sysroleMenus")
	public void addSysroleMenus(@RequestBody JSONObject jObject) {

		SwdSysrole sysrole = sysroleRepository.getOne(jObject.getString("sysroleId"));

		JSONArray jArray = jObject.getJSONArray("menus");
		sysrole.getSwdMenus().removeAll(sysrole.getSwdMenus());
		jArray.forEach(o -> {

			sysrole.getSwdMenus().add(menuRepository.getOne(((Map) o).get("id").toString()));

		});

		sysroleRepository.save(sysrole);

	}

	@PostMapping("/sysroleAuthorities")
	public void addSysroleAuthorities(@RequestBody JSONObject jObject) {

		SwdSysrole sysrole = sysroleRepository.getOne(jObject.getString("sysroleId"));
		sysrole.getSwdAuthorities().removeAll(sysrole.getSwdAuthorities());
		JSONArray jArray = jObject.getJSONArray("authorities");
		jArray.forEach(o -> {
			sysrole.getSwdAuthorities().add(authorityRepository.getOne(((Map) o).get("id").toString()));
		});

		sysroleRepository.save(sysrole);

	}
}
