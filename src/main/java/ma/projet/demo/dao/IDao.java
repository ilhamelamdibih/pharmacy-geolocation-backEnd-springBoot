package ma.projet.demo.dao;

import java.util.List;


public interface IDao <T> {
	T findById(int id);
	List<T> findAll();
	void update(T o);
	void delete(T o);
	T save (T o);
}
