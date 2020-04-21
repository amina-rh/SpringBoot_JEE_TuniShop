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

public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private String mailClient;
	private String motDePasseClient;
	private String telClient;
	
	//@OneToMany(mappedBy = "client")
	//private Collection<Commande> commandes;
}
