package edu.poly.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorys")
public class Category extends BaseEntity {
	
	@Column(length = 255,name = "code",unique = true)
	private String code;
	
	@Column(length = 255,name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<New> news = new ArrayList<>();

	public List<New> getNews() {
		return news;
	}

	public void setNews(List<New> news) {
		this.news = news;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
