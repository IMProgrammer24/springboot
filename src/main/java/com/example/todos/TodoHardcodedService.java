package com.example.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos= new ArrayList<>();
	private static int idcounter=0;
	
	static {
		todos.add(new Todo(++idcounter, "sunny", "Expert in Dance", new Date(), false));
		todos.add(new Todo(++idcounter, "sunny", "Angular Beginner 2", new Date(), false));
		todos.add(new Todo(++idcounter, "sunny", "Spring Boot Expert", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(int id) {
		Todo todo = findById(id);
		if(todo==null) {
			return null;
		}
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}
	
	public Todo findById(int id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
}
