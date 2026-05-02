package com.taskmanager.demo.dto;

import lombok.Data;

@Data
public class ProjectDashboardResponse {
    private Long projectId;
    private String projectName;

    private long totalTasks;
    private long completed;
    private long pending;
    private long overdue;
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getTotalTasks() {
		return totalTasks;
	}
	public void setTotalTasks(long totalTasks) {
		this.totalTasks = totalTasks;
	}
	public long getCompleted() {
		return completed;
	}
	public void setCompleted(long completed) {
		this.completed = completed;
	}
	public long getPending() {
		return pending;
	}
	public void setPending(long pending) {
		this.pending = pending;
	}
	public long getOverdue() {
		return overdue;
	}
	public void setOverdue(long overdue) {
		this.overdue = overdue;
	}
}