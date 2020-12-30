package com.ywsoft.standalone.framework.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.SwdLogService;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.entity.ext.UserExt;
import com.ywsoft.standalone.framework.repository.UserRepository;

@RestController
public class OauthClientController{
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	SwdLogService loginLogService;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	ApiResponseError apiResponseError;

	@Autowired
	ApiResponseNormal apiResponseNormal;
	
	@Autowired
	HttpServletRequest servletContext;
	
	
	/***
	 * 修改密码
	 * 
	 * @author fanmj
	 *
	 */
	@PostMapping("/oauth/password")
	public ApiResponse changePassword(@RequestBody final UserExt userExt) {
		Optional<SwdUser> opticalUser = userRepository.findById(userExt.getUsername());
		if (opticalUser.isEmpty())
			return HttpBusinessStatusCode.USER_NOT_FOUND;
		loginLogService.loginLog(userExt.getUsername(), servletContext.getRemoteAddr());
		SwdUser swdUser = opticalUser.get();
		if (!userExt.getPassword().equals(userExt.getSecondPassword()))
			return HttpBusinessStatusCode.SECOND_PASSWORD_NOT_MATCH;
		if (!passwordEncoder.matches(userExt.getOldPassword(), swdUser.getPassword()))
			return HttpBusinessStatusCode.OLD_PASSWORD_NOT_MATCH;
		opticalUser.get().setPassword(passwordEncoder.encode(userExt.getPassword()));
		userRepository.save(opticalUser.get());
		return ApiResponseFactory.getNormalReponse();
	}
	
	
	/***
	 * 重置密码
	 * 
	 * @author fanmj
	 *
	 */
	@PatchMapping("/oauth/password")
	public ApiResponse resetPassword(@RequestBody final SwdUser user) {
		Optional<SwdUser> opticalUser = userRepository.findById(user.getUsername());
		if (opticalUser.isEmpty())
			return HttpBusinessStatusCode.USER_NOT_FOUND;
		SwdUser swdUser = opticalUser.get();
		swdUser.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(swdUser);
		return ApiResponseFactory.getNormalReponse();
	}
}
