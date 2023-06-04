package ma.projet.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	Utilisateur findById(int id);
}
