package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.User;
import com.springboot.repository.UserRepository;

@RestController
public class WelcomeController {

	@Autowired
	UserRepository repo;
	@GetMapping("/")
	User welcome()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      return repo.findByName(name);
	}
}
