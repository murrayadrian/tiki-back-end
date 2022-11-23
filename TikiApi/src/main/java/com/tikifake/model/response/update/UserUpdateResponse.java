package com.tikifake.model.response.update;

import com.tikifake.entity.User;

public class UserUpdateResponse {
	private Long id;

	private String name;

	private String address;

	private String phone;

	private String email;

	private Long roleId;

	public UserUpdateResponse convertEntityToModel(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.address = user.getAddress();
		this.phone = user.getPhone();
		this.email = user.getEmail();
		this.roleId = user.getRole().getId();
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
