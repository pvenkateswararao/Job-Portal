package com.job.portal.jobPortal.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.jobPortal.Entity.BookmarkedFreelancer;

@Repository
public interface BookmarkFrelancerRepository extends JpaRepository<BookmarkedFreelancer, Long>{

	List<BookmarkedFreelancer> findBySkillId(long skillId);
}
