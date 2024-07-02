package CredMerg.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employees {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long empId;
	
	@Column(nullable=false)
	private String empName;
	
	@Column(nullable=false,unique=true)
	private String empEmail;
	
	@Column(nullable=false)
	private String empDesignation;
	
	@Column(nullable=false)
	private long empCTC;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees( String empName, String empEmail, String empDesignation, long empCTC) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empDesignation = empDesignation;
		this.empCTC = empCTC;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public long getEmpCTC() {
		return empCTC;
	}

	public void setEmpCTC(long empCTC) {
		this.empCTC = empCTC;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empDesignation="
				+ empDesignation + ", empCTC=" + empCTC + "]";
	}
}
