package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Role;
import com.tikifake.entity.User;
import com.tikifake.model.request.creator.UserCreator;
import com.tikifake.model.request.update.UserUpdate;
import com.tikifake.model.response.creator.UserResponse;
import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.repositoty.RoleRepository;
import com.tikifake.repositoty.UserRepository;
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
	public List<IUserDetail> getAllUser() {
		return userRepository.findAllDTO();
	}

	@Override
	public UserResponse save(UserCreator userCreator) {
		Role role = roleRepository.findById(userCreator.getRoleId()).get();
		User user = userCreator.convertModelToEntity(role);
		User result = userRepository.save(user);
		UserResponse userResponse = new UserResponse().convertEntityToModel(result);
		return userResponse;
	}

	@Override
	public UserResponse update(UserUpdate userUpdate) {
		Role role = roleRepository.findById(userUpdate.getRoleId()).get();
		User user = userUpdate.convertToEntity(role);
		User result = userRepository.save(user);
		UserResponse userResponse = new UserResponse().convertEntityToModel(result);
		return userResponse;
	}

}
