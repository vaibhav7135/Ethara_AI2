package com.taskmanager.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.entity.User;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findByMembersContaining(User user);
}
