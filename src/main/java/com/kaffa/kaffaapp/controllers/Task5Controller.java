package com.kaffa.kaffaapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Task5Controller {
	
	@RequestMapping("/task5")
	public String viewUtc(){
		return "task5/task5";
	}

}
