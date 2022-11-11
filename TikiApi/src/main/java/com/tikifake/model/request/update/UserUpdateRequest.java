package com.tikifake.model.request.update;

import com.tikifake.entity.Role;
import com.tikifake.entity.User;

public class UserUpdateRequest {
	
	private Long id;

	private String name;

	private String address;

	private String phone;

	private String email;

	private Long roleId;
	
	public User convertToEntity(Role role) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setRole(role);
		return user;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
