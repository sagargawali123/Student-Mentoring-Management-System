package com.SMMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SMMS.entities.Admin;
import com.SMMS.entities.Student;
import com.SMMS.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	//to get user by email for validation
	@Query("select u from User u where u.userEmail =:email")
	public User findByEmail(@Param("email") String email);
	
	
	@Query("select u from User u where u.userEmail =:email and u.userPassword =:password")
	public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
