package org.projetjee.dao;


import org.projetjee.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	//Méthode de recherche: permet de retourner une liste de produit ou Page pour retourner une page. findByDesignation(String mc) = select designation (qui est un attribut dans notre classe Produit) from produit where mot clé 
	public Page<Produit> findByDesignationContains(String mc, Pageable pageable);
	
}
