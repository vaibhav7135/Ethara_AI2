package com.taskmanager.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProjectRequest {
    private String name;
    private String description;
    private Long adminId;
    private List<Long> memberIds;   // 🔥 selected users
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public List<Long> getMemberIds() {
		return memberIds;
	}
	public void setMemberIds(List<Long> memberIds) {
		this.memberIds = memberIds;
	}
}
