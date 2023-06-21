package com.patient.healthcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.healthcare.entity.Patient;
@Repository
public interface PatientTableRepo extends JpaRepository<Patient, Integer> {
	public List<Patient> findByFirstName(String firstName);
	public List<Patient> findByLastName(String lastName);
	
}
