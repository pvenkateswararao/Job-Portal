package com.job.portal.jobPortal.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	@NotNull(message="Field must be required")
	Long id;
	
	@Column(name="name")
	@NotNull(message="Field must be required")
	String name;
	
	@Column(name="description")
	@NotNull(message="Field must be required")
	String description;
	
	public Skill() {
		
	}

	public Skill(Long id, @NotNull String name, @NotNull String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
