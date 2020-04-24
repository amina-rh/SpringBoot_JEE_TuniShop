package org.projetjee.dao;

import org.projetjee.entities.Ligne_Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<Ligne_Commande, Long>{

}
