package CredMerg.admin.service;

import java.util.List;

import CredMerg.admin.entities.Employees;

public interface EmployeeService {
	public Employees addEmployee(Employees employee);
	public List<Employees> getAllEmployees();
}
