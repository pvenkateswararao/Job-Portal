package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.RecruiterRepository;
import com.job.portal.jobPortal.DAO.UserRepository;
import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Entity.Recruiter;
import com.job.portal.jobPortal.Entity.Users;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class RecruiterImp implements RecruiterInterface {

	@Autowired
	RecruiterRepository recruiterRepostory;
	
	@Autowired
	UserRepository userService;
	
	@Override
	public boolean validateUser(Login user) {
	
		Optional<Recruiter> obj= recruiterRepostory.findById(user.getId());
		if(obj.isPresent()) {
			Recruiter response=obj.get();
			if(response.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false; 
	}

	@Override
	public ResponseEntity<String> save(Recruiter recruiter) {
		if(recruiter==null) {
			throw new EmptyDataException("603","Given Object Is Empty, Please give all required details and try again");
		}
		Users user=new Users();
		user.setId(String.valueOf(recruiter.getId()));
		user.setEnabled(true);
		user.setPassword(recruiter.getPassword());
		user.setRole("ROLE_RERCUITER");
		userService.save(user);
		recruiterRepostory.save(recruiter);
		return new ResponseEntity<>("Recruiter Created",HttpStatus.OK);
	}

	@Override
	public Recruiter findById(long id) {
		Optional<Recruiter> obj=recruiterRepostory.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		else {
			throw new IdNotFoundException("601","Given Id is not present in Database, Please check Id.");
		}
	}
}


