package com.taskmanager.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.demo.dto.ProjectDashboardResponse;
import com.taskmanager.demo.dto.UserDashboardResponse;
import com.taskmanager.demo.service.DashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService) {
    	this.dashboardService=dashboardService;
    }

    @GetMapping("/project/{projectId}")
    public ProjectDashboardResponse getProjectDashboard(@PathVariable Long projectId) {
        return dashboardService.getProjectDashboard(projectId);
    }

    @GetMapping("/user/{userId}")
    public UserDashboardResponse getUserDashboard(@PathVariable Long userId) {
        return dashboardService.getUserDashboard(userId);
    }
}