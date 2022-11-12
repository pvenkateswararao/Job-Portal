package com.job.portal.jobPortal.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "freelancer")
public class Freelancer {

	@Id
	@NotNull(message="Field must be required")
	private long id;

	@Column(name = "FIRST_NAME")
	@NotNull(message="Field must be required")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotNull(message="Field must be required")
	private String lastName;

	@Column(name = "PASSWORD")
	@NotNull(message="Field must be required")
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancerId")
	private List<JobApplication> appliedJobs;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancerId")
	private List<Feedback> feedbacks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancerId")
	private List<SkillExperience> skills;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancerId")
	private List<BookmarkedJob> bookmarkedJobs;

	public Freelancer() {
	}

	public Freelancer(long id, @NotNull(message = "Field must be required") String firstName,
			@NotNull(message = "Field must be required") String lastName,
			@NotNull(message = "Field must be required") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<JobApplication> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<JobApplication> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<SkillExperience> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillExperience> skills) {
		this.skills = skills;
	}

	public List<BookmarkedJob> getBookmarkedJobs() {
		return bookmarkedJobs;
	}

	public void setBookmarkedJobs(List<BookmarkedJob> bookmarkedJobs) {
		this.bookmarkedJobs = bookmarkedJobs;
	}

	

}
