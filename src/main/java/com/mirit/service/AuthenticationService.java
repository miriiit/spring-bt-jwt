package com.mirit.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mirit.configurations.JwtService;
import com.mirit.models.Role;
import com.mirit.models.User;
import com.mirit.models.request.AuthenticationRequest;
import com.mirit.models.request.RegisterRequest;
import com.mirit.models.response.AuthenticationResponse;

@Service
public class AuthenticationService {

	
	
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;
	

	
	@Autowired
	public AuthenticationService(JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authManager) {
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;		
		this.authManager = authManager;
		jwtService.userListMap.put("azhs.006@gmail.com", new User(UUID.randomUUID(), "Azhar", "Hussnain", "azhs.006@gmail.com", passwordEncoder.encode("123"), Role.ADMIN));
	}

	public AuthenticationResponse register(RegisterRequest req) {
		User stUser = jwtService.userListMap.get(req.getEmail());
		if(stUser == null) {
			stUser = new User(UUID.randomUUID(), req.getFirstname(), req.getLastname(), req.getEmail(), passwordEncoder.encode(req.getPassword()), Role.ADMIN);
			jwtService.userListMap.put(stUser.getEmail(), stUser);
		}
		
		var jwtToken = jwtService.generatetoken(stUser);
		return new AuthenticationResponse(jwtToken);
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest req) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
		
		User stUser = 	jwtService.userListMap.get(req.getEmail());
		
		var jwtToken = jwtService.generatetoken(stUser);
		return new AuthenticationResponse(jwtToken);
	}
	
}
