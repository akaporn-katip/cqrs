package com.katipwork.cqrs.example.spring.command.create;

import com.katipwork.cqrs.core.ICommandHandler;
import com.katipwork.cqrs.example.spring.entity.Todo;
import com.katipwork.cqrs.example.spring.repository.TodoRepository;
import com.katipwork.cqrs.spring.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

@CommandHandler(CreateTodoCommand.class)
public class CreateTodoService implements ICommandHandler<CreateTodoCommand, Long> {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Long handle(CreateTodoCommand createTodoCommand) {
        Todo todo = new Todo();
        todo.setDescription(createTodoCommand.getDescription());
        todoRepository.save(todo);
        return todo.getId();
    }
}
