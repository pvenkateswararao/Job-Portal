package com.job.portal.jobPortal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.Job;
import com.job.portal.jobPortal.Service.JobInterface;

@RestController
@RequestMapping(path = "/job/api")
public class JobController {

	@Autowired
	JobInterface jobService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody Job job){
		return jobService.postJob(job);
	}
	
	@RequestMapping("/get/{id}")
	public Job getJobById(@PathVariable("id") long id) {
		return jobService.findById(id);
	}
	
	@RequestMapping("/getBySkillId/{id}")
	public List<Job> getBySkillId(@PathVariable("id") long id) {
		return jobService.findJobsBySkillId(id);
	}
	
	@PostMapping("/close/{id}")
	public ResponseEntity<String> close(@PathVariable long id){
		return jobService.close(id);
	}
	
	@RequestMapping("/list")
	public List<Job> getAll() {
		return jobService.findALl();
	}
	
}
