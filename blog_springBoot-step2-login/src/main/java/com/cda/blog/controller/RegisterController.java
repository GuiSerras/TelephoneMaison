package com.cda.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.blog.model.User;
import com.cda.blog.model.VerificationToken;
import com.cda.blog.service.UserServices;
import com.cda.blog.service.VerificationTokenService;

@Controller
public class RegisterController {

	@Autowired
	private UserServices userServices;
	@Autowired
	private VerificationTokenService verificationTokenService;

	@GetMapping("/inscription")
	public String inscription(User user) {
		System.out.println(userServices.findByEmail("test@test.com").getRoles().size());
		return "/register";
	}

	@PostMapping("/inscription")
	public String register(@Valid User user, BindingResult bindingResult,
			@RequestParam("passwordConfirm") String passwordConfirm, Model model) 
					throws UnsupportedEncodingException, MessagingException {

		if(bindingResult.hasErrors()) {
			return "/register";
		}else if (passwordConfirm.equals(user.getPassword())) {
			String token = UUID.randomUUID().toString();
			User userRegistered = userServices.createUser(user);
			
			System.out.println(userRegistered.getIdUser());
			
			VerificationToken verificationToken = new VerificationToken(token,userRegistered);
			verificationTokenService.createVerificationToken(verificationToken);
			SendMail.sendMail("guiserras@gmail.com",token);
			return "registerSuccess";
		}else {
			model.addAttribute("passwordConfirm","Le mot de passe ne correspond pas.");
			return "/register";
		}
	}
	@GetMapping("/registerSuccess")
	public String registerSucccess(){
		return "registerSuccess";

	}
	
}
