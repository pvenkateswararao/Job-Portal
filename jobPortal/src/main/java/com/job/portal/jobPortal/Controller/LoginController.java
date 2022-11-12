package com.job.portal.jobPortal.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Entity.Users;
import com.job.portal.jobPortal.Service.AdminInterface;
import com.job.portal.jobPortal.Service.FreelancerInterface;
import com.job.portal.jobPortal.Service.RecruiterInterface;
import com.job.portal.jobPortal.Service.UserInterface;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AdminInterface adminService;
	
	@Autowired
	RecruiterInterface recruiterService;
	
	@Autowired
	UserInterface userService;
	
	@Autowired
	FreelancerInterface freelancerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getRole(@PathVariable("id") String id){
		Users user=userService.getById(id);
		if(user!=null) {
			return new ResponseEntity<>(user.getRole(),HttpStatus.OK);
		}
		return new ResponseEntity<>("No Role Found",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<String> admin(@RequestBody Login user) {
		boolean a = adminService.validateUser(user);
		if (a) {
			return new ResponseEntity<>("Valid User", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("InValid User", HttpStatus.FORBIDDEN);

		}

	}
	
	@PostMapping("/recruiter")
	public ResponseEntity<String> recruiter(@RequestBody Login user) {
		boolean a = recruiterService.validateUser(user);
		if (a) {
			return new ResponseEntity<>("Valid User", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("InValid User", HttpStatus.FORBIDDEN);

		}

	}

	@PostMapping("/freelancer")
	public ResponseEntity<String> freelancer(@RequestBody Login user) {
		boolean a = freelancerService.validateUser(user);
		if (a) {
			return new ResponseEntity<>("Valid User", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("InValid User", HttpStatus.FORBIDDEN);

		}

	}
	
}
