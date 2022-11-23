package com.tikifake.model.response.update;

import com.tikifake.entity.Role;

public class RoleUpdateResponse {
	
	private Long id;
	
	private String name;
	
	public RoleUpdateResponse convertEntityToModel(Role role) {
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
