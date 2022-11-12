package com.job.portal.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.SkillExperienceRepository;
import com.job.portal.jobPortal.Entity.SkillExperience;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class SkillExperienceImp implements SkillExperienceInterface{

	@Autowired
	SkillExperienceRepository skillExpRepository;
	
	@Override
	public ResponseEntity<String> addSkillExperience(SkillExperience skillExp) {
		
		if(skillExp==null) {
			throw new EmptyDataException("813","Given Object Is Empty, Please give all required details and try again");
		}
		
		skillExpRepository.save(skillExp);
		return new ResponseEntity<>("Skill Experience Added",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateYears(long id, int years) {
		Optional<SkillExperience> obj=skillExpRepository.findById(id);
		if(obj.isPresent()) {
			SkillExperience exp = obj.get();
			exp.setYears(years);
			skillExpRepository.save(exp);
			return new ResponseEntity<>("Skill Experience updated",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("811","Given Id is not present in Database, Please check Id.");
		}

	}

	
}
