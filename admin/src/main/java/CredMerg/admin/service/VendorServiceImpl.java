package CredMerg.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CredMerg.admin.dao.EmailDao;
import CredMerg.admin.dao.VendorDao;
import CredMerg.admin.entities.Emails;
import CredMerg.admin.entities.Vendors;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private EmailDao emailDao;
	
	@Override
	public Vendors addVendor(Vendors vendor) {
		// TODO Auto-generated method stub
		return this.vendorDao.save(vendor);
	}

	@Override
	public List<Vendors> getAllVedors() {
		// TODO Auto-generated method stub
		return this.vendorDao.findAll();
	}

	@Override
	public List<Emails> getAllEmails(long vendorId) {
		// TODO Auto-generated method stub
		return this.emailDao.findEmailsByVendorVendorId(vendorId);
	}

	@Override
	public Emails sendEmail(Emails email, long vendorId) {
		// TODO Auto-generated method stub
		Emails mail=this.vendorDao.findById(vendorId).map(vendor ->{
			email.setVendor(vendor);
			this.emailDao.save(email);
			return email;
		}).get();
		return mail;
	}

}
