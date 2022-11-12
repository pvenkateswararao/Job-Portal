package com.job.portal.jobPortal.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skillExperience")
public class SkillExperience {

	
	@Id
	@NotNull(message="Field must be required")
	private long id;

	@Column(name="skillId")
	@NotNull(message="Field must be required")
	private long skillId;

	@Column(name = "YEARS")
	@NotNull(message="Field must be required")
	private int years;
	
	@Column(name="freelancerId")
	@NotNull(message="Field must be required")
	private long freelancerId;

	
	public SkillExperience() {
	}

	

	public SkillExperience(long id, @NotNull(message = "Field must be required") long skillId,
			@NotNull(message = "Field must be required") int years,
			@NotNull(message = "Field must be required") long freelancerId) {
		super();
		this.id = id;
		this.skillId = skillId;
		this.years = years;
		this.freelancerId = freelancerId;
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

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

}
