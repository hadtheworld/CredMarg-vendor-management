package CredMerg.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CredMerg.admin.entities.Emails;

public interface EmailDao extends JpaRepository<Emails, Long>{
	
	public List<Emails> findEmailsByVendorVendorId(long vendorId);
}
