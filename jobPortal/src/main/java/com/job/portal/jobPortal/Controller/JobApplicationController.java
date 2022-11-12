package com.job.portal.jobPortal.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.JobApplication;
import com.job.portal.jobPortal.Service.JobApplicationInterface;


@RestController
@RequestMapping(path = "/job/application/api")
public class JobApplicationController {

	@Autowired
	JobApplicationInterface jobAppService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody JobApplication application){
		return jobAppService.applyJob(application);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		return jobAppService.remove(id);
	}
	
	@GetMapping("/get/{id}")
	public JobApplication getById(@PathVariable("id") long id){
		return jobAppService.findById(id);
	}
	
	
	
}

