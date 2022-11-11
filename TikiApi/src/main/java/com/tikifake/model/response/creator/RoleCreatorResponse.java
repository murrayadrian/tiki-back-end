package com.tikifake.model.response.creator;

import com.tikifake.entity.Role;

public class RoleCreatorResponse {
	
	private Long id;
	
	private String name;
	
	public RoleCreatorResponse convertEntityToModel(Role role) {
		this.id = role.getId();
		this.name = role.getName();
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
