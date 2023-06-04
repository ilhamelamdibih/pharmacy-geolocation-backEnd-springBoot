package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.repositories.RoleRepository;


@Service
public class RoleService implements IDao<Role>{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findById(int id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public void update(Role o) {
		
		roleRepository.save(o);
		
	}

	@Override
	public void delete(Role o) {
		roleRepository.delete(o);
	}

	@Override
	public Role save(Role o) {
		return roleRepository.save(o);
	}


}
