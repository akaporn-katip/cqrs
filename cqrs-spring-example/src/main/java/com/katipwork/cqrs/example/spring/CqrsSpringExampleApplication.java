package com.katipwork.cqrs.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.katipwork.cqrs.spring", "com.katipwork.cqrs.example"})
public class CqrsSpringExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(CqrsSpringExampleApplication.class, args);
	}
}
