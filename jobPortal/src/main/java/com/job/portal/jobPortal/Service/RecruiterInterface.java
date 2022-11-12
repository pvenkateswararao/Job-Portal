package com.job.portal.jobPortal.Service;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Entity.Recruiter;

public interface RecruiterInterface {

	public boolean validateUser(Login user);
	public ResponseEntity<String> save(Recruiter user);
	Recruiter findById(long id);
}
