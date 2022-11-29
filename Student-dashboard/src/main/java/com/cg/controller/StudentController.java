package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.StudentEntity;
import com.cg.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public StudentEntity registerStudent(@RequestBody StudentEntity student) {
		return studentService.registerStudent(student);
	}

	@GetMapping("")
	@ResponseBody
	public String test() {
		return "ok";
	}
}
