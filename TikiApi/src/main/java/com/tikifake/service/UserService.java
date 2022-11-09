package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.UserCreator;
import com.tikifake.model.request.update.UserUpdate;
import com.tikifake.model.response.creator.UserResponse;
import com.tikifake.model.response.detail.IUserDetail;

public interface UserService {
	
	public IUserDetail getDetailById(Long userId);

	public List<IUserDetail> getAllUser();

	public UserResponse save(UserCreator userCreator);

	public UserResponse update(UserUpdate userUpdate);
}
