package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.FeedbackRepository;
import com.job.portal.jobPortal.Entity.Feedback;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;

@Service
public class FeedbackImp implements FeedbackInterface {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	
	@Override
	public ResponseEntity<String> giveFeedback(Feedback feedback) {
		if(feedback==null) {
			throw new EmptyDataException("713","Given Object Is Empty, Please give all required details and try again");
		}
		feedbackRepository.save(feedback);
		return new ResponseEntity<>("Feedback Saved Thank You ",HttpStatus.OK);
	}

	@Override
	public float findAverage(Long feelancerId) {
		List<Feedback> list=feedbackRepository.findByFreelancerId(feelancerId); 
		if(list.size()==0) {
			throw new EmptyDataException("712","Hey!, The list is empty. No Objects Found in DB,");
		}
		float avg=0;
		for(Feedback obj:list) {
			avg+=obj.getRating();
		}
		if(list.size()!=0) {
		return avg/list.size();
		}
		return 0;
	}

	@Override
	public List<Feedback> findByFreelancerId(long id) {
		List<Feedback> list=feedbackRepository.findByFreelancerId(id);
		if(list.size()==0) {
			throw new EmptyDataException("712","Hey!, The list is empty. No Objects Found in DB,");
		}
		return list;
	}

}
