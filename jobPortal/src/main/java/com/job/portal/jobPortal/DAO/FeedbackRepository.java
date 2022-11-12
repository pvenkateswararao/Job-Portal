package com.job.portal.jobPortal.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.portal.jobPortal.Entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	List<Feedback> findByFreelancerId(long id);
}
