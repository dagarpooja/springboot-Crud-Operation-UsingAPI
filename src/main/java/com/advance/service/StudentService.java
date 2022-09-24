package com.advance.service;

import java.util.List;

import com.advance.model.Student;

public interface StudentService {

	Student createStudent(Student students);

	Student getStudent(int id);

	void deleteStudent(int id);

	void updateStudent(Student student);

	List<Student> findAllStudent();


}
