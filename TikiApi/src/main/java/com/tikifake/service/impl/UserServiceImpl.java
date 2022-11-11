package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Role;
import com.tikifake.entity.User;
import com.tikifake.model.request.creator.UserCreatorRequest;
import com.tikifake.model.request.update.UserUpdateRequest;
import com.tikifake.model.response.creator.UserCreatorResponse;
import com.tikifake.model.response.detail.IUserDetail;

import com.tikifake.model.response.exception.BadRequestException;
import com.tikifake.model.response.list.IUserList;
import com.tikifake.model.response.update.UserUpdateResponse;

import com.tikifake.repository.RoleRepository;
import com.tikifake.repository.UserRepository;
import com.tikifake.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public IUserDetail getDetailById(Long userId) {
		return userRepository.findByIdDTO(userId);
	}

	@Override
	public List<IUserList> getAllUser() {
		return userRepository.findAllDTO();
	}

	@Override
	public UserCreatorResponse save(UserCreatorRequest userCreator) {
		if (userRepository.existsByEmail(userCreator.getEmail())) {
			throw new BadRequestException("Email is already taken!");
		}
		if (userRepository.existsByPhone(userCreator.getPhone())) {
			throw new BadRequestException("Phone is already taken!");
		}
		Role role = roleRepository.findById(userCreator.getRoleId()).get();
		User user = userCreator.convertModelToEntity(role);
		User result = userRepository.save(user);
		UserCreatorResponse userResponse = new UserCreatorResponse().convertEntityToModel(result);
		return userResponse;
	}

	@Override
	public UserUpdateResponse update(UserUpdateRequest userUpdate) {
		boolean isExistEmail = userRepository.isExistEmail(userUpdate.getId(), userUpdate.getEmail());
		if (isExistEmail) {
			throw new BadRequestException("Email is already taken!");
		}
		boolean isExistPhone = userRepository.isExistPhone(userUpdate.getId(), userUpdate.getPhone());
		if (isExistPhone) {
			throw new BadRequestException("Phone is already taken!");
		}
		Role role = roleRepository.findById(userUpdate.getRoleId()).get();
		User user = userUpdate.convertToEntity(role);
		User result = userRepository.save(user);
		UserUpdateResponse userResponse = new UserUpdateResponse().convertEntityToModel(result);
		return userResponse;
	}

}
