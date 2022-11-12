package com.job.portal.jobPortal.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class MySecurityConfigAdapter extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource).
		usersByUsernameQuery("select id,password, enabled from users where id=?").
		authoritiesByUsernameQuery("select id,role from users where id=?");	
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.httpBasic().
		and()
        .authorizeRequests()
		.antMatchers("/admin/api/**").hasAnyRole("ADMIN")
		.antMatchers("/recruiter/api/**").hasAnyRole("RECRUITER","ADMIN")
		.antMatchers("/freelancer/api/**").hasAnyRole("FREELANCER","ADMIN")
		.antMatchers("/skill/api/**").hasAnyRole("FREELANCER","ADMIN","RECRUITER")
		.antMatchers("/login/**").hasAnyRole("FREELANCER","ADMIN","RECRUITER")
		.antMatchers("/job/api/**").hasAnyRole("ADMIN","RECRUITER")
		.antMatchers("/feedback/api/**").hasAnyRole("ADMIN","RECRUITER")
		.antMatchers("/job/application/api/**").hasAnyRole("FREELANCER")
		.antMatchers("/skillExperience/api/**").hasAnyRole("FREELANCER")
		.antMatchers("/Bookmark/job/api/**").hasAnyRole("FREELANCER")
		.antMatchers("/Bookmark/freelancer/api/**").hasAnyRole("RECRUITER")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	

}
