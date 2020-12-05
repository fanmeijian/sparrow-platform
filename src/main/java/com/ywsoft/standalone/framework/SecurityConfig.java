package com.ywsoft.standalone.framework;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ywsoft.standalone.framework.repository.AuthorityRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	JwtRequestFilter jwtRequestFilter;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/***
	 * 从authority表加载配置的功能权限，将功能权限的id作为spring security的角色名
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// get the permission from db
		authorityRepository.findAll().forEach(authority -> {
			try {
				if (authority.getPermission().equalsIgnoreCase("ANONYMOUSE")) {
					// anonymouse access
					Logger.getLogger(this.toString()).info("初始化匿名访问资源:" + authority.getId() + " "
							+ authority.getMethod() + " " + authority.getAuthority() + " " + authority.getUri());
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri()).permitAll();
				} else if (authority.getPermission().equalsIgnoreCase("AUTHENTICATED")) {
					// athenticated access
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri()).authenticated();
					Logger.getLogger(this.toString()).info("初始化认证访问资源:" + authority.getId() + " "
							+ authority.getMethod() + " " + authority.getAuthority() + " " + authority.getUri());
				} else {
					// restrict access
					// put the access control uri in spring security framework
					Logger.getLogger(this.toString()).info("初始化受限资源:" + authority.getId() + " " + authority.getMethod()
							+ " " + authority.getAuthority() + " " + authority.getUri());
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri())
							.hasRole(authority.getId());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		// let the get token method allowed
//		http.csrf().disable().authorizeRequests().antMatchers("/authenticate", "/oauth2/token").permitAll().anyRequest()
//				.authenticated().and().exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		//说明这是一个资源服务器，jwt格式的token
		http.csrf().disable().oauth2ResourceServer().jwt();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Allow OPTIONS calls to be accessed without authentication
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
