package com.todolist.todolist.mapper;

import com.todolist.todolist.dto.TodoRequest;
import com.todolist.todolist.dto.TodoResponse;
import com.todolist.todolist.entity.Activity;
import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.enums.TodoState;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TodoMapper {

    public Todo toEntity (TodoRequest todoRequest){
        return Todo.builder()
                .topic(todoRequest.getTopic())
                .todoState(TodoState.valueOf(todoRequest.getTodoState()))
                .activities(todoRequest.getActivities().stream()
                        .map(activity -> Activity.builder().activity(activity).build())
                        .collect(Collectors.toList()))
                .build();
    }

    public TodoResponse toDto (Todo todo){
        return TodoResponse.builder()
                .id(todo.getId())
                .topic(todo.getTopic())
                .status(todo.getTodoState().toString())
                .createdTime(todo.getAddedDate())
                .updatedTime(todo.getUpdatedDate())
                .activities(todo.getActivities().stream()
                        .map(Activity::getActivity)
                        .collect(Collectors.toList()))

                .build();
    }
}
