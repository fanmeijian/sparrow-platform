package com.ywsoft.standalone.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdAuthority;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.repository.AuthorityRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;

import io.jsonwebtoken.lang.Assert;

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SwdUser swdUser = userRepository.findById(username).orElse(null);
		Assert.notNull(swdUser, "can not found user" + username);
//		Logger.getLogger(this.toString()).info("----------" + username + swdUser.getPassword() + swdUser.getPassword());
		List<SwdAuthority> authorities = new ArrayList<SwdAuthority>();
		
		authorities.addAll(swdUser.getSwdAuthorities());
		swdUser.getSwdSysroles().forEach(o -> {
			authorities.addAll(o.getSwdAuthorities());
		});
		Assert.notEmpty(authorities, "没有权限");
		String[] roles = new String[authorities.size()];
		authorities.forEach(o -> {
			roles[authorities.indexOf(o)] = o.getId();
		});

		return User.withUsername(username).password(swdUser.getPassword()).roles(roles).build();

	}
}
