package com.mikseros.studentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikseros.studentsystem.exception.StudentNotFoundException;
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
		studentRepository.findById(id).orElseThrow(
				() -> new StudentNotFoundException());
		studentRepository.deleteById(id);
	}

	@Override
	public Student findStudentById(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException());
	}

	@Override
	public Student updateStudent(Student student, int id) {
		// check if this student exists in DB
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				() -> new StudentNotFoundException());
		// set the values from the request as a student attributes
		existingStudent.setName(student.getName());
		existingStudent.setAddress(student.getAddress());
		// save existing student to DB
		studentRepository.save(existingStudent);
		return existingStudent;
	}
}
