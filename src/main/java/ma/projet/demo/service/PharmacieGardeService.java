package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Garde;
import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.entities.PharmacieGardePK;
import ma.projet.demo.repositories.PharmacieGardeRepository;
@Service
public class PharmacieGardeService implements IDao<PharmacieGarde> {
	@Autowired
	private PharmacieGardeRepository pharmacieGardeRepository;
	
	@Override
	public PharmacieGarde findById(int id) {
		return null ;
	}

	public PharmacieGarde findBypk(PharmacieGardePK pk) {
		return pharmacieGardeRepository.findByPk(pk);
	}

	@Override
	public List<PharmacieGarde> findAll() {
		return pharmacieGardeRepository.findAll();
	}

	@Override
	public void update(PharmacieGarde o) {
		pharmacieGardeRepository.save(o);
		
	}

	@Override
	public void delete(PharmacieGarde o) {
		pharmacieGardeRepository.delete(o);
		
	}

	@Override
	public PharmacieGarde save(PharmacieGarde o) {
		return pharmacieGardeRepository.save(o);
	}

	public List<PharmacieGarde> findByGarde(Garde garde) {
		return pharmacieGardeRepository.findByGarde(garde);
	}

	public List<PharmacieGarde> findByPharmacie(Pharmacie pharmacie) {
		return pharmacieGardeRepository.findByPharmacie(pharmacie);
	}

}
