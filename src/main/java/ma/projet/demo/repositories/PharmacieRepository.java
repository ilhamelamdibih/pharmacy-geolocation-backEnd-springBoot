package ma.projet.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.users.model.Users;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer>{
	
	List<Pharmacie> findByZone(Zone zone);
	List<Pharmacie> findByUser(Users user);

	Pharmacie findById(int id);
	
	
}
