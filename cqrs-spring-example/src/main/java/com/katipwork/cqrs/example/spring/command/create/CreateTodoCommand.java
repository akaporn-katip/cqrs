package com.katipwork.cqrs.example.spring.command.create;

import com.katipwork.cqrs.core.Command;

public class CreateTodoCommand extends Command {
    String description;

    public CreateTodoCommand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
