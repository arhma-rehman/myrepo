package com.okayjava.html.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.okayjava.html.model.User;
import com.okayjava.html.repo.UserRepo;

@Controller
public class IndexController {
    @Autowired
    UserRepo repo;
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute User user) {
		
		// validate 
		User u=repo.save(user);
		
		return "welcome";
	}
	@GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = repo.findAll();
        return ResponseEntity.ok(userList);
}
}
