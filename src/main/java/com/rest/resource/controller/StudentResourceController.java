package com.rest.resource.controller;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * 
 * @author bhaskara.vallapu
 *
 *@pathVariable:
 *
 *This is used to bind the value of the @pathvairable to method parameter.
 *
 */
@RestController
public class StudentResourceController {

	@RequestMapping(value = "/student/{id}", headers = { "Accept=application/json", "Accept=application/xml" })
	public ResponseEntity<StudentVo> getStudentById(@PathVariable String id) {
		StudentVo s = new StudentVo();
		s.setId(id);
		s.setName("Bhaskar");
		s.setUniversity("SKU");
		if (s.getId().equals("12")) {
			System.out.println("student is found ::" + s.getId());
		} else {
			throw new StudentNotFoundException("Invalid Student id requested");
		}
		return new ResponseEntity<StudentVo>(s, HttpStatus.OK);

	}
	
	

	@RequestMapping(value = "/student", headers = { "Accept=application/json", "Accept=application/xml" })
	public ResponseEntity<StudentVo> getStudentByName(@QueryParam(value = "id") String id) {
		StudentVo s = new StudentVo();
		s.setId(id);
		s.setName("Bhaskar");
		s.setUniversity("SKU");
		if (s.getId().equals("12")) {
			System.out.println("student is found ::" + s.getId());
		} else {
			throw new StudentNotFoundException("Invalid Student id requested");
		}
		return new ResponseEntity<StudentVo>(s, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/student", headers = { "Accept=application/json", "Accept=application/xml" })
	public ResponseEntity<StudentVo> getStudentByIdMatrixParam(@MatrixParam(value = "id") String id,@MatrixParam(value = "name") String name) {
		StudentVo s = new StudentVo();
		s.setId(id);
		s.setName(name);
		s.setUniversity("SKU");
		if (s.getId().equals("12")) {
			System.out.println("student is found ::" + s.getId());
		} else {
			throw new StudentNotFoundException("Invalid Student id requested");
		}
		return new ResponseEntity<StudentVo>(s, HttpStatus.OK);

	}

	
	@RequestMapping(value = "/students")
	public StudentListVo getStudents() {
		StudentListVo svo = new StudentListVo();
		StudentVo s1 = new StudentVo();
		s1.setId("25");
		s1.setName("bhaskar");
		s1.setUniversity("SVU");
		StudentVo s2 = new StudentVo();
		s2.setId("26");
		s2.setName("Raja");
		s2.setUniversity("JNTU");
		StudentVo s3 = new StudentVo();
		s3.setId("27");
		s3.setName("Ramana");
		s3.setUniversity("SKU");
		StudentVo s4 = new StudentVo();
		s4.setId("28");
		s4.setName("Prasad");
		s4.setUniversity("AU");

		svo.getStudents().add(s1);
		svo.getStudents().add(s2);
		svo.getStudents().add(s3);
		svo.getStudents().add(s4);

		return svo;

	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Error> exceptionHandler(Exception ex) {
		Error error = new Error();
		error.setCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		error.setDescription("Requested Student id not found in the system");
		error.setLink("https://localhost:2018//myapp");
		return new ResponseEntity<Error>(error, HttpStatus.OK);
	}

}
