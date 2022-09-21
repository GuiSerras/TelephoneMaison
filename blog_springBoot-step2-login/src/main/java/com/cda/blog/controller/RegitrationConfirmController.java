package com.cda.blog.controller;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.cda.blog.model.User;
import com.cda.blog.model.VerificationToken;
import com.cda.blog.service.UserServices;
import com.cda.blog.service.VerificationTokenService;

@Controller
public class RegitrationConfirmController {

	@Autowired
	private VerificationTokenService verificationTokenService;
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/regitrationConfirm")
	public String confirmRegistration(WebRequest request,@RequestParam("token") String token) {
		Locale locale = request.getLocale();
		VerificationToken verificationToken = verificationTokenService.findByToken(token);
	    if (verificationToken == null) {
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    }
		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();
		
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    } 
		user.setEnabled(true); 
	    System.out.println(userServices.createUser(user).isEnabled());
	    
		return "regitrationConfirm";
	}
}
