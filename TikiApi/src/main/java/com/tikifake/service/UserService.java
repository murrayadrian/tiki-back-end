package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.UserCreatorRequest;
import com.tikifake.model.request.update.UserUpdateRequest;
import com.tikifake.model.response.creator.UserCreatorResponse;
import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.IUserList;
import com.tikifake.model.response.update.UserUpdateResponse;

public interface UserService {
	
	public IUserDetail getDetailById(Long userId);

	public List<IUserList> getAllUser();

	public UserCreatorResponse save(UserCreatorRequest userCreator);

	public UserUpdateResponse update(UserUpdateRequest userUpdate);
}
