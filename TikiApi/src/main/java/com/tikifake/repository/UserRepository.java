package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

import com.tikifake.entity.User;
import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.IUserList;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u")
	public List<IUserList> findAllDTO();
	
	@Query("select u from User u where u.id= ?1")
	public IUserDetail findByIdDTO(Long id);
	
	Boolean existsByEmail(String email);
	
	Boolean existsByPhone(String phone);
	
	@Query("select count(u.email) > 0 from User u where u.id != :id and u.email = :emailUpdate")
	public boolean isExistEmail(@Param("id") Long id, @Param("emailUpdate") String emailUpdate);
	
	@Query("select count(u.phone) > 0 from User u where u.id != :id and u.phone = :phoneUpdate")
	public boolean isExistPhone(@Param("id") Long id, @Param("phoneUpdate") String phoneUpdate);
=======

import com.tikifake.entity.User;
import com.tikifake.model.response.detail.IUserDetail;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u")
	public List<IUserDetail> findAllDTO();

	@Query("select u from User u where u.id= ?1")
	public IUserDetail findByIdDTO(Long id);
>>>>>>> master
}
