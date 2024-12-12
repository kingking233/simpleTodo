package com.todolist.todolist.service;

import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.repo.TodoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepo  todoRepo;

    public TodoService( TodoRepo todoRepo){
        this.todoRepo=todoRepo;
    }

    //Getting all Todo list
    public List<Todo> getAllList(){
        return todoRepo.findAll();
    }

    //Adding a Todo
    public Todo addTodo(Todo todo){
        return todoRepo.save(todo);
    }

    //Deleting Todo by Id
    public void deleteById(Long id){
        todoRepo.deleteById(id);
    }
}
