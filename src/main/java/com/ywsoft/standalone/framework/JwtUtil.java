package com.ywsoft.standalone.framework;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;

/**
 * 
 * @author sword
 * @param <HttpServletContext>
 *
 */
@Component
@RestController
public class JwtUtil<HttpServletContext> {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SwdLogService loginLogService;
	
	@Autowired
	HttpServletRequest servletContext;
	
	@Autowired
	UserRepository userRepository;
	
	private String SECRET_KEY = "secret";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	@PostMapping("/oauth2/token")
	public JSONObject token(@RequestBody final SwdUser user) {
//		Logger.getLogger(this.getClass().toString()).info(user.getUsername());
		
		SwdUser dbUser = userRepository.findById(user.getUsername()).orElseGet(null);
		Assert.notNull(dbUser, "User do not exist!" + user.getUsername());
		//using BCryptPasswordEncoder to encrypt the password and compare
//		System.out.println(passwordEncoder.encode(user.getPassword()));
		Assert.isTrue(passwordEncoder.matches(user.getPassword(), dbUser.getPassword()), "Password do not match!");
		
		Map<String,Object> claims=new HashMap<String, Object>();
		claims.put("scope", "SCOPE_test:any");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("token", createToken(claims, user.getUsername()));
		
		loginLogService.loginLog(user.getUsername(), servletContext.getRemoteAddr());
		
		return jsonObject;
	}
}
