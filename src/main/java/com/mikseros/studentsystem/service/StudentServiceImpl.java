package com.mikseros.studentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikseros.studentsystem.model.Student;
import com.mikseros.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.findById(id).orElseThrow();
		studentRepository.deleteById(id);
	}

}
