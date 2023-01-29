package com.katipwork.cqrs.spring;

import com.katipwork.cqrs.core.ICommandHandler;

@CommandHandler(ExampleCommand.class)
public class ExampleCommandHandler implements ICommandHandler<ExampleCommand, String> {
    @Override
    public String handle(ExampleCommand exampleCommand) {
        return "Hello Command Handler";
    }
}
