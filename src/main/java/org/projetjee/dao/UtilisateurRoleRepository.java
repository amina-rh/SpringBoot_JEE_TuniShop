package org.projetjee.dao;

import org.projetjee.entities.Utilisateur;
import org.projetjee.entities.Utilisateur_Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRoleRepository extends JpaRepository<Utilisateur_Role, Long>{ 

}
