package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// /list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
	List<Todo> todos=todoService.findByUsername("Vishwa");
	model.addAttribute("todos",todos);
		return "listTodos";
	}	
	
	//Get Post 
	@RequestMapping(value="add-todo", method= RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= (String) model.get("name");
		Todo todo= new Todo(0,username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}	

	//Get Post 
	@RequestMapping(value="add-todo", method= RequestMethod.POST)
	public String addNewTodo( ModelMap model, @Valid Todo todo, BindingResult result){
		
		if (result.hasErrors()) {
			return "todo";
		}
				
		String username= (String) model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
}
