package com.tseringkalden.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tseringkalden.license.models.License;
import com.tseringkalden.license.models.Person;
import com.tseringkalden.license.repositories.LicenseRepo;
import com.tseringkalden.license.repositories.PersonRepo;

@Service
public class LicenseService {
	
	private final LicenseRepo licenserepo;
	private final PersonRepo personrepo;
    public static int licenseNumber;
	
	public LicenseService(LicenseRepo licenserepo, PersonRepo personrepo) {
		
		this.licenserepo = licenserepo;
		this.personrepo = personrepo;
		
	}
	
	public static Integer getLicenseNumber() {
		return licenseNumber;
	}

	public static void setLicenseNumber(Integer licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}

	public Person addPerson(Person person) {
		return personrepo.save(person);
	}
	
	public List<Person> allPersons() {
		return personrepo.findAll();
	}
	
	public License addLicense(License license){
		
		return licenserepo.save(license);
	}
	
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	public String generateLicenseNumber() {
		if(licenserepo.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber); 
		}
		else {
			List<License> top = licenserepo.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber); 
		}
		
	}
	
	public Optional<License> getLicense(Long id) {
		return licenserepo.findById(id);
	}
	
	
}