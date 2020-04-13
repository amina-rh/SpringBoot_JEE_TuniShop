package org.projetjee.web;

import java.util.List;

import org.projetjee.dao.ProduitRepository;
import org.projetjee.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Puisque c'est un controleur, il daut utiliser l'annotaion controller
@Controller
public class ProduitController {
	
	//Afficher la liste des produits: nous avons besoins de la couche DAO
	//Il faut décalarer l'interface ProduitRepository
	@Autowired
	private ProduitRepository produitRepository;
	
	//Méthode qui permet de retourner une vue index.html. Quand on écrit index tt cours, par défaut c index.html
	//Pour accéder à cette méthode on utilise GetMapping càd si une requete http est envoyé avec get vers path="/index" c'est cette méthode qui va s'éxecuter
	//Il faut créer le fichier index dans le fichier ressources
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path="/products")
	public String products(Model model) {
		//Récupérer tout les produits dans un liste ensuite il faut stocker la liste dans le modèle: donc il faut le déclarer dans l'entête de la méthode 
		List<Produit> produits=produitRepository.findAll();
		//On stocke dans le modèle un attribut =clé quis'appelle listProduits dont la valeur est la liste des produits
		//Ensuite dans la vue il faut écrire le code thymeleaf pour faire une boucle sur les produits qui se trouve dans la liste des produits revenir vers la vue ==> products.html
		model.addAttribute("listProduits", produits);
		return "products";
	}

}
