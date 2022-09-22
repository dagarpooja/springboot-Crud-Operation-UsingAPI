package com.advance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advance.model.Student;
import com.advance.service.StudentService;

@RestController
@RequestMapping("/stuApi")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/check")			//HTTP method (GET)
	public String checkService() {
		return "welcome to world of webservices";
	}
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody Student student) {
		
		System.out.println(student);
		service.createStudent(student);
		
		return "created";
	}
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student st = service.getStudent(id);
		
		return st;
		
		
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		service.deleteStudent(id);
		return "Deleted"; 
	}
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		
		service.updateStudent(student);
		return "Updated";
	}

}
