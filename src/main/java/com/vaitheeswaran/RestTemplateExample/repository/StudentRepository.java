package com.vaitheeswaran.RestTemplateExample.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaitheeswaran.RestTemplateExample.model.Student;

public class StudentRepository {
	List<Student> students;

	public StudentRepository(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Map<String,String>> toMap(){
		List<Map<String, String>> studentMapList = new ArrayList<Map<String, String>>();
        for(Student s : students){
            Map<String, String> studentsMap = new HashMap<String, String>();
            studentsMap.put("rollNo", String.valueOf(s.getRollNo()));
            studentsMap.put("name", s.getName());
            studentsMap.put("dept", s.getDept());
            studentsMap.put("age", String.valueOf(s.getAge()));
            studentMapList.add(studentsMap);
        }
        return studentMapList;
	}
	
	
}
