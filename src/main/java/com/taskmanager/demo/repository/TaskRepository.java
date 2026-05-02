package com.taskmanager.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.demo.entity.Task;
import com.taskmanager.demo.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedTo(User user);
    List<Task> findByProjectId(Long projectId);

    List<Task> findByAssignedToId(Long userId);
}