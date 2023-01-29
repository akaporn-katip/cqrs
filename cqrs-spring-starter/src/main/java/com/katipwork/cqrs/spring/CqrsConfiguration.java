package com.katipwork.cqrs.spring;

import com.katipwork.cqrs.core.CommandBus;
import com.katipwork.cqrs.core.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
public class CqrsConfiguration {
    private ApplicationContext applicationContext;

    @Autowired
    public CqrsConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    @Scope("singleton")
    public CommandBus commandBusRegistration() {
        CommandBus commandBus = new CommandBus();
        return registration(commandBus);
    }

    protected CommandBus registration(CommandBus commandBus) {
        Map<String, Object> handlers = applicationContext.getBeansWithAnnotation(CommandHandler.class);
        for (Object handler : handlers.values()) {
            commandBus.register(handler.getClass().getAnnotation(CommandHandler.class).value(), (ICommandHandler) handler);
        }
        return commandBus;
    }
}
