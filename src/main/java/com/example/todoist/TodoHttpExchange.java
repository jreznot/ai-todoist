package com.example.todoist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/todos")
public interface TodoHttpExchange {

    @GetMapping("/")
    List<TodoDTO> getAll();

    @GetMapping("/{id}")
    TodoDTO getById(@PathVariable Long id);

    @PostMapping("/")
    TodoDTO create(@RequestBody TodoDTO todoDTO);

    @PutMapping("/{id}")
    TodoDTO update(@PathVariable Long id, @RequestBody TodoDTO todoDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
