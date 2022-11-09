package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.Role;
import com.tikifake.model.response.detail.IRoleDetail;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("select r from Role r")
	public List<IRoleDetail> findAllDTO();

	@Query("select r from Role r where r.id= ?1")
	public IRoleDetail findByIdDTO(Long id);

}
