package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.JobApplicationRepository;
import com.job.portal.jobPortal.DAO.JobRepository;
import com.job.portal.jobPortal.Entity.Job;
import com.job.portal.jobPortal.Entity.JobApplication;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class JobApplicationImp implements JobApplicationInterface {

	@Autowired
	JobApplicationRepository jobApplicationRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Override
	public ResponseEntity<String> applyJob(JobApplication apllication) {
		if(apllication==null) {
			throw new EmptyDataException("723","Given Object Is Empty, Please give all required details and try again");
		}
		long id =apllication.getJobId();
		Optional<Job> job= jobRepository.findById(id); 
		if(job.isPresent()){
			Job obj=job.get();
			if(obj.isActive()) {
				jobApplicationRepository.save(apllication);
				
				return new ResponseEntity<>("Job Applied",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Job Is Closed",HttpStatus.OK);
			}
			
		}
		else {
			throw new IdNotFoundException("721","Job Id is not present in Database, Please check Id.");
		}
		
	}

	@Override
	public ResponseEntity<String> remove(Long id) {
		Optional<JobApplication> obj=jobApplicationRepository.findById(id);
		if(obj.isPresent()) {
			JobApplication entity=obj.get();
			jobApplicationRepository.delete(entity);
			return new ResponseEntity<>("Job Application Cancelled",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("721","Given Id is not present in Database, Please check Id.");
		}
	}

	@Override
	public JobApplication findById(long id) {
		Optional<JobApplication> obj=jobApplicationRepository.findById(id);
		if(obj.isPresent()) {
			JobApplication entity=obj.get();
		return entity;
		}
		else {
			throw new IdNotFoundException("721","Given Id is not present in Database, Please check Id.");
		}
	}

}
