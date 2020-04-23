package org.projetjee.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String pseudo;
	private String password;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String adresseUtilisateur;
	private String mailUtilisateur;
	private String telUtilisateur;
	
	@OneToMany(mappedBy= "utilisateur")
	private List<Commande> commande;
	
	@OneToMany(mappedBy="utilisateur")
	private List<Utilisateur_Role> utilisateurRole;
}
