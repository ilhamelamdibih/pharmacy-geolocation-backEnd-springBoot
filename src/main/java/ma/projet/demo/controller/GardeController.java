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

import ma.projet.demo.entities.Garde;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.service.GardeService;
import ma.projet.demo.service.PharmacieGardeService;

@RestController
@RequestMapping("api/gardes")
public class GardeController {
	@Autowired
	private GardeService gardeService;
	
	@Autowired
	private PharmacieGardeService pharmacieGardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody Garde garde){
		gardeService.save(garde);
	}

	@PostMapping("/update")
	public void update(@RequestBody Garde garde){
		Garde getGarde = gardeService.findById(garde.getId());
		if (getGarde != null)
			gardeService.save(garde);
		else 
			throw new RuntimeException("garde not found with id: " + garde.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Garde garde = gardeService.findById(Integer.parseInt(id));
		List<PharmacieGarde> pharmacieGardeList = pharmacieGardeService.findByGarde(garde);
		 if (pharmacieGardeList != null && !pharmacieGardeList.isEmpty()) {
			 	for (PharmacieGarde pharmacieGarde : pharmacieGardeList) {
			 		pharmacieGardeService.delete(pharmacieGarde);
		        }
		    }
		gardeService.delete(garde);
	}
	
	@GetMapping("")
	public List<Garde> findAll(){
		return gardeService.findAll();
	}
}
