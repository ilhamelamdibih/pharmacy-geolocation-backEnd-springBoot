package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.repositories.VilleRepository;

@Service
public class VilleService implements IDao<Ville>{

	@Autowired
	private VilleRepository villeRepository;
	
	@Override
	public Ville findById(int id) {
		return villeRepository.findById(id) ;
	}

	@Override
	public List<Ville> findAll() {
		return villeRepository.findAll();
	}

	@Override
	public void update(Ville o) {
		villeRepository.save(o);
	}

	@Override
	public void delete(Ville o) {
		villeRepository.delete(o);
	}

	@Override
	public Ville save(Ville o) {
		return villeRepository.save(o);
	}

	public Ville findByNom(String ville) {
		return villeRepository.findByNom(ville);
	}

	
}
