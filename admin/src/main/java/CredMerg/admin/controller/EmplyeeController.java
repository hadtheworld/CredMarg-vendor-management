package CredMerg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CredMerg.admin.entities.Employees;
import CredMerg.admin.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmplyeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employees> addNewEmployee(@RequestBody(required=false) Employees employee){
	return new ResponseEntity<>(this.employeeService.addEmployee(employee),HttpStatus.OK);	
	}
	
	@GetMapping
	public ResponseEntity<List<Employees>> getAllEmployees(){
		return new ResponseEntity<>(this.employeeService.getAllEmployees(),HttpStatus.OK);
	}
}
