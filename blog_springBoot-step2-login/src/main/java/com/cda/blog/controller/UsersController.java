package com.cda.blog.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.blog.model.User;
import com.cda.blog.service.UserServices;

@Controller
public class UsersController {

	@Autowired
	private UserServices userServices;

	@GetMapping("/users")
	public String users(Principal principal, Model model){
		User user = userServices.findByEmail(principal.getName());
		model.addAttribute("user",user);

		return "users";
	}
	@PostMapping("/users")
	public String users(Principal principal, @ModelAttribute User user,@RequestParam String action){
		User userLogin =  userServices.findByEmail(principal.getName());
		switch (action) {
		case "nom" :{
			
			userLogin.setNom(user.getNom());
			break;
		} 
		case "prenom" :{
			userLogin.setPrenom(user.getPrenom());
			break;
		} 
		case "email" :{
			userLogin.setEmail(user.getEmail());
			break;
		}
		case "dateN" :{
			userLogin.setDateN(user.getDateN());
			break;
		}
		case "tel" :{
			userLogin.setTelephone(user.getTelephone());
			break;
		}
		default :{
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		}
		userServices.updateUser(userLogin);
		return "/users";
	}
}