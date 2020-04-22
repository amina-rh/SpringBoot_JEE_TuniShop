package org.projetjee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idutilisateur;
	private String pseudo;
	private String nomutilisateur;
	private String prenomutilisateur;
	private String adresseutilisateur;
	private String mailutilisateur;
	private String password;
	private String telutilisateur;
	
	//@OneToMany(mappedBy = "client")
	//private Collection<Commande> commandes;
}
