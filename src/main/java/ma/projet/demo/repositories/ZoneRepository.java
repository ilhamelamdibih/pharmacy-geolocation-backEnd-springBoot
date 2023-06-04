package ma.projet.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer>{
	List<Zone> findByVille(Ville ville);
	Zone findById(int id);
}
