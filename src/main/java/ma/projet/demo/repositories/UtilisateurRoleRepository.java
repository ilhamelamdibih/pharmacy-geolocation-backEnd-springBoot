package ma.projet.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.entities.UtilisateurRolePK;

public interface UtilisateurRoleRepository extends JpaRepository<UtilisateurRole,UtilisateurRolePK> {
	List<UtilisateurRole> findByRole (Role role);
	List<UtilisateurRole> findByUtilisateur (Utilisateur utilisateur);
	UtilisateurRole findByPk(UtilisateurRolePK pk);
}
