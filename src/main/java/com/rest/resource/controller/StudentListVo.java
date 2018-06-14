package com.rest.resource.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="studentsListVo")
public class StudentListVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private List<StudentVo> students = new ArrayList<StudentVo>();


	public List<StudentVo> getStudents() {
		return students;
	}


	public void setStudents(List<StudentVo> students) {
		this.students = students;
	}


		
	
	
	
	

}
