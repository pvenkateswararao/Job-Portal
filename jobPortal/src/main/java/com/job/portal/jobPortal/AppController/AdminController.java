package com.job.portal.jobPortal.AppController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.Admin;
import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Service.AdminInterface;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminInterface adminService;

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Login user) {
		boolean a = adminService.validateUser(user);
		if (a) {
			return new ResponseEntity<>("Valid User", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("InValid User", HttpStatus.FORBIDDEN);

		}

	}

	@PostMapping("/insert")
	public ResponseEntity<String> createAdmin(@Valid @RequestBody Admin admin) {
		adminService.save(admin);
		return new ResponseEntity<>("Admin Account Created", HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public Admin getAdminById(@PathVariable("id") long id) {
		return adminService.findById(id);
	}

}
