package org.projetjee.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Commande {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	private double prixCommande;
	
	@ManyToOne
	@JoinColumn(name="idClient")

	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="commande")
	private Collection <Ligne_Commande> items;

}
