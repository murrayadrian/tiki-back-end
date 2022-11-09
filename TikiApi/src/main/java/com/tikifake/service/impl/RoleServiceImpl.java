package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Role;
import com.tikifake.model.request.creator.RoleCreator;
import com.tikifake.model.request.update.RoleUpdate;
import com.tikifake.model.response.creator.RoleResponse;
import com.tikifake.model.response.detail.IRoleDetail;
import com.tikifake.repositoty.RoleRepository;
import com.tikifake.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public IRoleDetail getDetailById(Long roleId) {
		return roleRepository.findByIdDTO(roleId);
	}

	@Override
	public List<IRoleDetail> getAllRole() {
		return roleRepository.findAllDTO();
	}

	@Override
	public RoleResponse save(RoleCreator roleCreator) {
		Role role = roleCreator.convertModelToEntity();
		Role result = roleRepository.save(role);
		RoleResponse roleResponse = new RoleResponse().convertEntityToModel(result);
		return roleResponse;
	}

	@Override
	public RoleResponse update(RoleUpdate roleUpdate) {
		Role role = roleUpdate.convertToEntity();
		Role result = roleRepository.save(role);
		RoleResponse roleResponse = new RoleResponse().convertEntityToModel(result);
		return roleResponse;
	}

}
