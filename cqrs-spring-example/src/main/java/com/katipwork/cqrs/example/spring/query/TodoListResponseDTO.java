package com.katipwork.cqrs.example.spring.query;

import com.katipwork.cqrs.example.spring.entity.Todo;

import java.util.List;

public class TodoListResponseDTO {
    private List<Todo> todos;
    public TodoListResponseDTO(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
