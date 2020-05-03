package org.projetjee.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{ 
	
		auth.inMemoryAuthentication()
		.withUser("Hiba").password("{noop}hiba")
		.roles("USER");
		
		auth.inMemoryAuthentication() .withUser("Amina").password("{noop}amina")
		.roles( "USER");
		 
		auth.inMemoryAuthentication()
		.withUser("Admin").password("{noop}admin")
		.roles( "USER","ADMIN");
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login"); 
		http.authorizeRequests().antMatchers("/AjoutPanier**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/AjoutPanier**/**").hasRole("USER");
		http.authorizeRequests().antMatchers("/deleteProduit**/**").hasRole("ADMIN");
	}

}
