package com.job.portal.jobPortal.AppController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.Recruiter;
import com.job.portal.jobPortal.Service.RecruiterInterface;

@RestController
@RequestMapping("/recruiter/api")
public class RecruiterController {

	@Autowired
	RecruiterInterface recruiterService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody Recruiter user){
		return recruiterService.save(user);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody Recruiter user){
		return recruiterService.save(user);
	}
	
	@GetMapping("/get/{id}")
	public Recruiter getById(@PathVariable("id") long id) {
		return recruiterService.findById(id);
	}
	
	
	
}
