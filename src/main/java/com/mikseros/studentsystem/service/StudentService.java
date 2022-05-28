package com.mikseros.studentsystem.service;

import java.util.List;

import com.mikseros.studentsystem.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
}
