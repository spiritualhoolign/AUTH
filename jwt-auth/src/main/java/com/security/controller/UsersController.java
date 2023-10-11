package com.security.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.repository.UsersRepository;

@RestController
@RequestMapping(path = "/user")
public class UsersController {
	
	@Autowired
	private UsersRepository repo;
	
	@GetMapping(path = "/getUserName")
	public Collection<? extends GrantedAuthority> getUserName(Long id){
		return this.repo.findById(id).get().getAuthorities();
	}
	
}
