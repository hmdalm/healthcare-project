package com.patient.healthcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.healthcare.entity.Doctor;
import com.patient.healthcare.entity.Patient;
@Repository
public interface DoctorTableRepo extends JpaRepository<Doctor, Integer>{
	public List<Doctor> findByFirstName(String firstName);
	public List<Doctor> findByLastName(String lastName);	

}
