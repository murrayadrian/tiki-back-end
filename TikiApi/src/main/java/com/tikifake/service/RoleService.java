package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.RoleCreator;
import com.tikifake.model.request.update.RoleUpdate;
import com.tikifake.model.response.creator.RoleResponse;
import com.tikifake.model.response.detail.IRoleDetail;

public interface RoleService {

	public IRoleDetail getDetailById(Long roleId);

	public List<IRoleDetail> getAllRole();

	public RoleResponse save(RoleCreator roleCreator);

	public RoleResponse update(RoleUpdate roleUpdate);
}
