package com.ywsoft.standalone.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.ext.Authority;
import com.ywsoft.standalone.framework.repository.AuthorityRepository;
import com.ywsoft.standalone.framework.repository.SysroleRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;

@RestController
public class AuthorityService {
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SysroleRepository sysroleRepository;
	
	@GetMapping("/authoritiesWithCheckByUser")
	public ApiResponse authoritiesWithCheckByUser(@RequestParam(name="username") String username) {
		List<Authority> list=new ArrayList<Authority>();
		authorityRepository.findAll().forEach(o->{
			Authority authority=new Authority(o);
			userRepository.findById(username).get().getSwdAuthorities().forEach(j->{
				if(authority.getId().equals(j.getId())) {
					authority.setChecked(true);
				}
			});
			list.add(authority);
		});
		return ApiResponseFactory.getNormalReponse(list);
	}
	
	@GetMapping("/authoritiesWithCheckBySysrole")
	public ApiResponse authoritiesWithCheckBySysrole(@RequestParam(name="sysroleId") String sysroleId) {
		List<Authority> list=new ArrayList<Authority>();
		authorityRepository.findAll().forEach(o->{
			Authority authority=new Authority(o);
			sysroleRepository.findById(sysroleId).get().getSwdAuthorities().forEach(j->{
				if(authority.getId().equals(j.getId())) {
					authority.setChecked(true);
				}
			});
			list.add(authority);
		});
		return ApiResponseFactory.getNormalReponse(list);
	}
}
