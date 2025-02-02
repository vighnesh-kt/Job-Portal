package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.User;
import com.jobportal.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getusers")
	public List<User> getUser() {
		return userService.getUsers();
	}
}
