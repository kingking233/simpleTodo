package com.todolist.todolist.repo;

import com.todolist.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Long> {
}
