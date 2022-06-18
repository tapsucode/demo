package edu.poly.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.poly.spring.dto.NewDTO;

public interface INewService {

	NewDTO save(NewDTO newDTO);

	void delete(long[] ids);

	List<NewDTO> findAll(Pageable pageable);

	int totalItem();

}
