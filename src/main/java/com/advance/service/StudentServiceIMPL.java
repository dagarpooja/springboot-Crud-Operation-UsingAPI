package com.advance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advance.Repository.StudentRepository;
import com.advance.model.Student;
@Service
public class StudentServiceIMPL implements StudentService {
	
	@Autowired
	private StudentRepository repo;
	@Override
	public void createStudent(Student student) {

		
		repo.save(student);
		System.out.println("student inserted through service");
	}
	@Override
	public Student getStudent(int id) {
		
		Optional <Student> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
		return null;
	}
	@Override
	public void deleteStudent(int id) {
		
		repo.deleteById(id);
		
	}
	@Override
	public void updateStudent(Student student) {

		repo.save(student);
	}

}
