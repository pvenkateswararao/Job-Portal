package com.job.portal.jobPortal.Controller;

import java.util.List;

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

import com.job.portal.jobPortal.Entity.BookmarkedFreelancer;
import com.job.portal.jobPortal.Service.BookmarkFreelancerInterface;

@RestController
@RequestMapping(path = "/Bookmark/freelancer/api")
public class BookmarkFreelancerController {

	@Autowired
	BookmarkFreelancerInterface bookmarkFreelancerService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody BookmarkedFreelancer data){
		return bookmarkFreelancerService.bookmarkFreelancer(data);
	}
	
	@GetMapping("/findBySkillId/{id}")
	public List<BookmarkedFreelancer> findAverage(@PathVariable("id") long id) {
		return bookmarkFreelancerService.findBySkill(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		return bookmarkFreelancerService.remove(id);
	}
	
	@GetMapping("/get/{id}")
	public BookmarkedFreelancer getById(@PathVariable("id") long id){
		return bookmarkFreelancerService.findById(id);
	}
	
}
