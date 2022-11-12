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
@Table(name="recruiter")
public class Recruiter {

	@Id
	@NotNull(message="Field must be required")
	long id;

	@Column(name = "firstName")
	@NotNull(message="Field must be required")
	String firstName;

	@Column(name = "lastName")
	@NotNull(message="Field must be required")
	String lastName;

	@Column(name = "password")
	@NotNull(message="Field must be required")
	String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "postedRecruiter")
	public List<Job> postedJobs;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiterId")
	public List<Feedback> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiterId")
	public List<BookmarkedFreelancer> freelancers;

	public Recruiter() {
		
	}
	

	public Recruiter(long id, @NotNull(message = "Field must be required") String firstName,
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

	public List<Job> getPostedJobs() {
		return postedJobs;
	}

	public void setPostedJobs(List<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<BookmarkedFreelancer> getFreelancers() {
		return freelancers;
	}

	public void setFreelancers(List<BookmarkedFreelancer> freelancers) {
		this.freelancers = freelancers;
	}
	
	

}
