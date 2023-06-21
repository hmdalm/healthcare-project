package com.patient.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patient.healthcare.entity.Doctor;
import com.patient.healthcare.entity.Patient;
import com.patient.healthcare.pojo.ApiResponse;
import com.patient.healthcare.repo.DoctorTableRepo;

@RestController
public class DoctorController {
	@Autowired
	public DoctorTableRepo doctorTableRepo;

	@RequestMapping(value = "/doctor", method = { RequestMethod.POST })
	public ApiResponse createDoctor(@RequestBody Doctor doctor) {
 Doctor doc = new Doctor();
 System.out.println(doctor.isActive());
 doc.setFirstName(doctor.getFirstName());
 doc.setMiddleName(doctor.getMiddleName());
 doc.setLastName(doctor.getLastName());
 doc.setSpecialization(doctor.getSpecialization());
 doc.setActive(doctor.isActive());
		doctorTableRepo.save(doc);
		ApiResponse api = new ApiResponse();
		api.setData(doc);
		api.setValid(true);
		return api;

	}

	@RequestMapping(value = "/doctor/{doctorId}", method = { RequestMethod.PUT })
	public ApiResponse updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer doctorId) {
		Doctor doc = doctorTableRepo.getById(doctorId);
		if (doctor.getFirstName() != null) {
			doc.setFirstName(doctor.getFirstName());

		}
		if (doctor.getMiddleName() != null) {
			doc.setMiddleName(doctor.getMiddleName());

		}
		if (doctor.getLastName() != null) {
			doc.setLastName(doctor.getLastName());
		}
		if (doctor.getSpecialization() != null) {
			doc.setSpecialization(doctor.getSpecialization());
		}

		doctorTableRepo.save(doc);
		ApiResponse api = new ApiResponse();
		api.setData(doctor);
		api.setValid(true);
		return api;

	}

	@RequestMapping(value = "/doctor", method = { RequestMethod.DELETE })
	public ResponseEntity<String> deleteDoctor(@RequestParam Integer doctorId) {
		Doctor doc = doctorTableRepo.getById(doctorId);
		doc.setActive(false);
		doctorTableRepo.save(doc);
		ApiResponse api = new ApiResponse();
		api.setData(doc);
		api.setValid(true);
		return new ResponseEntity<String>("Doctor deleted successfully!.", HttpStatus.OK);

	}
	@GetMapping(value = "/doctor/fname/{firstName}")
	public List<Doctor> getDoctorfname(@PathVariable String firstName) {
		List<Doctor> doc = doctorTableRepo.findByFirstName(firstName);
		return doc;

	}

	@GetMapping(value = "/doctor/lname/{lastName}")
	public List<Doctor> getDoclname(@PathVariable String lastName) {
		List<Doctor> doc = doctorTableRepo.findByLastName(lastName);

		return doc;

	}
	  
	@GetMapping(value = "/doctor/{doctorId}")
	public Optional<Doctor> getDoctor(@PathVariable Integer doctorId) {
		Optional<Doctor> doc = doctorTableRepo.findById(doctorId);

		return doc;

	}
	  
	  // findAll doctor
	  
	  @GetMapping(value = "/doctor") public List<Doctor> getPatientall() {
	  List<Doctor> doc = doctorTableRepo.findAll();
	  
	  return doc;
	  
	  }
	 
}
