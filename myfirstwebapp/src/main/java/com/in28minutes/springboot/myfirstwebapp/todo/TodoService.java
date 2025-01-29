package com.in28minutes.springboot.myfirstwebapp.todo;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

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
		
		Predicate<? super Todo> predicate = todo->todo.getUserName().equals(username);

		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone ) {
		
		 Todo todo= new Todo(++todosCount, userName, description,targetDate, isDone);
		 todos.add(todo);
	}
	
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo->todo.getId()== id;
		todos.removeIf(predicate);
	}

	public Todo findByid(int id) {
		Predicate<? super Todo> predicate = todo->todo.getId()== id;
		Todo todo=	todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {

		deleteById(todo.getId());
		todos.add(todo);
	}
}
