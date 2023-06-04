package ma.projet.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Garde;

public interface GardeRepository extends JpaRepository <Garde, Integer>{

	Garde findByType(String type);
	Garde findById(int id);
}
