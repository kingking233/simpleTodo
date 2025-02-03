package com.todolist.todolist.entity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String activity;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;


}
