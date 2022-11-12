package com.job.portal.jobPortal.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JOB")
public class Job {

	@Id
	@NotNull(message="Field must be required")
	private long id;

	@Column(name = "POSTED_DATE")
	@NotNull(message="Field must be required")
	private LocalDate postedDate;

	@Column(name="skillId")
	@NotNull(message="Field must be required")
	private long skillId;

	@Column(name="postedRecruiter")
	@NotNull(message="Field must be required")
	private long postedRecruiter;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobId")
	private List<JobApplication> jobApplications;

	@Column(name="active")
	private boolean active;

	public Job() {
	}

	public Job(long id, LocalDate postedDate, long skillId, long postedRecruiter, List<JobApplication> jobApplications,
			boolean active) {
		super();
     	this.id = id;
		this.postedDate = postedDate;
		this.skillId = skillId;
		this.postedRecruiter = postedRecruiter;
		this.jobApplications = jobApplications;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public long getPostedRecruiter() {
		return postedRecruiter;
	}

	public void setPostedRecruiter(long postedRecruiter) {
		this.postedRecruiter = postedRecruiter;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
			
}