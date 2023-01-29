package com.katipwork.cqrs.example.spring.command.create;

public class TodoIdResponseDTO {

    public TodoIdResponseDTO(Long id) {
        this.id = id;
    }
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
