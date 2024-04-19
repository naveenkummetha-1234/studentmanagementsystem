package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	//handler method to handle list student and return mode and view
	@GetMapping("/student")
	public String listStudents(Model model) {
		model.addAttribute("student",studentservice.getAllStudents());
		return "student";
		
	}
	@GetMapping("/student/new")
	public String createStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
		
		
	}
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("student")Student student) {
		studentservice.saveStudent(student);
		return "redirect:/student";
		
	}
	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentservice.getStudentById(id));
		return "edit_student";
		
		
	}
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student existingStudent=studentservice.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentservice.updateStudent(existingStudent);
		return  "redirect:/student";
		
		
	}
	@GetMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deleteStudentById(id);
		return "redirect:/student";
	}
	

}