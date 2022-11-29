package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.StudentEntity;
import com.cg.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public StudentEntity registerStudent(StudentEntity student) {
		return studentRepository.save(student);
	}
}
