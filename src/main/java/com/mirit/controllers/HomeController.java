package com.mirit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mirit.models.Ground;
import com.mirit.service.GroundService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

	private GroundService groundService;

	@Autowired
	public HomeController(GroundService groundService) {
		this.groundService = groundService;
	}

	@GetMapping("/home")
	public ResponseEntity<String> home() {

//		 HttpSession session = req.getSession();
//		 ModelAndView mv = new ModelAndView();
//		 mv.addObject("obj", ground);

//		 session.setAttribute("name", "Azhar sab");
//		 mv.setViewName("index");
		return ResponseEntity.ok("Hello From Secured End Point");
	}

	@GetMapping("/addGround")
	public ModelAndView addGround(Ground ground) {

		var status = groundService.saveGround(ground);

		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", status);
		mv.setViewName("index");
		return mv;
	}

}
