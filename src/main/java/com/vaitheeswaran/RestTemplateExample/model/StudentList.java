package com.vaitheeswaran.RestTemplateExample.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
@XmlAccessorType(XmlAccessType.NONE)
public class StudentList {
	@XmlElement(name="student")
	List<Student> students;

	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
