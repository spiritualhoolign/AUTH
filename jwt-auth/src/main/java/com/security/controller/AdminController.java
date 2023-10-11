package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Users;
import com.security.repository.UsersRepository;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	private UsersRepository repo;

	@GetMapping(path = "/getUsers")
	public List<Users> getUsers() {
		return this.repo.findAll();
	}
}
