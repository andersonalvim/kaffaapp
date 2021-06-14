package com.kaffa.kaffaapp.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kaffa.kaffaapp.models.ValidaCNPJ;

@Controller
public class Task1Controller {
	
	
	@RequestMapping(value="/task1", method=RequestMethod.GET)
	public String form() {
		return "task1/task1";
	}
	
	@RequestMapping(value="/task1", method=RequestMethod.POST)
	public String form(String cnpj, RedirectAttributes attributes) {
		
		Pattern p = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}");
		Matcher m = p.matcher(cnpj);  
		boolean b = m.matches();
		
		boolean resposta = ValidaCNPJ.isCNPJ(cnpj.replaceAll("[^0-9]", ""));
		
		if(resposta && b) {
			attributes.addFlashAttribute("mensagem", "It is valid");
		}else {
			attributes.addFlashAttribute("mensagem", "It is not valid");
		}
		
		return "redirect:task1";
	}

}
