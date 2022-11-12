package com.job.portal.jobPortal.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.jobPortal.Entity.SkillExperience;
import com.job.portal.jobPortal.Service.SkillExperienceInterface;

@RestController
@RequestMapping("/skillExperience/api")
public class SkillExperienceController {
	
	@Autowired
	SkillExperienceInterface skillExpService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@Valid @RequestBody SkillExperience skillExp){
		return skillExpService.addSkillExperience(skillExp);
	}
	
	@PutMapping("/updateYears/{id}/{years}")
	public ResponseEntity<String> update(@PathVariable("id") long id, @PathVariable("years") int years){
		return skillExpService.updateYears(id, years);
	}
	

}
