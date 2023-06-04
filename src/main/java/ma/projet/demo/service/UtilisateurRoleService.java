package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.UtilisateurRolePK;
import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.repositories.UtilisateurRoleRepository;
@Service
public class UtilisateurRoleService  implements IDao<UtilisateurRole>{

	@Autowired
	private UtilisateurRoleRepository utilisateurRoleRepository;
	
	
	@Override
	public UtilisateurRole findById(int id) {
		return null;
	}
	
	public UtilisateurRole findBypk(UtilisateurRolePK pk) {
		return utilisateurRoleRepository.findByPk(pk);
	}
	
	@Override
	public List<UtilisateurRole> findAll() {
		return utilisateurRoleRepository.findAll();
	}

	@Override
	public void update(UtilisateurRole o) {
		utilisateurRoleRepository.save(o);
		
	}

	@Override
	public void delete(UtilisateurRole o) {
		utilisateurRoleRepository.delete(o);
		
	}

	@Override
	public UtilisateurRole save(UtilisateurRole o) {
		return utilisateurRoleRepository.save(o);
	}

	public List<UtilisateurRole> findByRole(Role role) {
		return utilisateurRoleRepository.findByRole(role);
	}

	public List<UtilisateurRole> findByUtilisateur(Utilisateur utilisateur) {
		return utilisateurRoleRepository.findByUtilisateur(utilisateur);
	}

}
