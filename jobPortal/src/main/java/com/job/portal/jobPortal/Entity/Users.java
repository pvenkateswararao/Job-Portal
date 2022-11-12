package com.job.portal.jobPortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@NotNull(message="Field must be required")
	String id;
	
	@Column(name="password")
	@NotNull(message="Field must be required")
	String password;
	
	@Column(name="enabled")
	@NotNull(message="Field must be required")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	boolean enabled; 
	
	@Column(name="role")
	@NotNull(message="Field must be required")
	String role;
	
	public Users() {
		
	}

	public Users(@NotNull(message = "Field must be required") String id,
			@NotNull(message = "Field must be required") String password,
			@NotNull(message = "Field must be required") boolean enabled,
			@NotNull(message = "Field must be required") String role) {
		super();
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
