package org.projetjee;

import org.projetjee.dao.UtilisateurRepository;
import org.projetjee.dao.UtilisateurRoleRepository;



import org.projetjee.dao.ProduitRepository;
import org.projetjee.dao.RoleRepository;
import org.projetjee.entities.Utilisateur;
import org.projetjee.entities.Utilisateur_Role;
import org.projetjee.entities.Role;
import org.projetjee.entities.Produit;

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


	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private UtilisateurRepository utilisateurRepository;

	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private UtilisateurRoleRepository utilisateurRoleRepository;
	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit(null,"La Farmla, le gilet traditionnel tunisien",70,9,"https://zupimages.net/up/20/16/a8m6.jpg"));
		produitRepository.save(new Produit(null,"Jebba Homme tunisienne",300,3,"https://zupimages.net/up/20/16/tw7p.jpg"));
		produitRepository.save(new Produit(null,"La Farmla, le gilet de mariée",90,11,"https://zupimages.net/up/20/16/r646.jpg"));
		produitRepository.save(new Produit(null,"Jupe Traditionnelle",150,3,"https://zupimages.net/up/20/16/y1d5.jpg"));
		produitRepository.save(new Produit(null,"La Farmla, le gilet traditionnel tunisien",110,4,"https://zupimages.net/up/20/16/bzpm.jpg"));
		produitRepository.save(new Produit(null,"La chéchia",90,10,"https://zupimages.net/up/20/16/e1j2.jpg"));
		produitRepository.save(new Produit(null,"Chaussures traditionnelles pour Jebba",100,11,"https://zupimages.net/up/20/16/z2g7.jpg"));
		produitRepository.save(new Produit(null,"Tabdila",300,4,"https://zupimages.net/up/20/16/w74a.jpg"));
		produitRepository.save(new Produit(null,"Pull Fadhila rouge",30,7,"https://zupimages.net/up/20/16/dm8y.jpg"));
		produitRepository.save(new Produit(null,"Pull Fadhila bleu",30,15,"https://zupimages.net/up/20/16/63jh.jpg"));
		produitRepository.save(new Produit(null,"Maliya revisitée",30,15,"https://zupimages.net/up/20/16/qjnm.jpg"));
		produitRepository.save(new Produit(null,"Tabdila",30,15,"https://zupimages.net/up/20/16/9u0v.jpg"));



		//Utilisateur
		utilisateurRepository.save(new Utilisateur(null,"dev","1234"));
		
		//Role
		
		roleRepository.save(new Role(null,"ADMIN"));
		roleRepository.save(new Role(null,"USER"));
		

		//utilisateurRepository.save(new Utilisateur(null,"queendev","1234","Amina","Tours","amina@gmail.com","1234","06000000"));
		//clientRepository.save(new Client("queendev","1234"));

		//UtilisateurRole
		utilisateurRoleRepository.save(new Utilisateur_Role(null,"queendev","USER"));


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
