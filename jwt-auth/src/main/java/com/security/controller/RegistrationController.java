package com.security.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Roles;
import com.security.entity.Users;
import com.security.repository.UsersRepository;

@RestController
@RequestMapping(path = "/register")
public class RegistrationController {

	@Autowired
	private UsersRepository repo;

	@PostMapping(path = "{app}/byUser")
	public String registerByUser(@PathVariable String app, @RequestParam String email, @RequestParam String fullName)
			throws Exception {
		if (this.repo.existsByEmail(email)) {
			throw new Exception("UserName already found");
		}
		Users user = new Users(email, fullName, true,
				Set.of(new Roles(Long.valueOf(repo.count() + 1L), "READER", app, true)));
		this.repo.save(user);
		return "Success";
	}

}
