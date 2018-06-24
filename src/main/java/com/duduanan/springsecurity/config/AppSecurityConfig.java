package com.duduanan.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		@SuppressWarnings("deprecation")
		UserBuilder user=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(user.username("john").password("111111").roles("EMPLOYEE"))
		.withUser(user.username("Mary").password("111111").roles("EMPLOYEE","MANAGER"))
		.withUser(user.username("jerry").password("111111").roles("EMPLOYEE","ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http.authorizeRequests()
	     .antMatchers("/resources/**").permitAll()
	     .antMatchers("/").hasRole("EMPLOYEE")
	     .antMatchers("/leaders/**").hasRole("MANAGER")
	     .antMatchers("/systems/**").hasRole("ADMIN")
	     .anyRequest().authenticated()
	     .and().formLogin().loginPage("/showLoginPage").
	     loginProcessingUrl("/authenticateTheUser").
	     permitAll()
	     .and().logout().permitAll()
	     .and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}
