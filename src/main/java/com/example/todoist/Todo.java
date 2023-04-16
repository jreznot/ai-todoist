package com.example.todoist;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private LocalDate date;
    private boolean done;
    private String text;

    // Constructors, getters, and setters
    // ...

    public Todo() {}

    public Todo(String user, LocalDate date, boolean done, String text) {
        this.user = user;
        this.date = date;
        this.done = done;
        this.text = text;
    }

    public Todo(TodoDTO todoDTO) {
        this.user = todoDTO.getUser();
        this.date = todoDTO.getDate();
        this.done = todoDTO.isDone();
        this.text = todoDTO.getText();
    }

    public Long getId() {
        return id;
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
