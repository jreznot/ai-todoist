package com.example.todoist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Todo update(Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        if (existingTodo == null) {
            return null;
        }
        existingTodo.setUser(todo.getUser());
        existingTodo.setDate(todo.getDate());
        existingTodo.setDone(todo.isDone());
        existingTodo.setText(todo.getText());
        return todoRepository.save(existingTodo);
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}

