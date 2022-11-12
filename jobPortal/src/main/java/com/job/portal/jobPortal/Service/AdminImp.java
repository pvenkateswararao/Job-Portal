package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.AdminRepository;
import com.job.portal.jobPortal.DAO.UserRepository;
import com.job.portal.jobPortal.Entity.Admin;
import com.job.portal.jobPortal.Entity.Login;
import com.job.portal.jobPortal.Entity.Users;

@Service
public class AdminImp implements AdminInterface {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	UserRepository userService;
	
	@Override
	public boolean validateUser(Login user) {
		Admin response;
		Optional<Admin> obj= adminRepository.findById(user.getId());
		if(obj.isPresent()) {
			response=obj.get();
			if(response.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false; 
				
	}

	
	
	@Override
	public ResponseEntity<String> save(Admin admin) {
		adminRepository.save(admin);
		Users user=new Users();
		user.setId(String.valueOf(admin.getId()));
		user.setEnabled(true);
		user.setPassword(admin.getPassword());
		user.setRole("ROLE_ADMIN");
		userService.save(user);
		return new ResponseEntity<>("Admin Created",HttpStatus.OK);
	}

	@Override
	public Admin findById(long id) {
		Optional<Admin> obj=adminRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

}
