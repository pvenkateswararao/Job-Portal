package com.job.portal.jobPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.JobRepository;
import com.job.portal.jobPortal.Entity.Job;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;


@Service
public class JobImp implements JobInterface{

	@Autowired
	JobRepository jobRepository;
	
	@Override
	public ResponseEntity<String> postJob(Job job) {
		if(job==null) {
			throw new EmptyDataException("733","Given Object Is Empty, Please give all required details and try again");
		}
		jobRepository.save(job);
		return new ResponseEntity<>("Job Posted Successfully",HttpStatus.OK);
	}

	@Override
	public Job findById(long id) {
		Optional<Job> obj=jobRepository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		else {
			throw new IdNotFoundException("731","Given Id is not present in Database, Please check Id.");
		}
	}

	@Override
	public List<Job> findJobsBySkillId(long skillId) {
		List<Job> obj=jobRepository.findBySkillId(skillId);
		if(obj.size()!=0) {
			return obj;
		}
		else {
			throw new EmptyDataException("732","Hey!, The list is empty. No Objects Found in DB,");
		}
	}

	@Override
	public ResponseEntity<String> close(long id) {
		Optional<Job> obj=jobRepository.findById(id);
		if(obj.isPresent()) {
			Job job= obj.get();
			job.setActive(false);
			jobRepository.save(job);
			return new ResponseEntity<>("Job Closed",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("736","Given Id is not present in Database, Please check Id.");
		}

	}

	@Override
	public List<Job> findALl() {
		List<Job> list= jobRepository.findAll();
		if(list.size()==0) {
			throw new EmptyDataException("732","Hey!, The list is empty. No Objects Found in DB,");
		}
		else {
		return list;
		}
	}

	
}
