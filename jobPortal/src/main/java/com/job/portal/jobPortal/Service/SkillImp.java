package com.job.portal.jobPortal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.portal.jobPortal.DAO.SkillRepository;
import com.job.portal.jobPortal.Entity.Skill;
import com.job.portal.jobPortal.ExceptionHandler.EmptyDataException;
import com.job.portal.jobPortal.ExceptionHandler.IdNotFoundException;

@Service
public class SkillImp implements SkillInterface {

	@Autowired
	SkillRepository skillRepository;

	@Override
	public ResponseEntity<String> save(Skill skill) {
		if(skill==null) {
			throw new EmptyDataException("913","Given Object Is Empty, Please give all required details and try again");
		}
		
		skillRepository.save(skill);
		return new ResponseEntity<>("Skill Created", HttpStatus.OK);
	}
 
	@Override
	public ResponseEntity<String> update(Skill skill) {
		if(skill==null) {
			throw new EmptyDataException("913","Given Object Is Empty, Please give all required details and try again");
		}
		skillRepository.save(skill);
		return new ResponseEntity<>("Skill Updated", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> remove(long id) {
		Optional<Skill> obj=skillRepository.findById(id);
		if(obj.isPresent()) {
			skillRepository.deleteById(id);
			return new ResponseEntity<>("Skill Deleted",HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("911","Given Id is not present in Database, Please check Id.");
		}

	}

	@Override
	public List<Skill> findAll() {
		List<Skill> list = skillRepository.findAll();
		if(list.size()==0) {
			throw new EmptyDataException("912","Hey!, The list is empty. No Objects Found in DB,");
		}
		else {
		return list;
		}
	}

}
