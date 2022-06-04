package edu.poly.fpt.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.fpt.models.Depart;
import edu.poly.fpt.reponsitory.DepartReponsitory;
import edu.poly.fpt.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartReponsitory departReponsitory;

	@Override
	public Depart save(Depart entity) {
		return departReponsitory.save(entity);
	}

	@Override
	public List<Depart> saveAll(List<Depart> entities) {
		return (List<Depart>) departReponsitory.saveAll(entities);
	}

	@Override
	public Optional<Depart> findById(Integer id) {
		return departReponsitory.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return departReponsitory.existsById(id);
	}

	@Override
	public Iterable<Depart> findAll() {
		return departReponsitory.findAll();
	}

	@Override
	public List<Depart> findAllById(List<Integer> ids) {
		return (List<Depart>) departReponsitory.findAllById(ids);
	}
	
	@Override
	public List<Depart> findByNameLikeOrderByName(String name) {
		
		return departReponsitory.findByNameLikeOrderByName("%"+name+"%");
	}

	@Override
	public long count() {
		return departReponsitory.count();
	}

	@Override
	public void deleteById(Integer id) {
		departReponsitory.deleteById(id);
	}

	@Override
	public void delete(Depart entity) {
		departReponsitory.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		departReponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Depart> entities) {
		departReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		departReponsitory.deleteAll();
	}
}
