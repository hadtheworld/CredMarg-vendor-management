package CredMerg.admin.service;

import java.util.List;

import CredMerg.admin.entities.Emails;
import CredMerg.admin.entities.Vendors;

public interface VendorService {
	public Vendors addVendor(Vendors vendor);
	public List<Vendors> getAllVedors();
	public List<Emails> getAllEmails(long vendorId);
	public Emails sendEmail(Emails email,long vendorId);
}
