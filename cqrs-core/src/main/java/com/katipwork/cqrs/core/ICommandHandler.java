package com.katipwork.cqrs.core;

public interface ICommandHandler<TCommand, Result> {
    Result handle(TCommand command);
}