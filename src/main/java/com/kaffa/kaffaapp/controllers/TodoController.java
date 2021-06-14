package com.kaffa.kaffaapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kaffa.kaffaapp.models.Todo;
import com.kaffaapp.repository.TodoRepository;

@Controller
public class TodoController {
	
	@Autowired
	private TodoRepository tr;
	
	@RequestMapping(value="/registerTodo", method=RequestMethod.GET)
	public String form() {
		return "todo/formTodo";
	}
	
	@RequestMapping(value="/registerTodo", method=RequestMethod.POST)
	public String form(@Valid Todo todo, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Check the fields!");
			return "redirect:/registerTodo";
		}
		
		tr.save(todo);
		attributes.addFlashAttribute("mensagem", "Success To add Task!");
		return "redirect:/registerTodo";
	}
	
	@RequestMapping("/todos")
	public ModelAndView listaTodo() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Todo> todos = tr.findAll();
		mv.addObject("todos", todos);
		return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteTodo(long codigo) {
		Todo todo = tr.findByCodigo(codigo);
		tr.delete(todo);
		return "redirect:/todos";
	}
}
