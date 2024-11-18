package com.example.todolist.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class TodoNotFoundException extends Exception{

	// 自訂例外(受檢例外)
	public TodoNotFoundException(String message) {
		super(message);
	}

	
}
