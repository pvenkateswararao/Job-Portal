package com.job.portal.jobPortal.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

	@Id
	@NotNull(message="Field must be required")
	private long id;

	@Column(name = "RATING")
	@NotNull(message="Field must be required")
	private int rating;

	@Column(name="recruiterId")
	@NotNull(message="Field must be required")
	private long recruiterId;
	
	@Column(name="freelancerId")
	@NotNull(message="Field must be required")
	private long freelancerId;
	
	@Column(name = "COMMENT")
	@NotNull(message="Field must be required")
	private String comment;


	public Feedback() {
	}


	

	public Feedback(long id, @NotNull(message = "Field must be required") int rating,
			@NotNull(message = "Field must be required") long recruiterId,
			@NotNull(message = "Field must be required") long freelancerId,
			@NotNull(message = "Field must be required") String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.recruiterId = recruiterId;
		this.freelancerId = freelancerId;
		this.comment = comment;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public long getRecruiterId() {
		return recruiterId;
	}


	public void setRecruiterId(long recruiterId) {
		this.recruiterId = recruiterId;
	}


	public long getFreelancerId() {
		return freelancerId;
	}


	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
}