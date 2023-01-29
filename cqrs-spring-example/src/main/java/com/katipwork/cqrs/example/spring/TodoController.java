package com.katipwork.cqrs.example.spring;

import com.katipwork.cqrs.example.spring.command.create.CreateTodoCommand;
import com.katipwork.cqrs.example.spring.command.create.CreateTodoDTO;
import com.katipwork.cqrs.example.spring.command.create.TodoIdResponseDTO;
import com.katipwork.cqrs.core.CommandBus;
import com.katipwork.cqrs.example.spring.entity.Todo;
import com.katipwork.cqrs.example.spring.query.FindTodoQuery;
import com.katipwork.cqrs.example.spring.query.TodoListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Transactional
public class TodoController {
    private CommandBus commandBus;

    @Autowired
    public TodoController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping()
    public TodoIdResponseDTO createTodo(@RequestBody CreateTodoDTO createTodoDTO) {
        CreateTodoCommand command = new CreateTodoCommand(createTodoDTO.getDescription());
        Long id = commandBus.dispatch(command);
        return new TodoIdResponseDTO(id);
    }

    @GetMapping()
    public TodoListResponseDTO findTodo() {
        FindTodoQuery query = new FindTodoQuery();
        List<Todo> todos = commandBus.dispatch(query);
        return new TodoListResponseDTO(todos);
    }
}
