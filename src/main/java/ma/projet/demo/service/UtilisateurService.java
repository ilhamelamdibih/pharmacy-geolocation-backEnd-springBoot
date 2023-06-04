package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.repositories.UtilisateurRepository;
@Service
public class UtilisateurService implements IDao<Utilisateur> {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur findById(int id) {
		return utilisateurRepository.findById(id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public void update(Utilisateur o) {
		utilisateurRepository.save(o);
	}

	@Override
	public void delete(Utilisateur o) {
		utilisateurRepository.delete(o);
	}

	@Override
	public Utilisateur save(Utilisateur o) {
		return utilisateurRepository.save(o);
	}
	
	

}
