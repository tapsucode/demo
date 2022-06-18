package edu.poly.spring.dto;

import edu.poly.spring.entity.New;

public class NewDTO extends AbstractDTO<New> {
	private String title;
	private String content;
	private String shorDescription;
	private String categoryCode;
	private String thunbnail;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShorDescription() {
		return shorDescription;
	}
	public void setShorDescription(String shorDescription) {
		this.shorDescription = shorDescription;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getThunbnail() {
		return thunbnail;
	}
	public void setThunbnail(String thunbnail) {
		this.thunbnail = thunbnail;
	}
	
	
}
