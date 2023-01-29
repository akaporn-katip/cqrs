package com.katipwork.cqrs.example.spring.command.create;

public class CreateTodoDTO {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
