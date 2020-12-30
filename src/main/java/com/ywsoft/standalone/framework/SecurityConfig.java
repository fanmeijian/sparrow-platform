package com.ywsoft.standalone.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import com.ywsoft.standalone.framework.repository.AuthorityRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthorityRepository authorityRepository;

	@Value("${spring.application.name}")
	String clientId;

	// 用于解决默认只会获取scope的权限，而用户的实际权限在authorities里面
	private JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}

	/***
	 * 从authority表加载配置的功能权限，将功能权限的id作为spring security的角色名
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// get the permission from db
		authorityRepository.findByClientId(clientId).forEach(authority -> {
			try {
				if (authority.getPermission().equalsIgnoreCase("DENY")) {
//					Logger.getLogger(this.toString()).info("初始化拒绝额访问资源:" + authority.getId() + " "
//							+ authority.getMethod() + " " + authority.getAuthority() + " " + authority.getUri());
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri()).denyAll();
				} else if (authority.getPermission().equalsIgnoreCase("ANONYMOUSE")) {
					// anonymouse access
//					Logger.getLogger(this.toString()).info("初始化匿名访问资源:" + authority.getId() + " "
//							+ authority.getMethod() + " " + authority.getAuthority() + " " + authority.getUri());
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri()).permitAll();
				} else if (authority.getPermission().equalsIgnoreCase("AUTHENTICATED")) {
					// athenticated access
					http.csrf().disable().authorizeRequests()
							.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri()).authenticated();
//					Logger.getLogger(this.toString()).info("初始化认证访问资源:" + authority.getId() + " "
//							+ authority.getMethod() + " " + authority.getAuthority() + " " + authority.getUri());
				} else {
					// restrict access
					// put the access control uri in spring security framework
//					Logger.getLogger(this.toString()).info("初始化受限资源:" + authority.getId() + " " + authority.getMethod()
//							+ " " + authority.getAuthority() + " " + authority.getUri());
					http.csrf().disable()
							.authorizeRequests((authorizeRequests) -> authorizeRequests
									.antMatchers(HttpMethod.resolve(authority.getMethod()), authority.getUri())
									.hasRole(authority.getId()))
							.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Allow OPTIONS calls to be accessed without authentication
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
