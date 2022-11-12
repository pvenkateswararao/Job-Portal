package com.job.portal.jobPortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookamarkedFreelancer")
public class BookmarkedFreelancer {

	@Id
	@NotNull(message="Field must be required")
	private long id; 
	
	@Column(name="skillId")
	@NotNull(message="Field must be required")
	private long skillId;

	@Column(name="freelancerId")
	@NotNull(message="Field must be required")
	private long freelancerId;

	@Column(name="recruiterId")
	@NotNull(message="Field must be required")
	private long bookmarkedBy;

	public BookmarkedFreelancer() {
	}

	public BookmarkedFreelancer(long id, @NotNull(message = "Field must be required") long skillId,
			@NotNull(message = "Field must be required") long freelancerId,
			@NotNull(message = "Field must be required") long bookmarkedBy) {
		super();
		this.id = id;
		this.skillId = skillId;
		this.freelancerId = freelancerId;
		this.bookmarkedBy = bookmarkedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public long getBookmarkedBy() {
		return bookmarkedBy;
	}

	public void setBookmarkedBy(long bookmarkedBy) {
		this.bookmarkedBy = bookmarkedBy;
	}

	
}
