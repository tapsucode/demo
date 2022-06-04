package edu.poly.fpt.reponsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.fpt.models.Depart;

@Repository
public interface DepartReponsitory extends CrudRepository<Depart, Integer> {
	List<Depart> findByNameLikeOrderByName(String name);
}
