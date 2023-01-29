package com.katipwork.cqrs.core;

import java.util.HashMap;
import java.util.Map;

public class CommandBus implements ICommandBus {
    private final Map<Class<? extends ICommand>, ICommandHandler> handlers = new HashMap<>();

    @Override
    public void register(Class<? extends ICommand> commandType, ICommandHandler handler) {
        this.handlers.put(commandType, handler);
    }

    @Override
    public <T> T dispatch(ICommand command) {
        ICommandHandler handler = handlers.get(command.getClass());
        if (handler != null) {
            return (T) handler.handle(command);
        } else {
            throw new IllegalArgumentException("No handler registered for command type: " + command.getClass());
        }
    }

    public int size() {
        return handlers.size();
    }
}
