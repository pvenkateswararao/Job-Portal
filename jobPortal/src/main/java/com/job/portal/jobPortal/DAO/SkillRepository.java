package com.job.portal.jobPortal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.jobPortal.Entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
