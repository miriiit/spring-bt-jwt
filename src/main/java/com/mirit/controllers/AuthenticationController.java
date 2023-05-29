package com.mirit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mirit.models.request.AuthenticationRequest;
import com.mirit.models.request.RegisterRequest;

import com.mirit.models.response.AuthenticationResponse;
import com.mirit.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private final AuthenticationService authService;

	
	@Autowired
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@GetMapping("")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("White list end points are /authenticate and /register");
	}
	
//	@PostMapping("/register")
//	
//	public ModelAndView registerPage() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("obj", new RegisterRequest("azhar", "hussnain", "azhs.002@gmail.com", "123"));
//		mv.setViewName("register");
//		return mv;
//	}
//	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest req) {
		return ResponseEntity.ok(authService.register(req));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest req) {
		return ResponseEntity.ok(authService.authenticate(req));
	}

}
