package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.Utilisateur;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.service.PharmacieService;
import ma.projet.demo.service.UtilisateurRoleService;
import ma.projet.demo.service.UtilisateurService;
/*
@RestController
@RequestMapping("api/utilisateurs")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private UtilisateurRoleService utilisateurRoleService;
	
	@Autowired
	private PharmacieService pharmacieService;
	
	@PostMapping("/save")
	public void save(@RequestBody Utilisateur utilisateur){
		utilisateurService.save(utilisateur);
	}

	@PostMapping("/update")
	public void update(@RequestBody Utilisateur utilisateur){
		Utilisateur getUtilisateur = utilisateurService.findById(utilisateur.getId());
		if (getUtilisateur != null)
			utilisateurService.save(utilisateur);
		else 
			throw new RuntimeException("utilisateur not found with id: " + utilisateur.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Utilisateur utilisateur = utilisateurService.findById(Integer.parseInt(id));
		
		//Delete utilisateur from utilisateur_role
		List<UtilisateurRole> utilisateurRoleList = utilisateurRoleService.findByUtilisateur(utilisateur);
		 if (utilisateurRoleList != null && !utilisateurRoleList.isEmpty()) {
			 	for (UtilisateurRole utilisateurRole : utilisateurRoleList) {
			 		utilisateurRoleService.delete(utilisateurRole);
		        }
		    }
		 
		//Delete all list of pharmacies of this utilisateur 
		List<Pharmacie> pharmacies = pharmacieService.findByUtilisateur(utilisateur);

		 if (pharmacies != null && !pharmacies.isEmpty()) {
			 	for (Pharmacie pharmacie : pharmacies) {
			 		pharmacieService.delete(pharmacie);
		        }
		    }
		 
		 utilisateurService.delete(utilisateur);
	}
	
	@GetMapping("")
	public List<Utilisateur> findAll(){
		return utilisateurService.findAll();
		
	}
}
*/