package com.ikeda.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RentalSystemController {

	
	/*@GetMapping(value = "/home")
	public String toHome() {
		return "index";
	}*/
	
	// RentalSystemController
	@GetMapping("/dashboard") // <- URLを変更
	public String toDashboard() {
	    return "dashboard";
	}
	
	
	
}
