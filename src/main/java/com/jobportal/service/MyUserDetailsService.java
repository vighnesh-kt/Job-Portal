package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobportal.entity.User;
import com.jobportal.entity.UserPrinciple;
import com.jobportal.dao.MyUserDao;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MyUserDao myUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=myUserDao.findByUsername(username);
		if(user==null) {
			System.out.println("Galat mat daal");
			throw new UsernameNotFoundException("Sorry not found");
		}
		return new UserPrinciple(user);
	}	
	
	

}
