package com.taskmanager.demo.dto;

import lombok.Data;

@Data
public class UserDashboardResponse {
    private long totalTasks;
    private long completed;
    private long pending;
    private long overdue;
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