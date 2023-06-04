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


import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.service.UtilisateurRoleService;
/*
@RestController
@RequestMapping("api/utilisateurRoleList")
public class UtilisateurRoleController {
	
	@Autowired
	private UtilisateurRoleService utilisateurRoleService;
	
	@PostMapping("/save")
	public void save(@RequestBody UtilisateurRole utilisateurRole){
		utilisateurRoleService.save(utilisateurRole);
	}

	@PostMapping("/update")
	public void update(@RequestBody UtilisateurRole utilisateurRole){
		utilisateurRoleService.save(utilisateurRole);
	}
	
	@DeleteMapping("/delete/utilisateur/{idUtilisateur}/role/{idRole}")
	public void delete(@PathVariable (required = true) String idUtilisateur,@PathVariable (required = true) String idRole){
		List<UtilisateurRole> utilisateurRoleList = utilisateurRoleService.findAll();
	    UtilisateurRole utilisateurRole = utilisateurRoleList.stream()
	            .filter(item -> item.getPk().getRole() == Integer.parseInt(idRole) && item.getPk().getUtilisateur() == Integer.parseInt(idUtilisateur))
	            .findFirst().orElse(null);
	    if (utilisateurRole != null) {
	        utilisateurRoleService.delete(utilisateurRole);
	    }
	}
	
	@GetMapping("")
	public List<UtilisateurRole> findAll(){
		return utilisateurRoleService.findAll();
	}
}*/
