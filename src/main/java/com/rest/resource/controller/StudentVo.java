package com.rest.resource.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class StudentVo {
	
	private String id;

	private String name;
	
	private String  university;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	
	

}
