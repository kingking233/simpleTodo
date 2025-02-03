package com.todolist.todolist.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoResponse {
    private Long id;
    private String topic;
    private List<String> activities;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String status;
}
