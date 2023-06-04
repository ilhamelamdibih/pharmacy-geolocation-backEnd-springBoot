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

import ma.projet.demo.entities.Photo;
import ma.projet.demo.service.PhotoService;

@RestController
@RequestMapping("api/photos")
public class PhotoController {
	@Autowired
	private PhotoService photoService;
	
	@PostMapping("/save")
	public void save(@RequestBody Photo photo){
		photoService.save(photo);
	}

	@PostMapping("/update")
	public void update(@RequestBody Photo photo){
		Photo getPhoto = photoService.findById(photo.getId());
		if (getPhoto != null)
			photoService.save(photo);
		else 
			throw new RuntimeException("photo not found with id: " + photo.getId());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Photo photo = photoService.findById(Integer.parseInt(id));
		/*
		List<UtilisateurRole> utilisateurRoleList = roleService.findByRole(role);
		 if (zones != null && !zones.isEmpty()) {
			 	for (Zone zone : zones) {
		            //zoneService.delete(zone); //to delete the Zones
		            zone.setVille(null); // Update Ville reference to null
		            zoneService.save(zone);
		        }
		    }
		    */
		photoService.delete(photo);
	}
	
	@GetMapping("")
	public List<Photo> findAll(){
		return photoService.findAll();
	}
}
