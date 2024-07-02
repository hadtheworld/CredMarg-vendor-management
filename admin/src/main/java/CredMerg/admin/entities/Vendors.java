package CredMerg.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendors {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long vendorId;
	
	@Column(nullable = false)
	private String vadorName;
	
	@Column(nullable = false, unique= true)
	private String vendorEmail;
	
	@Column(nullable = false)
	private String upi;

	public Vendors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendors(String vadorName, String vendorEmail, String upi) {
		super();
		this.vadorName = vadorName;
		this.vendorEmail = vendorEmail;
		this.upi = upi;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVadorName() {
		return vadorName;
	}

	public void setVadorName(String vadorName) {
		this.vadorName = vadorName;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", vadorName=" + vadorName + ", vendorEmail=" + vendorEmail + ", upi="
				+ upi + "]";
	}
}