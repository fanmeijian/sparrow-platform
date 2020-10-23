package com.ywsoft.standalone.framework.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdAuthority;
import com.ywsoft.standalone.framework.entity.SwdMenu;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.repository.AuthorityRepository;
import com.ywsoft.standalone.framework.repository.MenuRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;



@RestController
public class TestService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository repository;
	
	@GetMapping("/test")
	public SwdUser test(@RequestParam(name="username") String username) {
		return userRepository.findById(username).get();
		
	}
	
	@GetMapping("/testWithNoRole")
	public String testWithNoRole() {
//		List<SwdUser> list=new ArrayList<SwdUser>();
//		for(int i=20000;i<100000;i++) {
//			SwdUser user=new SwdUser();
//			user.setUsername("userT"+i);
//			user.setPassword("{bcrypt}$2a$10$wphkkzZPlp0enF5tV2yWBO3M63USwsNyEJrycmE2BNh98O0jcKp1m");
//			user.setEnabled((byte)1);
//			list.add(user);
//		}
//		userRepository.saveAll(list);
		
		
//		
//List<SwdMenu> list= new ArrayList<SwdMenu>();
//		
//		for (int i = 20000; i < 100000; i++) {
//			SwdMenu o = new SwdMenu();
//			o.setName("菜单" + i);
//			o.setParentId(BigInteger.ZERO);
//			o.setSort(BigInteger.ZERO);
//			o.setUrl("/menu"+i);
//			list.add(o);
//		}
//		
//		menuRepository.saveAll(list);
		
		List<SwdAuthority> list= new ArrayList<SwdAuthority>();
		
		for (int i = 20000; i < 100000; i++) {
			SwdAuthority o = new SwdAuthority();
			o.setAuthority("权限" + i);
			o.setUri("/authority"+i);
			list.add(o);
		}
		
		repository.saveAll(list);
		return "no role needed!";
	}
	
	@GetMapping("/authority99370")
	public String testWithUser() {
		return "testWithUser!";
	}
}
