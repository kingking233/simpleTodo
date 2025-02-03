package com.todolist.todolist.controller;


import com.todolist.todolist.dto.TodoRequest;
import com.todolist.todolist.dto.TodoResponse;
import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
@Valid
public class TodoController {
    @Autowired

    public final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService=todoService;
    }

    @GetMapping(path = "/gettodos")
    public String test(){
        return "alive";
    }

    @GetMapping(path = "/todos")
    public List<TodoResponse> getAll(){
        return todoService.getAllList();
    }

    @PostMapping(path = "/todos")
    public TodoResponse createTodo(@Valid @RequestBody TodoRequest todoRequest) {
      return todoService.addTodo(todoRequest);
    }



    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        try {
            todoService.deleteById(id);
            return ResponseEntity.ok("Todo deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }

    //put
//    @PutMapping("/todos/{id}")
//    public ResponseEntity<String> updateTodo(@Valid @PathVariable Long id, @RequestBody Todo todoDetails){
//        try {
//            Todo todo = todoService.updateTodo(id,todoDetails);
//            return ResponseEntity.ok(id+ " "+ "has been updated");
//        } catch (RuntimeException e) {
//            return ResponseEntity.ok("an error happened ");
//        }
//    }



    //Column Validation
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;}
}
