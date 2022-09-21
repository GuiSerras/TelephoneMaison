package com.cda.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.blog.model.VerificationToken;
import com.cda.blog.repository.VerificationTokenRepository;

@Service
public class VerificationTokenService {
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	public VerificationToken createVerificationToken(VerificationToken verificationToken) {
		return verificationTokenRepository.save(verificationToken);
		//return true;
	}
	
	public VerificationToken findByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
}
