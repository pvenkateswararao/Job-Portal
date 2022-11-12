package com.job.portal.jobPortal.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.Skill;

public interface SkillInterface {

	public ResponseEntity<String> save(Skill skill);
	public ResponseEntity<String> update(Skill skill);
	public ResponseEntity<String> remove(long id);
	public List<Skill> findAll();
}
