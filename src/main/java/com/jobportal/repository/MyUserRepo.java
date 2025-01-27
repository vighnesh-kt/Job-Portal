package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobportal.entity.User;


@Repository
public interface MyUserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
