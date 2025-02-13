package com.jobportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.User;
import com.jobportal.repository.MyUserRepo;


@Service
public class MyUserDao {
	
	@Autowired
	private MyUserRepo myUserRepo;

	public User findByUsername(String string) {
		// TODO Auto-generated method stub
		return myUserRepo.findByUsername(string);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return myUserRepo.save(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return myUserRepo.findAll();
	}

}
