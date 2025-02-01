package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jobportal.entity.User;


@Repository
public interface MyUserRepo extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.email=:email")
	User findByUsername(@Param ("email") String email);
	

}
