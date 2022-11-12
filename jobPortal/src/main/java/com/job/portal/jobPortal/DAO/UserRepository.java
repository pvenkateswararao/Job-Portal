package com.job.portal.jobPortal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.portal.jobPortal.Entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
