package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Freelancer;
import com.job.portal.jobPortal.Entity.Login;

public interface FreelancerInterface {

	public boolean validateUser(Login user);
	public ResponseEntity<String> save(Freelancer user);
	Freelancer findById(long id);
	List<Freelancer> findAll();
}
