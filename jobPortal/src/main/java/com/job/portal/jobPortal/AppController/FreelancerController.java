package com.job.portal.jobPortal.AppController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.Freelancer;
import com.job.portal.jobPortal.Entity.Job;
import com.job.portal.jobPortal.Service.FreelancerInterface;
import com.job.portal.jobPortal.Service.JobInterface;

@RestController
@RequestMapping(path = "/freelancer/api")
public class FreelancerController {

	
	@Autowired
	FreelancerInterface freelancerService;
	
	@Autowired
	JobInterface jobService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody Freelancer user){
		return freelancerService.save(user);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody Freelancer user){
		return freelancerService.save(user);
	}
	
	@GetMapping("/get/{id}")
	public Freelancer getById(@PathVariable("id") long id) {
		return freelancerService.findById(id);
	}
	
	@RequestMapping("/listJob")
	public List<Job> getJobById() {
		return jobService.findALl();
	}
	
}
