package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.BookmarkedFreelancer;

public interface BookmarkFreelancerInterface {

	public ResponseEntity<String> bookmarkFreelancer(BookmarkedFreelancer bookmark);
	public List<BookmarkedFreelancer> findBySkill(long skillId);
	public ResponseEntity<String> remove(long id);
	public BookmarkedFreelancer findById(long id);
}
