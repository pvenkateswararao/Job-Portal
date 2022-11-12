package com.job.portal.jobPortal.Service;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.BookmarkedJob;

public interface BookmarkedJobInterface {

	public ResponseEntity<String> bookmarkJob(BookmarkedJob bookmarkedJob);
	public ResponseEntity<String> delete(Long id);
	public BookmarkedJob findById(long id);
}
