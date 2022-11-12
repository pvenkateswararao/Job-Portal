package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Job;

public interface JobInterface {

	public ResponseEntity<String> postJob(Job job);
	public Job findById(long id);
	public List<Job> findJobsBySkillId(long skillId);
	public List<Job> findALl();
	public ResponseEntity<String> close(long id);
}
