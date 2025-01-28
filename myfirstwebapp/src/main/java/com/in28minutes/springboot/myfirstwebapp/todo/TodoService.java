package com.in28minutes.springboot.myfirstwebapp.todo;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount, "Vishwa", "Learn Springboot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Vishwa", "Learn DEv", LocalDate.now().plusYears(2), false));
		
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone ) {
		
		 Todo todo= new Todo(++todosCount, userName, description,targetDate, isDone);
		 todos.add(todo);
		
		
	}
}
