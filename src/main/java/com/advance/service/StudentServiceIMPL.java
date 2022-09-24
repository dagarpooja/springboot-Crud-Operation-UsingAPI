package com.advance.service;

import java.util.List;
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
	public Student createStudent(Student student) {

		 student =repo.save(student);
		System.out.println("student inserted through service");
		return student;
	}

	@Override
	public Student getStudent(int id) {

		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent())
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

	@Override
	public List<Student> findAllStudent() {

		return repo.findAll();

	}
}
		


