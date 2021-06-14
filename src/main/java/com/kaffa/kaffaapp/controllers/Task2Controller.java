package com.kaffa.kaffaapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kaffa.kaffaapp.models.IntersectionRectangles;


@Controller
public class Task2Controller {
	
	@RequestMapping(value="/task2", method=RequestMethod.GET)
	public String form() {
		return "task2/task2";
	}
	
	@RequestMapping(value="/task2", method=RequestMethod.POST)
	public String form(String r1x1, String r1y1, String r1x2, String r1y2, String r2x1, String r2y1, String r2x2, String r2y2, RedirectAttributes attributes) {
		
		int r1_x1 = Integer.parseInt(r1x1);
		int r1_y1 = Integer.parseInt(r1y1);
		int r1_x2 = Integer.parseInt(r1x2);
		int r1_y2 = Integer.parseInt(r1y2);
		
		int r2_x1 = Integer.parseInt(r2x1);
		int r2_y1 = Integer.parseInt(r2y1);
		int r2_x2 = Integer.parseInt(r2x2);
		int r2_y2 = Integer.parseInt(r2y2);
		
		boolean resposta = IntersectionRectangles.isThereIntersection(r1_x1, r1_y1, r1_x2, r1_y2, r2_x1, r2_y1, r2_x2, r2_y2);
		
		System.out.println(resposta);
		
		if(resposta) {
			attributes.addFlashAttribute("mensagem", "There is intersection");
		}else {
			attributes.addFlashAttribute("mensagem", "There is not intersection");
		}
		
		return "redirect:task2";
	}

}
