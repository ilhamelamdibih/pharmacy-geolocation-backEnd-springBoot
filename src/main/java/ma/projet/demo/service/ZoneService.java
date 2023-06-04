package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.ZoneRepository;
@Service
public class ZoneService implements IDao<Zone> {

	@Autowired
	private ZoneRepository zoneRepository;
	
	@Override
	public Zone findById(int id) {
		return zoneRepository.findById(id);
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

	@Override
	public void update(Zone o) {
		zoneRepository.save(o);
	}

	@Override
	public void delete(Zone o) {
		zoneRepository.delete(o);
	}

	@Override
	public Zone save(Zone o) {
		return zoneRepository.save(o);
	}

	public List<Zone> findByVille(Ville villeName) {
		return zoneRepository.findByVille(villeName);
	}

}
