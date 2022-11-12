package com.job.portal.jobPortal.Entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JOB_APPLICATION")
public class JobApplication {

	@Id
	@NotNull(message="Field must be required")
	private long id;

	@Column(name="jobId")
	@NotNull(message="Field must be required")
	private long jobId;
	
	@Column(name="freelancerId")
	@NotNull(message="Field must be required")
	private long freelancerId;

	@Column(name = "appliedDate")
	@NotNull(message="Field must be required")
	private LocalDate appliedDate;

	@Column(name = "CoverLetter")
	@NotNull(message="Field must be required")
	private String coverLetter;

	public JobApplication() {
	}

	

	public JobApplication(long id, @NotNull(message = "Field must be required") long jobId,
			@NotNull(message = "Field must be required") long freelancerId,
			@NotNull(message = "Field must be required") LocalDate appliedDate,
			@NotNull(message = "Field must be required") String coverLetter) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.freelancerId = freelancerId;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}


}
