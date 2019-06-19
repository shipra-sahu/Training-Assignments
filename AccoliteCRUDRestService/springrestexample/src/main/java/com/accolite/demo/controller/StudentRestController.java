package com.accolite.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.accolite.demo.model.Student;

@RestController
public class StudentRestController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.GET,produces = "application/xml")
	public ResponseEntity<List<Student>> listAllStudent() {
		List<Student> student = studentService.findAllStudent();
		if (student.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Student> getStudent(@PathVariable("rollno") long rollno) {
		System.out.println("Fetching Student with rollno " + rollno);
		Student student = studentService.findByRollno(rollno);
		if (student == null) {
			System.out.println("Student with rollno " + rollno + " not found");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST,consumes = "application/xml")
	public ResponseEntity<Void> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating " + " " + student.getName());

		if (studentService.isStudentExist(student)) {
			System.out.println("A Student with name " + student.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/student/{rollno}").buildAndExpand(student.getRollNo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.PUT,consumes = "application/json")
	public ResponseEntity<Student> updateStudent(@PathVariable("rollno") long rollno,@RequestBody Student student) {
		System.out.println("Updating Student " + rollno);

		Student currentStudent = studentService.findByRollno(rollno);

		if (currentStudent == null) {
			System.out.println("Student with rollno " + rollno + " not found");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		currentStudent.setName(student.getName());
		currentStudent.setDob(student.getDob());
		currentStudent.setRollNo(student.getRollNo());

		studentService.updateStudent(currentStudent);
		return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.DELETE,produces = "application/xml")
	public ResponseEntity<Student> deleteStudent(@PathVariable("rollno") long rollno) {
		System.out.println("Fetching & Deleting Student with rollno " + rollno);

		Student student = studentService.findByRollno(rollno);
		if (student == null) {
			System.out.println("Unable to delete. Student with rollno " + rollno + " not found");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		Student deteledStudent = new Student();
		deteledStudent.setRollNo(student.getRollNo());
		deteledStudent.setName(student.getName());
		deteledStudent.setDob(student.getDob());
		System.out.println(deteledStudent.getRollNo()+" "+deteledStudent.getName()+" "+deteledStudent.getDob());	
		studentService.deleteStudentByRollno(rollno);
		return new ResponseEntity<Student>(deteledStudent,HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents() {
		System.out.println("Deleting All Students");

		studentService.deleteAllStudent();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
}