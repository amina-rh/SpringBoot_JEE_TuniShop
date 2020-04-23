package org.projetjee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Utilisateur_Role {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateurRole;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "idrole")
	private Role role;
	
}
