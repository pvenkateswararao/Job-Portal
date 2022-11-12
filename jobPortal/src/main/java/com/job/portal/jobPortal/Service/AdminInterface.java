package com.job.portal.jobPortal.Service;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Admin;
import com.job.portal.jobPortal.Entity.Login;

public interface AdminInterface {

	public ResponseEntity<String> save(Admin admin);
	public Admin findById(long id);
	public boolean validateUser(Login user);
	
}
