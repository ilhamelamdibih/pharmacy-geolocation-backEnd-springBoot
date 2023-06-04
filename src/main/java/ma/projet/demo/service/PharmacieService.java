package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.PharmacieRepository;
import ma.projet.demo.users.model.Users;
@Service
public class PharmacieService implements IDao<Pharmacie>{

	@Autowired
	private PharmacieRepository pharmacieRepository;
	
	@Override
	public Pharmacie findById(int id) {
		return pharmacieRepository.findById(id);
	}

	@Override
	public List<Pharmacie> findAll() {
		return pharmacieRepository.findAll();
	}

	@Override
	public void update(Pharmacie o) {
		pharmacieRepository.save(o);		
	}

	@Override
	public void delete(Pharmacie o) {
		pharmacieRepository.delete(o);
	}

	@Override
	public Pharmacie save(Pharmacie o) {
		return pharmacieRepository.save(o);
	}

	public List<Pharmacie> findByZone(Zone zoneName) {
		return pharmacieRepository.findByZone(zoneName);
	}

	public List<Pharmacie> findByUtilisateur(Users user) {
		return pharmacieRepository.findByUser(user);
	}

}
