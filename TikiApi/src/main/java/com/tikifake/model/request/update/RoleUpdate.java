package com.tikifake.model.request.update;

import com.tikifake.entity.Role;

public class RoleUpdate {
	private Long id;
	
	private String name;
	
	public Role convertToEntity() {
		Role role = new Role();
		role.setId(id);
		role.setName(name);
		return role;
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
