package com.job.portal.jobPortal.Service;

import com.job.portal.jobPortal.Entity.Users;

public interface UserInterface {

	public void save(Users user);
	Users getById(String id);
}
