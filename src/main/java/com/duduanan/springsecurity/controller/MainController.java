package com.duduanan.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home(){	
		return "index";
	}
	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {	
		 return "login-form";
	}
	@GetMapping("/leaders")
	public String showLeaders(){
		return "leaders";
	}
	@GetMapping("access-denied")
	public String accessDenied(){
		return "access-denied";
	}
}
