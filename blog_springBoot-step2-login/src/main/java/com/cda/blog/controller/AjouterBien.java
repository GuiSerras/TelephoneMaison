package com.cda.blog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cda.blog.model.Bien;
import com.cda.blog.model.User;
import com.cda.blog.service.BienService;
import com.cda.blog.service.FileUploadUtil;
import com.cda.blog.service.UserServices;

@Controller
public class AjouterBien {
		
	@Autowired
	private BienService bienService;
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/dashBoard/ajouterBien")
	public String ajouterBien(){
		return "/admin/addBien";
	}	
	@PostMapping("/dashBoard/ajouterBien")
	public String ajouterBien(Principal principal, Bien bien, BindingResult bindingResult,@RequestParam("file") MultipartFile file) {
		 String message = "";
		    try {
		    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    	bien.setImage(fileName);
		    	User user = userServices.findByEmail(principal.getName());
		    	bien.setUser(user);
		    	Bien savedBien= bienService.createBien(bien);
		    	String uploadDir = "src/main/resources/static/img/bien-photos/" + savedBien.getIdBien();
		    	FileUploadUtil.saveFile(uploadDir, fileName, file);
		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
		      System.out.println(message);
		    } catch (Exception e) {
		      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		     System.out.println(e.getMessage());
		    }
		return "/admin/addBien";
	}
}
