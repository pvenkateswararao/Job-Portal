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

import com.job.portal.jobPortal.Entity.Skill;
import com.job.portal.jobPortal.Service.SkillInterface;

@RestController
@RequestMapping(path = "/skill/api")
public class SkillController {
	@Autowired
	SkillInterface skillService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody Skill skill){
		return skillService.save(skill);
	}

	@PostMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody Skill skill){
		return skillService.update(skill);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@Valid @PathVariable("id") long id){
		return skillService.remove(id);
	}
	@GetMapping("/list")
	private List<Skill> getAllSkills() {
		return skillService.findAll();
	}
	
}
