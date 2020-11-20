package com.ywsoft.standalone.framework;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.repository.UserRepository;
import com.ywsoft.standalone.framework.service.ApiResponse;
import com.ywsoft.standalone.framework.service.ApiResponseError;
import com.ywsoft.standalone.framework.service.ApiResponseFactory;
import com.ywsoft.standalone.framework.service.ApiResponseNormal;
import com.ywsoft.standalone.framework.service.HttpBusinessStatusCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	@Autowired
	ApiResponseError apiResponseError;

	@Autowired
	ApiResponseNormal apiResponseNormal;

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
	public ApiResponse token(@RequestBody final SwdUser user) {
		Optional<SwdUser> opticalUser = userRepository.findById(user.getUsername());
		if (opticalUser.isEmpty())
			return HttpBusinessStatusCode.USER_NOT_FOUND;
		SwdUser swdUser = opticalUser.get();
		if (!passwordEncoder.matches(user.getPassword(), swdUser.getPassword()))
			return HttpBusinessStatusCode.PASSWORD_NOT_MATCH;
		Map<String, Object> claims = new HashMap<String, Object>();
		loginLogService.loginLog(user.getUsername(), servletContext.getRemoteAddr());
		return ApiResponseFactory.getNormalReponse(createToken(claims, user.getUsername()));
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "用户不存在")
	public static class UserNotFoundException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public UserNotFoundException(String message) {
			super(message);
		}
	}

}
