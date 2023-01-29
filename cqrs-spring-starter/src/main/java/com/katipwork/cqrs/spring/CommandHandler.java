package com.katipwork.cqrs.spring;

import com.katipwork.cqrs.core.Command;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface CommandHandler {
    Class<? extends Command> value();
}
