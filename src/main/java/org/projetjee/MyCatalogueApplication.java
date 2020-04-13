package org.projetjee;

import java.util.List;

import org.projetjee.dao.ProduitRepository;
import org.projetjee.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class MyCatalogueApplication implements CommandLineRunner {
	
	//@Autoware remplace le constructeur
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit(null,"Ordi HP 5643",6500,54));
		produitRepository.save(new Produit(null,"Imprimante HP 1122",345,11));
		produitRepository.save(new Produit(null,"Smart Phone S9",1200,145));
		
		//La méthode findAll() permet d'avoir tout les produits. Pour avoir que la première page on utilise PageRequest.of(numéro de la page, numéro des éléments). Il retourne un objet de type page
		//finByDesignation permet de chercher selon un mot clé
		Page<Produit> produits=produitRepository.findByDesignationContains("H",PageRequest.of(0, 2));
		
		//Afficher le nombre des éléments dans la liste (il commence par 0 ;)
		System.out.println(produits.getSize());
		//Afficher le nombre des enregistrements totale
		System.out.println(produits.getTotalElements());
		//Afficher le nombre des pages
		System.out.println(produits.getTotalPages());
		//Afficher la liste des produits System.out.println(produits.getContent());
		
		//pour chaque produit p on affiche les informations
		produits.getContent().forEach(p->{
			System.out.print(p.toString());
			
		});
		
		System.out.println("-------------------------");
		//Chercher tout les produits ou designation contient H, prix min =100, affciher une seule page qui contient deux éléments
		Page<Produit> prods=produitRepository.chercher("%H%", 400, PageRequest.of(0, 2));
		
		//Afficher le nombre des éléments dans la liste (il commence par 0 ;)
		System.out.println(prods.getSize());
		//Afficher le nombre des enregistrements totale
		System.out.println(prods.getTotalElements());
		//Afficher le nombre des pages
		System.out.println(prods.getTotalPages());
		//Afficher la liste des produits System.out.println(produits.getContent());
		
		//pour chaque produit p on affiche les informations
		prods.getContent().forEach(p->{
			System.out.print(p.toString());
			
		});
	}

}
