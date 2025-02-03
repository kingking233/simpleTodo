package com.todolist.todolist.repo;

import com.todolist.todolist.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
