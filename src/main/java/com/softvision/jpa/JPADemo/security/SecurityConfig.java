package com.softvision.jpa.JPADemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Authentication : User --> Roles
		protected void configure(AuthenticationManagerBuilder auth)
				throws Exception {
			auth.inMemoryAuthentication().withUser("user").password("{noop}user")
					.roles("USER").and().withUser("admin").password("{noop}admin")
					.roles("USER", "ADMIN");
		}
		
		// Authorization : Role -> Access
		// survey -> USER
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests()
								.antMatchers("/customers/**").hasRole("USER").antMatchers("/**").hasRole("ADMIN")
								.antMatchers("/h2-console/**")
				                .permitAll().and().csrf().disable()
								.headers().frameOptions().disable();
		}
}
