package com.patient.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patient.healthcare.entity.Patient;
import com.patient.healthcare.pojo.ApiResponse;
import com.patient.healthcare.repo.PatientTableRepo;

@RestController
public class PatientController {
	@Autowired
	public PatientTableRepo patientTableRepo;

	@RequestMapping(value = "/patient", method = { RequestMethod.POST })
	public ApiResponse CreatePatient(@RequestBody Patient patient) {
		Patient p = new Patient();
		p.setFirstName(patient.getFirstName());
		p.setMiddleName(patient.getMiddleName());
		p.setLastName(patient.getLastName());
		p.setBirthDate(patient.getBirthDate());
		p.setIsActive(patient.getIsActive());
		patientTableRepo.save(p);
		ApiResponse api = new ApiResponse();
		api.setData(patient);
		api.setValid(true);
		return api;

	}

	@RequestMapping(value = "/patient/{patientId}", method = { RequestMethod.PUT })
	public ApiResponse updatePatient(@RequestBody Patient patient, @PathVariable Integer patientId) {
		System.out.println(patient);
		Patient patientDB = patientTableRepo.getById(patientId);
		if (patient.getFirstName() != null) {
			patientDB.setFirstName(patient.getFirstName());
		}
		if (patient.getMiddleName() != null) {
			patientDB.setMiddleName(patient.getMiddleName());
		}
		if (patient.getLastName() != null) {
			patientDB.setLastName(patient.getLastName());
		}
		if (patient.getBirthDate() != null) {
			patientDB.setBirthDate(patient.getBirthDate());
		}
		if (patient.getMobile() != null) {
			patientDB.setMobile(patient.getMobile());
		}

		patientTableRepo.save(patientDB);
		ApiResponse api = new ApiResponse();
		api.setData(patient);
		api.setValid(true);
		return api;

	}

	@RequestMapping(value = "/patient", method = { RequestMethod.DELETE })
	public ResponseEntity<String> deletePatient(@RequestParam Integer patientId) {
		Patient patient = patientTableRepo.getById(patientId);
		patient.setIsActive(false);
		patientTableRepo.save(patient);
		ApiResponse api = new ApiResponse();
		api.setData(patient);
		api.setValid(true);
		return new ResponseEntity<String>("Patient deleted successfully!.", HttpStatus.OK);

	}

	@GetMapping(value = "/patient/fname/{firstName}")
	public List<Patient> getPatientfname(@PathVariable String firstName) {
		
		List<Patient> pt = patientTableRepo.findByFirstName(firstName);
		return pt;
	}

	@GetMapping(value = "/patient/lname/{lastName}")
	public List<Patient> getPatientlname(@PathVariable String lastName) {
		List<Patient> pt = patientTableRepo.findByLastName(lastName);

		return pt;

	}

	@GetMapping(value = "/patient/{patientId}")
	public Optional<Patient> getPatient(@PathVariable Integer patientId) {
		Optional<Patient> pt = patientTableRepo.findById(patientId);

		return pt;

	}

	// findAll patient
	@GetMapping(value = "/patient")
	public List<Patient> getPatientall() {
		List<Patient> pt = patientTableRepo.findAll();

		return pt;

	}

}
