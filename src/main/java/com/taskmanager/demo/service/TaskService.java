package com.taskmanager.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.demo.dto.TaskRequest;
import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.entity.Task;
import com.taskmanager.demo.entity.User;
import com.taskmanager.demo.enums.Status;
import com.taskmanager.demo.repository.ProjectRepository;
import com.taskmanager.demo.repository.TaskRepository;
import com.taskmanager.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    
    public TaskService(TaskRepository taskRepository,UserRepository userRepository,ProjectRepository projectRepository) {
    	this.taskRepository=taskRepository;
    	this.userRepository=userRepository;
    	this.projectRepository=projectRepository;
    }

    public Task createTask(TaskRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAssignedTo(user);
        task.setProject(project);
        task.setStatus(Status.PENDING);
        task.setDueDate(request.getDueDate());

        return taskRepository.save(task);
    }

    public Task updateStatus(Long taskId, Status status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Task> getUserTasks(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return taskRepository.findByAssignedTo(user);
    }
}