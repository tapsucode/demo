package edu.poly.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.spring.converter.NewConverter;
import edu.poly.spring.dto.NewDTO;
import edu.poly.spring.entity.New;
import edu.poly.spring.reponsitory.CategoryRepository;
import edu.poly.spring.reponsitory.NewReponsitory;
import edu.poly.spring.service.INewService;



@Service
public class NewService implements INewService {
	
	@Autowired
	private NewReponsitory newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		New New = new New();
		if (newDTO.getId() != null) {
//			New oldNew = newRepository.findById(newDTO.getId());
			Optional<New> oldNew = newRepository.findById(newDTO.getId());
			New = newConverter.toEntity(newDTO, oldNew);
		} else {
			New = newConverter.toEntity(newDTO);
		}
		edu.poly.spring.entity.Category category = categoryRepository.findOneByCode(null);
		New.setCategory();;
		New = newRepository.save(New);
		return newConverter.toDTO(New);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			newRepository.deleteById(item);
		}
	}

	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<New> entities = newRepository.findAll(pageable).getContent();
		for (New item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	
}