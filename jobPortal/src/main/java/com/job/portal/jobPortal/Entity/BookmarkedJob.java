package com.job.portal.jobPortal.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookmarkedJob")
public class BookmarkedJob {

	@Id
	@NotNull(message="Field must be required")
	private long id;

	
	@Column(name="jobId")
	@NotNull(message="Field must be required")
	private long job;

	@Column(name="freelancerId")
	@NotNull(message="Field must be required")
	private long freelancerId;

	public BookmarkedJob() {
	}

	public BookmarkedJob(long id, @NotNull(message = "Field must be required") long job,
			@NotNull(message = "Field must be required") long freelancerId) {
		super();
		this.id = id;
		this.job = job;
		this.freelancerId = freelancerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getJob() {
		return job;
	}

	public void setJob(long job) {
		this.job = job;
	}

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

	
}
