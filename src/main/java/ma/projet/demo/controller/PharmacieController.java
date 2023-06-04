package ma.projet.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import ma.projet.demo.Demo5Application;
import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.PharmacieGarde;
import ma.projet.demo.service.PharmacieGardeService;
import ma.projet.demo.service.PharmacieService;

@RestController
@RequestMapping("api/pharmacies")
@CrossOrigin(origins="http://localhost:3000")
public class PharmacieController {
	
	@Autowired
	private PharmacieService pharmacieService;
	@Autowired
	private PharmacieGardeService pharmacieGardeService;
	
	@PostMapping("/save")
	public void save(@RequestBody Pharmacie pharmacie){
		pharmacieService.save(pharmacie);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Pharmacie pharmacie){
		Pharmacie getPharmacie = pharmacieService.findById(pharmacie.getId());
		if (getPharmacie != null)
			pharmacieService.save(pharmacie);
		else 
			throw new RuntimeException("pharmacie not found with id: " + pharmacie.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Pharmacie pharmacie = pharmacieService.findById(Integer.parseInt(id));
		pharmacieService.delete(pharmacie);
	}
	
	@GetMapping("")
	public List<Pharmacie> findAll(){
		return pharmacieService.findAll();
	}
	
	@GetMapping("/{id}")
	public Pharmacie findPharmacieById(@PathVariable (required = true) String id){
		return pharmacieService.findById(Integer.parseInt(id));
	}
	
	@GetMapping("/withgardes")
	public List<Map<String, Object>> findAllWithGarde() {
	    List<Pharmacie> pharmacies = pharmacieService.findAll();
	    List<PharmacieGarde> pharmaciesGarde = pharmacieGardeService.findAll();

	    List<Map<String, Object>> result = new ArrayList<>();

	    for (Pharmacie pharmacie : pharmacies) {
	        Map<String, Object> pharmacyWithGarde = new HashMap<>();
	        pharmacyWithGarde.put("id", pharmacie.getId());
	        pharmacyWithGarde.put("nom", pharmacie.getNom());
	        pharmacyWithGarde.put("image", pharmacie.getImage());
	        pharmacyWithGarde.put("adresse", pharmacie.getAdresse());
	        pharmacyWithGarde.put("latitude", pharmacie.getLatitude());
	        pharmacyWithGarde.put("longitude", pharmacie.getLongitude());
	        pharmacyWithGarde.put("user", pharmacie.getUser());
	        pharmacyWithGarde.put("zone", pharmacie.getZone());
	        
	        
	        


				for (PharmacieGarde garde : pharmaciesGarde) {
				    if (garde.getPk().getPharmacie() == pharmacie.getId()) {
				        LocalDate currentDate = LocalDate.now();
				        String dateStringEnd = garde.getDateFin().toString();
				        LocalDate dateEnd = LocalDate.parse(dateStringEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				        String dateStringStart = garde.getPk().getDateDebut().toString();
				        
				        LocalDate dateStart = LocalDate.parse(dateStringStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				        
				        int startNum = dateStart.getYear() * 100 + dateStart.getMonthValue()*10 + dateStart.getDayOfMonth();
				        int endNum= dateEnd.getYear() * 100 + dateEnd.getMonthValue()*10 + dateEnd.getDayOfMonth();
				        int currentNum= currentDate.getYear() * 100 + currentDate.getMonthValue()*10 + currentDate.getDayOfMonth();

				 
				        
				        if (startNum <= currentNum && endNum>=currentNum) {
				        	System.out.println("dateStart -->3");
				            pharmacyWithGarde.put("gardeId", garde.getPk().getGarde());
				            break;
				        }
				        pharmacyWithGarde.put("gardeId", null);
				    }
				}
					        result.add(pharmacyWithGarde);
	    }

	    return result;
	}
	
	/*@GetMapping("/{id}/itineraire")
	public String findItineraire (@PathVariable (required = true) String id,@RequestParam("depart") String depart)
	{
		Pharmacie pharmacie =pharmacieService.findById(Integer.parseInt(id));
		
		double longitudePharmacie = pharmacie.getLongitude();
		double latitudePharmacie = pharmacie.getLatitude();
		
		String[] position = {depart,longitudePharmacie+","+latitudePharmacie};
		
		return Demo5Application.apiService.getJsonDataFromApi(position);	
		
	}*/
	
}
