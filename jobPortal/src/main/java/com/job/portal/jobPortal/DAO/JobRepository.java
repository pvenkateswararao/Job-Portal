package com.job.portal.jobPortal.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.jobPortal.Entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	List<Job> findBySkillId(long skillId);
}
