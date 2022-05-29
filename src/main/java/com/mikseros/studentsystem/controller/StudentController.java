package com.mikseros.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikseros.studentsystem.model.Student;
import com.mikseros.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "New student is added";
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		Student student = studentService.findStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		studentService.findStudentById(id);
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,
												 @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
}
