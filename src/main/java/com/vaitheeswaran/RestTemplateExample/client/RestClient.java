package com.vaitheeswaran.RestTemplateExample.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vaitheeswaran.RestTemplateExample.model.Student;
import com.vaitheeswaran.RestTemplateExample.model.StudentList;
import com.vaitheeswaran.RestTemplateExample.repository.StudentRepository;
import com.vaitheeswaran.RestTemplateExample.util.XmlParser;

public class RestClient {
//	@Autowired
//	RestTemplate restTemplate;
	
	
	
	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		XmlParser parser = new XmlParser();
		String url = "https://2ad28c19-8db6-4ca1-95d8-829c175003a3.mock.pstmn.io/students";
		String url_single = "https://2ad28c19-8db6-4ca1-95d8-829c175003a3.mock.pstmn.io/student/{rollno}";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		Student[] objects = restTemplate.exchange(url, HttpMethod.GET, entity, Student[].class).getBody();
//		System.out.println(objects[0].getName());
//		List<Student> student = restTemplate.getForObject(url, List.class);
//		System.out.println(student);
//		Map<String,Integer> param = new HashMap<String,Integer>();
//		param.put("rollno", 100);
//		Student student = restTemplate.getForObject(url_single, Student.class,param);
//		System.out.println(student);
//		StudentList students = restTemplate.getForObject(url, StudentList.class);
//		System.out.println(students);
//		StudentRepository repo = new StudentRepository(students.getStudents());
//		System.out.println(repo.toMap());
		String xml_data = restTemplate.getForObject(url, String.class);
		//System.out.println(xml_data);
		
		String exp = "/students/student[@rollno=101]";
		//List<String> student = parser.evaluateXPath(parser.createDocument(xml_data), exp);
		Map<String,String> studentMap = parser.evaluateXPathToMap(parser.createDocument(xml_data), exp);
		System.out.println(studentMap);
		
	}
}
