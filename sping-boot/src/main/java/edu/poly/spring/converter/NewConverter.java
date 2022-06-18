package edu.poly.spring.converter;

import org.springframework.stereotype.Component;

import edu.poly.spring.dto.NewDTO;
import edu.poly.spring.entity.New;



@Component
public class NewConverter {
	public New toEntity(NewDTO dto) {
		New entity = new New();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShorDescription());
		entity.setThumbnail(dto.getThunbnail());
		return entity;
	}
	
	public NewDTO toDTO(New entity) {
		NewDTO dto = new NewDTO();
		if ((Long) entity.getId() != null ) {
			
		}
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShorDescription(entity.getShortDescription());
		dto.setThunbnail(entity.getThumbnail());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public New toEntity(NewDTO dto, New entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShorDescription());
		entity.setThumbnail(dto.getThunbnail());
		return entity;
	}
}
