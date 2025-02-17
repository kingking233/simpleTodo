package com.todolist.todolist.dto;

import com.todolist.todolist.enums.TodoState;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoRequest {
    private String topic;
    private List<String> activities;
    private String todoState;


}
