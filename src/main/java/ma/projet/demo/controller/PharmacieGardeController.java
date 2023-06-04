package ma.projet.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.service.PharmacieGardeService;
import ma.projet.demo.service.UtilisateurRoleService;

@RestController
@RequestMapping("api/pharmacieGardeList")
public class PharmacieGardeController {
	@Autowired
	private PharmacieGardeService pharmacieGardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody PharmacieGarde pharmacieGarde){
		pharmacieGardeService.save(pharmacieGarde);
	}

	@PostMapping("/update")
	public void update(@RequestBody PharmacieGarde pharmacieGarde){
		pharmacieGardeService.save(pharmacieGarde);
	}
	
	@DeleteMapping("/delete/dateDebut/{dateDebut}/garde/{idGarde}/pharmacie/{idPharmacie}")
	public void delete(@PathVariable (required = true) String dateDebut,@PathVariable (required = true) String idGarde,@PathVariable (required = true) String idPharmacie){
		List<PharmacieGarde> pharmacieGardeList = pharmacieGardeService.findAll();
	    @SuppressWarnings("unlikely-arg-type")
		PharmacieGarde pharmacieGarde = pharmacieGardeList.stream()
	            .filter(item -> item.getPk().getDateDebut().equals(LocalDate.parse(dateDebut)) && item.getPk().getGarde() == Integer.parseInt(idGarde) && item.getPk().getPharmacie() == Integer.parseInt(idPharmacie) )
	            .findFirst().orElse(null);
	    if (pharmacieGarde != null) {
	    	pharmacieGardeService.delete(pharmacieGarde);
	    }
	}
	
	@GetMapping("")
	public List<PharmacieGarde> findAll(){
		return pharmacieGardeService.findAll();
	}
}
