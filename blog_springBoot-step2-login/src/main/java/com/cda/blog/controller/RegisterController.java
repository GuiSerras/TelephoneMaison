package com.cda.blog.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cda.blog.model.User;
import com.cda.blog.service.UserServices;

@Controller
public class RegisterController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("/inscription")
	public String inscription(User user) {
		
		return "/register";
	}
	
	@PostMapping("/inscription")
    public String register(@Valid User user, BindingResult bindingResult, Model model) throws UnsupportedEncodingException, MessagingException {
		
        if(bindingResult.hasErrors()) {
        	 return "/register";
        }else {
        

     userServices.createUser(user);
        return "redirect:/";
    }
	}
}
