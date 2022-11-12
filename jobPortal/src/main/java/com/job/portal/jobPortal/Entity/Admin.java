package com.job.portal.jobPortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "admin")
public class Admin {

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

	public Admin() {
		
	}
	public Admin(long id, String firstName, String lastName, String password) {
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

}
