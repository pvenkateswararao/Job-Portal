package com.job.portal.jobPortal.Controller;

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

import com.job.portal.jobPortal.Entity.Feedback;
import com.job.portal.jobPortal.Service.FeedbackInterface;

@RestController
@RequestMapping(path = "/feedback/api")
public class FeedbackController {

	@Autowired
	FeedbackInterface feedbackService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody Feedback data){
		return feedbackService.giveFeedback(data);
	}
	
	@GetMapping("/findAvg/{id}")
	public String findAverage(@PathVariable("id") long id) {
		String s= String.valueOf(feedbackService.findAverage(id));
		return s;
	}
	
	@GetMapping("/getByFreelancer/{id}")
	public List<Feedback> findByFreelancerId(@PathVariable("id") long id) {
		return feedbackService.findByFreelancerId(id);
	}
	
}
