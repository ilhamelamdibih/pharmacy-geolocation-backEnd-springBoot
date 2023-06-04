package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.entities.UtilisateurRole;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.service.PharmacieGardeService;
import ma.projet.demo.service.PharmacieService;
import ma.projet.demo.service.ZoneService;

@RestController
@RequestMapping("api/zones")
@CrossOrigin(origins="http://localhost:3000")
public class ZoneController {
	
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private PharmacieService pharmacieService;
	
	@Autowired
	private PharmacieGardeService pharmacieGardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody Zone zone){
		zoneService.save(zone);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Zone zone){
		Zone getZone = zoneService.findById(zone.getId());
		if (getZone != null)
			zoneService.save(zone);
		else 
			throw new RuntimeException("zone not found with id: " + zone.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Zone zone = zoneService.findById(Integer.parseInt(id));
		//Delete all list of pharmacies of this zone 
		List<Pharmacie> pharmacies = pharmacieService.findByZone(zone);
			if (pharmacies != null && !pharmacies.isEmpty()) {
				for (Pharmacie pharmacie : pharmacies) {
					//Delte all pharmcie from pharmacie_garde
					List<PharmacieGarde> pharmacieGardeList = pharmacieGardeService.findByPharmacie(pharmacie);
					if (pharmacieGardeList != null && !pharmacieGardeList.isEmpty()) {
					 	for (PharmacieGarde pharmacieGarde : pharmacieGardeList) {
					 		pharmacieGardeService.delete(pharmacieGarde);
				        }
				    }
					pharmacieService.delete(pharmacie);
				      }
				  }
			zoneService.delete(zone);
	}
	
	@GetMapping("")
	public List<Zone> findAll(){
		return zoneService.findAll();
	}

}
