package com.advance.service;

import com.advance.model.Student;

public interface StudentService {

	void createStudent(Student student);

	Student getStudent(int id);

	void deleteStudent(int id);

	void updateStudent(Student student);

}
