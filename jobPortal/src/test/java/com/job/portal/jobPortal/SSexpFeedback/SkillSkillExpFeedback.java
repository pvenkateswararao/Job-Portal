package com.job.portal.jobPortal.SSexpFeedback;

import org.springframework.boot.test.context.SpringBootTest;

import com.job.portal.jobPortal.Entity.Feedback;
import com.job.portal.jobPortal.Entity.Skill;
import com.job.portal.jobPortal.Entity.SkillExperience;
import com.job.portal.jobPortal.Service.FeedbackInterface;
import com.job.portal.jobPortal.Service.SkillExperienceInterface;
import com.job.portal.jobPortal.Service.SkillInterface;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class SkillSkillExpFeedback {
	@Autowired
	private SkillInterface skillService;

	@Autowired
	private SkillExperienceInterface skillExpService;
	
	@Autowired
	private FeedbackInterface feedbackService;
	
	@Test
	void contextLoads() {
		System.out.println("Context loaded successfully!!!");
	}

	@Test
	void testInsertSkill() {
		Skill skill=new Skill(989L,"Python","E2 proficiency");
		assertNotNull(skill);
		skillService.save(skill);
		
	}
	
	@Test
	void testInsertSkillExp() {
		SkillExperience skill=new SkillExperience(789L,989L,4,100L);
		assertNotNull(skill);
		skillExpService.addSkillExperience(skill);
		
	}

	@Test
	void testInsertFeedback() {
		Feedback f=new Feedback(678L,4,10L,100L,"Excellent");
		assertNotNull(f);
		feedbackService.giveFeedback(f);
		
	}
	
	@Test
	void testGetSkills() {
		List<Skill> list = skillService.findAll();
		assertNotNull(list);
	}

	@Test
	void testGetAllFeedbacks() {
		List<Feedback> list = feedbackService.findByFreelancerId(100);
		assertNotNull(list);

    }
}
