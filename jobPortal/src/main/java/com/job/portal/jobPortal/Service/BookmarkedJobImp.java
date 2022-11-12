package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.BookmarkJobRepository;
import com.job.portal.jobPortal.Entity.BookmarkedJob;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class BookmarkedJobImp implements BookmarkedJobInterface {

	@Autowired
	BookmarkJobRepository brepository;
	
	@Override
	public ResponseEntity<String> bookmarkJob(BookmarkedJob bookmarkedJob) {
		if(bookmarkedJob==null) {
			throw new EmptyDataException("903","Given Object Is Empty, Please give all required details and try again");
		}
		brepository.save(bookmarkedJob);
		return new ResponseEntity<>("Bookmarked give Job ",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		Optional<BookmarkedJob> obj=brepository.findById(id);
		if(obj.isPresent()) {
			BookmarkedJob entity=obj.get();
			brepository.delete(entity);
			return new ResponseEntity<>("Bookmark Removed",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("901","Given Id is not present in Database, Please check Id.");
		}
	}

	@Override
	public BookmarkedJob findById(long id) {
		Optional<BookmarkedJob> obj=brepository.findById(id);
		if(obj.isPresent()) {
			BookmarkedJob entity=obj.get();
			return entity;
		}
		else {
			throw new IdNotFoundException("901","Given Id is not present in Database, Please check Id.");
		}
	}

}
