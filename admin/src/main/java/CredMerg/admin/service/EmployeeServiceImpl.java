package CredMerg.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CredMerg.admin.dao.EmployeeDao;
import CredMerg.admin.entities.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employees addEmployee(Employees employee) {
		// TODO Auto-generated method stub
		this.employeeDao.save(employee);
		return employee;
	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeDao.findAll();
	}

}
