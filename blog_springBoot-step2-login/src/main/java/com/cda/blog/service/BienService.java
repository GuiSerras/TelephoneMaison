package com.cda.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.blog.model.Bien;
import com.cda.blog.repository.BienRepository;

@Service
public class BienService  {
	@Autowired
	private BienRepository bienRepository;

	public Bien createBien(Bien bien) {

		return bienRepository.save(bien);
	}
}
