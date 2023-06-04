package ma.projet.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.service.RoleService;
import ma.projet.demo.service.UtilisateurRoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UtilisateurRoleService utilisateurRoleService;
	
	@PostMapping("/save")
	public void save(@RequestBody Role role){
		roleService.save(role);
	}

	@PostMapping("/update")
	public void update(@RequestBody Role role){
		Role getRole = roleService.findById(role.getId());
		if (getRole != null)
			roleService.save(role);
		else 
			throw new RuntimeException("zone not found with id: " + role.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Role role = roleService.findById(Integer.parseInt(id));
		List<UtilisateurRole> utilisateurRoleList = utilisateurRoleService.findByRole(role);
		 if (utilisateurRoleList != null && !utilisateurRoleList.isEmpty()) {
			 	for (UtilisateurRole utilisateurRole : utilisateurRoleList) {
			 		utilisateurRoleService.delete(utilisateurRole);
		        }
		    }
		roleService.delete(role);
	}
	
	@GetMapping("")
	public List<Role> findAll(){
		return roleService.findAll();
	}

}
