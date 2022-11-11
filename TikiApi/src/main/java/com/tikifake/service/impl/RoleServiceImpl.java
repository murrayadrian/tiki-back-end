package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Role;
import com.tikifake.model.request.creator.RoleCreatorRequest;
import com.tikifake.model.request.update.RoleUpdateRequest;
import com.tikifake.model.response.creator.RoleCreatorResponse;
import com.tikifake.model.response.detail.IRoleDetail;
<<<<<<< HEAD
=======
import com.tikifake.model.response.exception.BadRequestException;
import com.tikifake.model.response.list.IRoleList;
import com.tikifake.model.response.update.RoleUpdateResponse;
>>>>>>> master
import com.tikifake.repository.RoleRepository;
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
	public List<IRoleList> getAllRole() {
		return roleRepository.findAllDTO();
	}

	@Override
	public RoleCreatorResponse save(RoleCreatorRequest roleCreator) {
		if (roleRepository.existsByName(roleCreator.getName())) {
			throw new BadRequestException("Role is already taken!");
		}
		Role roleRequest = roleCreator.convertModelToEntity();
		Role result = roleRepository.save(roleRequest);
		RoleCreatorResponse roleResponse = new RoleCreatorResponse().convertEntityToModel(result);
		return roleResponse;
	}

	@Override
	public RoleUpdateResponse update(RoleUpdateRequest roleUpdate) {
		boolean isExistRole = roleRepository.isExistRoleUpdate(roleUpdate.getId(), roleUpdate.getName());
		if (isExistRole) {
			throw new BadRequestException("Role is already taken!");
		}
		Role role = roleUpdate.convertToEntity();
		Role result = roleRepository.save(role);
		RoleUpdateResponse roleResponse = new RoleUpdateResponse().convertEntityToModel(result);
		return roleResponse;

	}

}
