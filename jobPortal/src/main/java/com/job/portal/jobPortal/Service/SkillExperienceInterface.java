package com.job.portal.jobPortal.Service;

import org.springframework.http.ResponseEntity;

import com.job.portal.jobPortal.Entity.SkillExperience;

public interface SkillExperienceInterface {

	public ResponseEntity<String> addSkillExperience(SkillExperience skillExp);
	public ResponseEntity<String> updateYears(long id, int years);
}
