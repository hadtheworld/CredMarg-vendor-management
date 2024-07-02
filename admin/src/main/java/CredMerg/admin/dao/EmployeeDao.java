package CredMerg.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import CredMerg.admin.entities.Employees;

public interface EmployeeDao extends JpaRepository<Employees, Long>{

}
