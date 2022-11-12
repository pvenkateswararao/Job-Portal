package com.job.portal.jobPortal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.jobPortal.Entity.BookmarkedJob;

@Repository
public interface BookmarkJobRepository extends JpaRepository<BookmarkedJob, Long> {

}
