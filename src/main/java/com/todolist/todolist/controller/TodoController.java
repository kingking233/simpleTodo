package com.todolist.todolist.controller;


import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TodoController {

    public final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService=todoService;
    }

    @GetMapping(path = "/getAll")
    public List<Todo> getAll(){
        return todoService.getAllList();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        try {
            todoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
