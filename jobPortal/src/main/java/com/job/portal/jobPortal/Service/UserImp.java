package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.UserRepository;
import com.job.portal.jobPortal.Entity.Users;

@Service
public class UserImp implements UserInterface {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(Users user) {
		userRepository.save(user);
	}

	@Override
	public Users getById(String id) {
		Optional<Users> u=userRepository.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
		
	}

}
