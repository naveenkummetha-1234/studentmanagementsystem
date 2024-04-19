package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImp implements StudentService{
    private StudentRepository studentrepo;
    
	public StudentServiceImp(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentrepo.findAll() ;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id).get() ;
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(id);
	}

}
