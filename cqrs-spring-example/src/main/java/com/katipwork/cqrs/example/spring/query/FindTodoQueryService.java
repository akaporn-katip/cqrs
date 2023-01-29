package com.katipwork.cqrs.example.spring.query;

import com.katipwork.cqrs.core.ICommandHandler;
import com.katipwork.cqrs.example.spring.entity.Todo;
import com.katipwork.cqrs.example.spring.repository.TodoRepository;
import com.katipwork.cqrs.spring.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CommandHandler(FindTodoQuery.class)
public class FindTodoQueryService implements ICommandHandler<FindTodoQuery, List<Todo>> {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> handle(FindTodoQuery findTodoQuery) {
        return todoRepository.findAll();
    }
}
