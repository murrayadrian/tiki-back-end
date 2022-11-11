package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.User;
import com.tikifake.model.response.detail.IUserDetail;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u")
	public List<IUserDetail> findAllDTO();

	@Query("select u from User u where u.id= ?1")
	public IUserDetail findByIdDTO(Long id);
}
