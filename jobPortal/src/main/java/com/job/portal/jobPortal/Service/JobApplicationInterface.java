package com.job.portal.jobPortal.Service;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.JobApplication;

public interface JobApplicationInterface {

	public ResponseEntity<String> applyJob(JobApplication apllication);
	public ResponseEntity<String> remove(Long id);
	public JobApplication findById(long id);
	
}
