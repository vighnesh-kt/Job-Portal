package com.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "my_admin")
public class Admin {
	
	@Id
	private Integer id;
	private String username;
	private String password;
	private String role;

}
