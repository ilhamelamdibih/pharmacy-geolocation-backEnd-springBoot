package ma.projet.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Garde;
import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.entities.PharmacieGardePK;

public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde,PharmacieGardePK> {
	List<PharmacieGarde> findByGarde (Garde garde);
	List<PharmacieGarde> findByPharmacie (Pharmacie pharmacie);
	PharmacieGarde findByPk(PharmacieGardePK pk);
}
