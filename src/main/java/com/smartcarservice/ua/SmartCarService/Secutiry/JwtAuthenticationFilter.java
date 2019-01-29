package com.cjhrxS.ua.sec.Secutiry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import com.cjhrxS.ua.sec.Entity.LogEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.cjhrxS.ua.sec.Secutiry.SecurityConstant.SECRET;
import static com.cjhrxS.ua.sec.Secutiry.SecurityConstant.EXPIRATION_TIME;
import static com.cjhrxS.ua.sec.Secutiry.SecurityConstant.TOKEN_PREFIX;
import static com.cjhrxS.ua.sec.Secutiry.SecurityConstant.HEADER_STRING;



public class JwtAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager = authenticationManager;
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			LogEntity logEntity = new ObjectMapper().readValue(request.getInputStream(), LogEntity.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							logEntity.getUserName(),
							logEntity.getPassword(),
							new ArrayList<>()));
			
		} catch (IOException e) {
			
			throw new RuntimeException();
		}
		
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String token = JWT.create().withSubject(((User) authResult.getPrincipal()).getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.sign(HMAC512(SECRET.getBytes()));
		
		
			response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);	
		
		
	}
	
	

}
