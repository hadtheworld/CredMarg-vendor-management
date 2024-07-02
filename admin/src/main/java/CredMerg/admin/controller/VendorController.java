package CredMerg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CredMerg.admin.entities.Emails;
import CredMerg.admin.entities.Vendors;
import CredMerg.admin.service.VendorService;

@RestController
@CrossOrigin
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@GetMapping
	public ResponseEntity<List<Vendors>> getAllVendors() {
		return new ResponseEntity<>(this.vendorService.getAllVedors(),HttpStatus.OK); 
	}
	
	@GetMapping("/{vendorId}/email")
	public ResponseEntity<List<Emails>> getAllEmails(@PathVariable long vendorId){
		return new ResponseEntity<>(this.vendorService.getAllEmails(vendorId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Vendors> addNewVendor(@RequestBody Vendors vendor){
		return new ResponseEntity<>(this.vendorService.addVendor(vendor),HttpStatus.OK);
	}
	
	@PostMapping("/{vendorId}/email")
	public ResponseEntity<Emails> sendEmail(@PathVariable long vendorId,@RequestBody Emails email){
		return new ResponseEntity<>(this.vendorService.sendEmail(email, vendorId),HttpStatus.OK);
	}
}
