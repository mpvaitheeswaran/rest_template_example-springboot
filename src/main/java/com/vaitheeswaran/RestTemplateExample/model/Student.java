package com.vaitheeswaran.RestTemplateExample.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.NONE)
public class Student {
	@XmlAttribute(name="rollno")
	private int rollNo;
	@XmlElement(name="name")
    private String name;
	@XmlElement(name="dept")
    private String dept;
	@XmlElement(name="age")
    private int age;
    
    public Student() {}
	public Student(int rollNo, String name, String dept, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	@Override
	public String toString() {
		return "Roll No:"+getRollNo()+","+"Name:"+getName()+","+"Department:"+getDept()+","+"Age:"+getAge();
	}
}
