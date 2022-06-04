package edu.poly.fpt.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.fpt.models.Depart;
import edu.poly.fpt.models.Staff;
import edu.poly.fpt.reponsitory.DepartReponsitory;
import edu.poly.fpt.reponsitory.StaffReponsitory;
import edu.poly.fpt.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffReponsitory staffReponsitory;
	
	@Autowired
	private DepartReponsitory departReponsitory;
	
	@Override
	public List<Depart> findAllDeparts(){
		return (List<Depart>) departReponsitory.findAll();
	}
	
	@Override
	public Staff save(Staff entity) {
		return staffReponsitory.save(entity);
	}

	@Override
	public List<Staff> saveAll(Iterable<Staff> entities) {
		return (List<Staff>) staffReponsitory.saveAll(entities);
	}

	@Override
	public Optional<Staff> findById(Long id) {
		return staffReponsitory.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return staffReponsitory.existsById(id);
	}

	@Override
	public Iterable<Staff> findAll() {
		return staffReponsitory.findAll();
	}

	@Override
	public Iterable<Staff> findAllById(Iterable<Long> ids) {
		return  staffReponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return staffReponsitory.count();
	}

	@Override
	public void deleteById(Long id) {
		staffReponsitory.deleteById(id);
	}

	@Override
	public void delete(Staff entity) {
		staffReponsitory.delete(entity);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		staffReponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Staff> entities) {
		staffReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffReponsitory.deleteAll();
	}
	
}
