package org.projetjee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Mapping objet relationnel. On utilisa l'annotation Entity pour dire que la classe Produit correspond à une table au niveau de la base de donnée
@Entity
//Pour spécifier le nom de la table on utilise l'annotaion @Table
//@Table(name="PRODUIT") : n'est pas obligatoire. Si on la met pas il va prendre la table qui a le même nom que la classe 

//Notation Data de Lombok permet d'avoir les setters et les getters sans les ecrire >window >showview>outline
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Produit {
		//spécifier l'attribut qui represente l'identifiant. iDENTITY permet d'ajouter un autoincrémentation au niveau de la table
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private double prix;
	private double quantite;
	
}
