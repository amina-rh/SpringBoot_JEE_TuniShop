package org.projetjee.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrole;
	private String role;
	
	@OneToMany(mappedBy="role")
	private List<Utilisateur_Role> utilisateurRole;
}
