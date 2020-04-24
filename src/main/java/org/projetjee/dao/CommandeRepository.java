package org.projetjee.dao;

import org.projetjee.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
