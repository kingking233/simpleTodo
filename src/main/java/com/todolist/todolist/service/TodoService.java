package com.todolist.todolist.service;

import com.todolist.todolist.dto.TodoRequest;
import com.todolist.todolist.dto.TodoResponse;
import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.mapper.TodoMapper;
import com.todolist.todolist.repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepo  todoRepo;
    private final TodoMapper todoMapper;

    public TodoService(TodoRepo todoRepo, TodoMapper todoMapper) {
        this.todoRepo = todoRepo;
        this.todoMapper = todoMapper;
    }

    //Getting all Todo list
    public List<TodoResponse> getAllList(){
        return todoRepo.findAll().stream()
                .map(todoMapper::toDto)
                .collect(Collectors.toList());
    }

    //Adding a Todo
    public TodoResponse addTodo(TodoRequest todoRequest){
        Todo todo = todoMapper.toEntity(todoRequest);
        Todo savedTodo = todoRepo.save(todo);
        return todoMapper.toDto(savedTodo);
    }

    //Deleting Todo by Id
    public void deleteById(Long id){
        todoRepo.deleteById(id);
    }



//    public Todo updateTodo(Long id, Todo todoDetails) {
//        Todo todo = todoRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Todo not found"));
//
//        todo.setTopic(todoDetails.getTopic());
//        todo.setActivities(todoDetails.getActivities());
//        return todoRepo.save(todo);
//    }

}
