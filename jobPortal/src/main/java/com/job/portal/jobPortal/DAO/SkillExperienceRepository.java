package com.job.portal.jobPortal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.jobPortal.Entity.SkillExperience;

@Repository
public interface SkillExperienceRepository extends JpaRepository<SkillExperience, Long> {

}
