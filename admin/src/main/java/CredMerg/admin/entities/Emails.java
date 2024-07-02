package CredMerg.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eId; 
	
	@Column(columnDefinition="TEXT")
	private String emialSent;
	
	public Emails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emails(String emialSent, Vendors vendor) {
		super();
		this.emialSent = emialSent;
		this.vendor = vendor;
	}

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="vendor_id")
	@JsonIgnore
	private Vendors vendor;

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getEmialSent() {
		return emialSent;
	}

	public void setEmialSent(String emialSent) {
		this.emialSent = emialSent;
	}

	public Vendors getVendor() {
		return vendor;
	}

	public void setVendor(Vendors vendor) {
		this.vendor = vendor;
	}
}
