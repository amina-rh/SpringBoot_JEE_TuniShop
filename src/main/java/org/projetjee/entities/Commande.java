package org.projetjee.entities;

import java.util.Date;
import java.util.List;

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
	@JoinColumn(name="idUtilisateur")
	//Un utilisateur peut commander plusieurs commandes ==> ManyToOne ==> Many commande to one utilisateur
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="commande")
	private List<Ligne_Commande> ligneCommande;

}
