package com.katipwork.cqrs.core;

public interface ICommandBus {
    void register(Class<?  extends ICommand> commandType, ICommandHandler handler);
    <T> T dispatch(ICommand ICommand);
}
