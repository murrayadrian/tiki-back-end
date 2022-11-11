package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.RoleCreatorRequest;
import com.tikifake.model.request.update.RoleUpdateRequest;
import com.tikifake.model.response.creator.RoleCreatorResponse;
import com.tikifake.model.response.detail.IRoleDetail;
import com.tikifake.model.response.list.IRoleList;
import com.tikifake.model.response.update.RoleUpdateResponse;

public interface RoleService {

	public IRoleDetail getDetailById(Long roleId);

	public List<IRoleList> getAllRole();

	public RoleCreatorResponse save(RoleCreatorRequest roleCreator);

	public RoleUpdateResponse update(RoleUpdateRequest roleUpdate);
}
