package org.projetjee.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	//méthode permet de spécifier l'accés des utilisateurs (par défaut elle utilise le mot de passe généré dans la console"
	//LES SEULS UTILISATEURS QUI ont accés au site sont ceux stockés dans la mémoire
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception{ 
		  //il faut encoder le motde passe oubien dire au spring c pa la peine d'utiliser l'encodeur avec {noop}
			
			
			
			  auth.inMemoryAuthentication().withUser("hiba").password("{noop}hiba").roles(
			  "USER");
			  auth.inMemoryAuthentication().withUser("amina").password("{noop}amina").
			  roles( "USER");
			  auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").
			  roles( "USER","ADMIN");
			 
			 
			 
		  
			
			
			/*
			 * auth.jdbcAuthentication().dataSource(dataSource)
			 * .usersByUsernameQuery("select idutilisateur, pseudo as principal,nomutilisateur,prenomutilisateur,adresseutilisateur,mailutilisateur, password as credentials, telutilisateur from utilisateur where pseudo=?"
			 * )
			 * .authoritiesByUsernameQuery("select idutilisateurrole, pseudo as principal, role as role from utilisateur_role where pseudo=?"
			 * )
			 * 
			 * .rolePrefix("Role_"); ;
			 */
			 
			
			  
				
	  }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//http.formLogin();
		http.formLogin().loginPage("/login"); 
		http.authorizeRequests().antMatchers("/AjoutPanier**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/AjoutPanier**/**").hasRole("USER");
		http.authorizeRequests().antMatchers("/deleteProduit**/**").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/validerPanier**/**").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/login**/**").permitAll();
	}
	
}
