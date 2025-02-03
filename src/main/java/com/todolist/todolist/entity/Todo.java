package com.todolist.todolist.entity;
import com.todolist.todolist.enums.TodoState;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotNull(message = "Input a topic")
    @Size(min = 2,max = 200, message = "Topic must be more than 2 characters ")
    private String topic;


    private TodoState todoState;

    @NotNull(message = "Input an activity")
    @NotEmpty(message = "Input an activity")
    @OneToMany(mappedBy = "todo")
    private List<Activity> activities;

    @CreationTimestamp
    private LocalDateTime addedDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;


}
