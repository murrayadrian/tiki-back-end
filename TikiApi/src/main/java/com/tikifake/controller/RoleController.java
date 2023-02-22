package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.RoleCreatorRequest;
import com.tikifake.model.request.update.RoleUpdateRequest;
import com.tikifake.model.response.creator.RoleCreatorResponse;
import com.tikifake.model.response.detail.IRoleDetail;
import com.tikifake.model.response.list.IRoleList;
import com.tikifake.model.response.update.RoleUpdateResponse;
import com.tikifake.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("/getRoleById/{id}")
	public ResponseEntity<Object> getRoleById(@PathVariable(value = "id") Long roleId) {
		IRoleDetail role = roleService.getDetailById(roleId);
		if (role== null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role Not Found");
		}
		return ResponseEntity.ok().body(role);
	}

	@GetMapping("/getAllRole")
	public ResponseEntity<Object> getAllRole() {
		List<IRoleList> roles = roleService.getAllRole();
		return ResponseEntity.ok().body(roles);
	}

	@PostMapping("/addRole")
	public ResponseEntity<Object> addRole(@RequestBody RoleCreatorRequest roleCreator) {
		RoleCreatorResponse roleResponse = roleService.save(roleCreator);
		return ResponseEntity.ok().body(roleResponse);
	}

	@PutMapping("/updateRole")
	public ResponseEntity<Object> updateRole(@RequestBody RoleUpdateRequest roleUpdate) {
		RoleUpdateResponse roleResponse = roleService.update(roleUpdate);
		return ResponseEntity.ok().body(roleResponse);
	}
}
