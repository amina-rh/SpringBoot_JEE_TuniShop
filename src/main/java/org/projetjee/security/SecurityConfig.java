package org.projetjee.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//méthode permet de spécifier l'accés des utilisateurs (par défaut elle utilise le mot de passe généré dans la console"
	//LES SEULS UTILISATEURS QUI ont accés au site sont ceux stockés dans la mémoire
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception{ 
		  //il faut encoder le motde passe oubien dire au spring c pa la peine d'utiliser l'encodeur avec {noop}
	  auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles(
	  "USER");
	  auth.inMemoryAuthentication().withUser("user2").password("{noop}1234").roles(
	  "USER");
	  auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles(
	  "USER","ADMIN");
	  }
	  
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin();
	 //http.formLogin().loginPage("/login"); 
		http.authorizeRequests().antMatchers("/AjoutPanier**/**").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/validerPanier**/**").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/login**/**").permitAll();

	}
	
}
