package com.job.portal.jobPortal.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.BookmarkedJob;
import com.job.portal.jobPortal.Service.BookmarkedJobInterface;

@RestController
@RequestMapping(path = "/Bookmark/job/api")
public class BookmarkJobController {
	
	@Autowired
	BookmarkedJobInterface bookmarkJobService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody BookmarkedJob data){
		return bookmarkJobService.bookmarkJob(data);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		return bookmarkJobService.delete(id);
	}
	
	@GetMapping("/get/{id}")
	public BookmarkedJob finaById(@PathVariable("id") long id) {
		return bookmarkJobService.findById(id);
	}
	
	

}
