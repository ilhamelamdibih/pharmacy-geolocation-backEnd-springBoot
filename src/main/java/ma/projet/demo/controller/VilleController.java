package ma.projet.demo.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Garde;
import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.service.GardeService;
import ma.projet.demo.service.PharmacieGardeService;
import ma.projet.demo.service.PharmacieService;
import ma.projet.demo.service.VilleService;
import ma.projet.demo.service.ZoneService;

@RestController
@RequestMapping("api/villes")
@CrossOrigin(origins="http://localhost:3000")
public class VilleController  {
	@Autowired
	private VilleService villeService;
	
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private PharmacieService pharmacieService;
	
	@Autowired
	private GardeService gardeService;
	
	@Autowired
	private PharmacieGardeService pharmacieGardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody Ville ville){
		villeService.save(ville);
	}
	@PostMapping("/update")
	public void update(@RequestBody Ville ville){
		Ville getVille = villeService.findById(ville.getId());
		if (getVille != null)
			villeService.save(ville);
		else 
			throw new RuntimeException("ville not found with id: " + ville.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Ville ville = villeService.findById(Integer.parseInt(id));
		List<Zone> zones = zoneService.findByVille(ville);
		 if (zones != null && !zones.isEmpty()) {
			 	for (Zone zone : zones) {
		            zoneService.delete(zone); //to delete the Zones
		            //zone.setVille(null); // Update Ville reference to null
		            //zoneService.save(zone);
		        }
		    }
		villeService.delete(ville);
	}
	
	@GetMapping("")
	public List<Ville> findAll(){
		return villeService.findAll();
	}
	
	@GetMapping("{ville}/zones")
		public List<Zone> findZoneByVille(@PathVariable (required = true) String ville){
		Ville villeName= villeService.findByNom(ville);
		return zoneService.findByVille(villeName);
	}
	@GetMapping("idVille/{idVille}/zones")
	public List<Zone> findZoneByIdVille(@PathVariable (required = true) String idVille){
	Ville villeId= villeService.findById(Integer.parseInt(idVille));
	return zoneService.findByVille(villeId);
	}
	
	@GetMapping("/{ville}/zones/{zone}/pharmacies")
		public List<Pharmacie> findPharmacieByVilleZone(@PathVariable (required = true) String ville,@PathVariable (required = true) String zone )
		{
			List<Zone> zoneList = findZoneByVille(ville);
			Zone zoneName = zoneList.stream()
			                        .filter(zonetR -> zonetR.getNom().equals(zone))
			                        .findFirst()
			                        .orElse(null);
			return pharmacieService.findByZone(zoneName);
		}
	
	@GetMapping("/{ville}/zones/{zone}/pharmacies/garde")
	public List<Pharmacie> getPharmaciesWithType(@PathVariable (required = true) String ville,@PathVariable (required = true) String zone ,@RequestParam("periode") String periode) {
	    /*
			List<Pharmacie> pharmacieList = findPharmacieByVilleZone(ville,zone);
	    	Garde garde = gardeRepository.findByType(periode);
	    	List<PharmacieGarde> pharmacieGardeList = pharmacieGardeRepository.findByGarde(garde);
	    	
	    	List<Pharmacie> pharmacieTest = new ArrayList<Pharmacie>() ;
	    	Date dateToCompare = new Date();
	    	for (PharmacieGarde item : pharmacieGardeList)
	    	{
	    		if(pharmacieList.contains(item.getPharmacie()))
	    		{
	    			if(item.getPk().getDateDebut().compareTo(dateToCompare)<= 0 && item.getDateFin().compareTo(dateToCompare)>=0)
	    				pharmacieTest.add(item.getPharmacie());
	    		}	
	    	}
	        return pharmacieTest;  
	       */     
	        ////////
		
	        List<Pharmacie> pharmacieList = findPharmacieByVilleZone(ville, zone);
	        Garde garde = gardeService.findByType(periode);
	        List<PharmacieGarde> pharmacieGardeList = pharmacieGardeService.findByGarde(garde);
	      //  Date dateToCompare = new Date();
	        return pharmacieGardeList.stream()
	                .filter(item -> pharmacieList.contains(item.getPharmacie()))
	                .filter(item -> item.getPk().getDateDebut().compareTo(new Date()) <= 0 && item.getDateFin().compareTo(new Date()) >= 0)
	                .map(PharmacieGarde::getPharmacie)
	                .collect(Collectors.toList());
	        
	}
}
