package com.example.todoist;

import java.time.LocalDate;

public class TodoDTO {
    
    private Long id;
    private String user;
    private LocalDate date;
    private boolean done;
    private String text;
    
    public TodoDTO() {
    }
    
    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.user = todo.getUser();
        this.date = todo.getDate();
        this.done = todo.isDone();
        this.text = todo.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
