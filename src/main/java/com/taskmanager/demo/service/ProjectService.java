package com.taskmanager.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.demo.dto.ProjectRequest;
import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.entity.User;
import com.taskmanager.demo.repository.ProjectRepository;
import com.taskmanager.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    public ProjectService(UserRepository userRepository,
    		ProjectRepository projectRepository) {
this.projectRepository = projectRepository;
this.userRepository = userRepository;
}

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    // 🔥 YOUR METHOD GOES HERE
    public Project createProject(ProjectRequest request) {

        User admin = userRepository.findById(request.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        List<User> members = userRepository.findAllById(request.getMemberIds());

        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setCreatedBy(admin);
        project.setMembers(members);

        return projectRepository.save(project);
    }
    
    public List<Project> getUserProjects(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return projectRepository.findByMembersContaining(user);
    }
}