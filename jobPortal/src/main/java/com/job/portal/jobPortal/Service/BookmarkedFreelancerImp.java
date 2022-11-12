package com.job.portal.jobPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.BookmarkFrelancerRepository;
import com.job.portal.jobPortal.Entity.BookmarkedFreelancer;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class BookmarkedFreelancerImp implements BookmarkFreelancerInterface{

	
	
	@Autowired
	BookmarkFrelancerRepository bookmarkRepository;
	
	@Override
	public ResponseEntity<String> bookmarkFreelancer(BookmarkedFreelancer bookmark) {
		if(bookmark==null) {
			throw new EmptyDataException("803","Given Object Is Empty, Please give all required details and try again");
		}
		
		bookmarkRepository.save(bookmark);
		return new ResponseEntity<>("Bookmarked Freelancer",HttpStatus.OK);

	}

	@Override
	public List<BookmarkedFreelancer> findBySkill(long skillId) {
		List<BookmarkedFreelancer> list=bookmarkRepository.findBySkillId(skillId);
		if(list.size()==0) {
			throw new EmptyDataException("804","Hey!, The list is empty. No Objects Found in DB,");
		}
		else {
		return list;
		}
	}

	@Override
	public ResponseEntity<String> remove(long id) {
		Optional<BookmarkedFreelancer> obj=bookmarkRepository.findById(id);
		if(obj.isPresent()) {
			BookmarkedFreelancer entity=obj.get();
			bookmarkRepository.delete(entity);
			return new ResponseEntity<>("Bookmark Removed",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("802","Given Id is not present in Database, Please check Id.");
		}
	}

	@Override
	public BookmarkedFreelancer findById(long id) {
		Optional<BookmarkedFreelancer> obj=bookmarkRepository.findById(id);
		if(obj.isPresent()) {
			BookmarkedFreelancer entity=obj.get();
			return entity;
		}
		else {
			throw new IdNotFoundException("801","Given Id is not present in Database, Please check Id.");
		}
	}
	

}
