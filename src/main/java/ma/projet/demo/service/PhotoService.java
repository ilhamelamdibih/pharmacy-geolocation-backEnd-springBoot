package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Photo;
import ma.projet.demo.repositories.PhotoRepository;
@Service
public class PhotoService implements IDao<Photo>{

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo findById(int id) {
		return photoRepository.findById(id);
	}

	@Override
	public List<Photo> findAll() {
		return photoRepository.findAll();
	}

	@Override
	public void update(Photo o) {
		photoRepository.save(o);
		
	}

	@Override
	public void delete(Photo o) {
		photoRepository.delete(o);
		
	}

	@Override
	public Photo save(Photo o) {
		return photoRepository.save(o);
	}

}
