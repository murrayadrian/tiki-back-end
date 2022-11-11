package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tikifake.entity.Role;
import com.tikifake.model.response.detail.IRoleDetail;
import com.tikifake.model.response.list.IRoleList;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("select r from Role r")
	public List<IRoleList> findAllDTO();
	
	@Query("select r from Role r where r.id= ?1")
	public IRoleDetail findByIdDTO(Long id);

	Boolean existsByName(String name);
	
	@Query("select count(r.name) > 0 from Role r where r.id != :id and r.name = :roleUpdate")
	public boolean isExistRoleUpdate(@Param("id") Long id, @Param("roleUpdate") String roleUpdate);
	
}
