package com.tikifake.model.request.creator;

import com.tikifake.entity.Role;

public class RoleCreator {

	private String name;

	public Role convertModelToEntity() {
		Role role = new Role();
		role.setName(this.name);
		return role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
