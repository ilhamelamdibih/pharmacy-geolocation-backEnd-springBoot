package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Garde;
import ma.projet.demo.repositories.GardeRepository;
@Service
public class GardeService implements IDao<Garde> {

	@Autowired
	private GardeRepository gardeRepository;
	
	@Override
	public Garde findById(int id) {
		return gardeRepository.findById(id);
	}

	@Override
	public List<Garde> findAll() {
		return gardeRepository.findAll();
	}

	@Override
	public void update(Garde o) {
		gardeRepository.save(o);
		
	}

	@Override
	public void delete(Garde o) {
		gardeRepository.delete(o);
		
	}

	@Override
	public Garde save(Garde o) {
		return gardeRepository.save(o);
	}

	public Garde findByType(String periode) {
		return gardeRepository.findByType(periode);
	}

}
