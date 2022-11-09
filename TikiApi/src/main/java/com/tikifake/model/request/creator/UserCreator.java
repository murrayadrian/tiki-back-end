package com.tikifake.model.request.creator;

import com.tikifake.entity.Role;
import com.tikifake.entity.User;

public class UserCreator {

	private String name;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private Long roleId;
	
	public User convertModelToEntity(Role role) {
		User user = new User();
		user.setName(this.name);
		user.setAddress(this.address);
		user.setPhone(this.phone);
		user.setEmail(this.email);
		user.setRole(role);
		return user;
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
