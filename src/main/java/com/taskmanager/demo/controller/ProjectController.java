package com.taskmanager.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.demo.dto.ProjectRequest;
import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.service.ProjectService;



@RestController
@RequestMapping("/projects")

public class ProjectController {

    private final ProjectService projectService;
    public ProjectController(ProjectService projectService) {
    	this.projectService=projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/my-projects/{userId}")
    public List<Project> getUserProjects(@PathVariable Long userId) {
        return projectService.getUserProjects(userId);
    }
}
