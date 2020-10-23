package com.ywsoft.standalone.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		
		
		
		// if user is requesting a token, then response the toke, otherwise check the
		// access right
//		final String DEFAULT_TOKEN_ENDPOINT_URI = "/oauth2/token";
//		RequestMatcher tokenEndpointMatcher = new AntPathRequestMatcher(DEFAULT_TOKEN_ENDPOINT_URI,
//				HttpMethod.POST.name());
//
//		if (tokenEndpointMatcher.matches(request)) {
//
//			SwdUser user = new SwdUser();
//			user.setUsername("user");
//			response.getOutputStream().write(new JwtUtil().token(user).getBytes());
//			//update security context if logint successfully
//			String requestBodyStr = getRequestPostStr(request);
//			
//			JSONObject jo = null;
//			try {
//				jo = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(requestBodyStr);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(jo.getAsString("username"));
//			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//					userDetails, null, userDetails.getAuthorities());
//			usernamePasswordAuthenticationToken
//					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//			
//			return;
//		}

		
		
		
		//check if user access with token
		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
	
//	
//	public String getRequestPostStr(HttpServletRequest request)
//            throws IOException {
//        String charSetStr = request.getCharacterEncoding();
//        if (charSetStr == null) {
//            charSetStr = "UTF-8";
//        }
//        Charset charSet = Charset.forName(charSetStr);
//
//        return StreamUtils.copyToString(request.getInputStream(), charSet);
//    }
}
