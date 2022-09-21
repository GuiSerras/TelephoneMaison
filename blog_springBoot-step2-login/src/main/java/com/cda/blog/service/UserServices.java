package com.cda.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cda.blog.model.User;
import com.cda.blog.repository.UserRepository;


@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;
	
	
	public User findByEmail(String email) {
        return  userRepo.findByEmail(email);
    }
	
	//Je crée une methode C du CRUD
	
	public User createUser(User user) {
		
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		user.setPassword(crypt.encode(user.getPassword()));
		
		return userRepo.save(user);
		//return true;
	}
	public User updateUser(User user) {
	
		return userRepo.save(user);
		//return true;
	}
}
