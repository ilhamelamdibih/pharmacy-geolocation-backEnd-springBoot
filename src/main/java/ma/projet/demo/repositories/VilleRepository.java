package ma.projet.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer>{
	
	Ville findByNom(String nom);
	Ville findById(int id);
}
