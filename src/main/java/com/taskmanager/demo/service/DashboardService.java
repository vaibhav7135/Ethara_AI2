package com.taskmanager.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.demo.dto.ProjectDashboardResponse;
import com.taskmanager.demo.dto.UserDashboardResponse;
import com.taskmanager.demo.entity.Project;
import com.taskmanager.demo.entity.Task;
import com.taskmanager.demo.enums.Status;
import com.taskmanager.demo.repository.ProjectRepository;
import com.taskmanager.demo.repository.TaskRepository;


@Service
public class DashboardService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    
    public DashboardService(TaskRepository taskRepository,ProjectRepository projectRepository) {
    	this.taskRepository=taskRepository;
    	this.projectRepository=projectRepository;
    }

    // 🔥 Project Dashboard
    public ProjectDashboardResponse getProjectDashboard(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        List<Task> tasks = taskRepository.findByProjectId(projectId);

        ProjectDashboardResponse res = new ProjectDashboardResponse();
        res.setProjectId(project.getId());
        res.setProjectName(project.getName());

        res.setTotalTasks(tasks.size());

        res.setCompleted(tasks.stream()
                .filter(t -> t.getStatus() == Status.COMPLETED).count());

        res.setPending(tasks.stream()
                .filter(t -> t.getStatus() == Status.PENDING).count());

        res.setOverdue(tasks.stream()
                .filter(t -> t.getDueDate() != null &&
                        t.getDueDate().isBefore(LocalDate.now()) &&
                        t.getStatus() != Status.COMPLETED)
                .count());

        return res;
    }

    // 🔥 User Dashboard
    public UserDashboardResponse getUserDashboard(Long userId) {

        List<Task> tasks = taskRepository.findByAssignedToId(userId);

        UserDashboardResponse res = new UserDashboardResponse();

        res.setTotalTasks(tasks.size());

        res.setCompleted(tasks.stream()
                .filter(t -> t.getStatus() == Status.COMPLETED).count());

        res.setPending(tasks.stream()
                .filter(t -> t.getStatus() == Status.PENDING).count());

        res.setOverdue(tasks.stream()
                .filter(t -> t.getDueDate() != null &&
                        t.getDueDate().isBefore(LocalDate.now()) &&
                        t.getStatus() != Status.COMPLETED)
                .count());

        return res;
    }
}
