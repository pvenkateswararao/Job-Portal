package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Feedback;

public interface FeedbackInterface {

	public ResponseEntity<String> giveFeedback(Feedback feedback);
	public float findAverage(Long feelancerId);
	public List<Feedback> findByFreelancerId(long id);
}
