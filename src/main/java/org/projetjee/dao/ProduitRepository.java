package org.projetjee.dao;

import java.util.List;

import org.projetjee.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	//Méthode de recherche: permet de retourner une liste de produit ou Page pour retourner une page. findByDesignation(String mc) = select designation (qui est un attribut dans notre classe Produit) from produit where mot clé 
	public Page<Produit> findByDesignationContains(String mc, Pageable pageable);
	
	
	//Il y a des cas qui ne peuvent pas être régler par findBy donc on le traite en utilisant la méthode chercher: chercher la condition (designation contient le mot clé, produit qui contient un prix minimum)
	@Query ("select p from Produit p where p.designation like :x and p.prix>:y")
	public Page<Produit> chercher(
			@Param("x")String mc, 
			@Param("y")double prixMin, Pageable pageable);
	
}
