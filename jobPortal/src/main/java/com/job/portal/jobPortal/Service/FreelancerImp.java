package com.job.portal.jobPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.FreelancerRepository;
import com.job.portal.jobPortal.DAO.UserRepository;
import com.job.portal.jobPortal.Entity.Freelancer;
import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Entity.Users;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class FreelancerImp implements FreelancerInterface{
	
	@Autowired
	FreelancerRepository freelancerRepository;

	@Autowired
	UserRepository userService;
	
	@Override
	public boolean validateUser(Login user) {
		
		Optional<Freelancer> obj= freelancerRepository.findById(user.getId());
		if(obj.isPresent()) {
			Freelancer response=obj.get();
			if(response.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false; 
	}

	@Override
	public ResponseEntity<String> save(Freelancer freelancer) {
		if(freelancer==null) {
			throw new EmptyDataException("703","Given Object Is Empty, Please give all required details and try again");
		}
		
		Users user=new Users();
		user.setId(String.valueOf(freelancer.getId()));
		user.setEnabled(true);
		user.setPassword(freelancer.getPassword());
		user.setRole("ROLE_FREELANCER");
		userService.save(user);
		
		freelancerRepository.save(freelancer);
		return new ResponseEntity<>("Freelancer Created",HttpStatus.OK);
	}

	@Override
	public Freelancer findById(long id) {
		Optional<Freelancer> obj=freelancerRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		else {
			throw new IdNotFoundException("701","Given Id is not present in Database, Please check Id.");
		}
	}

	@Override
	public List<Freelancer> findAll() {
		List<Freelancer> list=freelancerRepository.findAll();
		if(list.size()==0) {
			throw new EmptyDataException("702","Hey!, The list is empty. No Objects Found in DB,");
		}
		else {
		return list;
		}
	}

}
