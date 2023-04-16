package com.example.todoist;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todoDTO) {
        Todo createdTodo = todoService.create(new Todo(todoDTO));
        return new ResponseEntity<>(new TodoDTO(createdTodo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> findAll() {
        List<Todo> todos = todoService.findAll();
        List<TodoDTO> todoDTOs = todos.stream().map(TodoDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(todoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> findById(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new TodoDTO(todo), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        Todo updatedTodo = todoService.update(id, new Todo(todoDTO));
        if (updatedTodo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new TodoDTO(updatedTodo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
