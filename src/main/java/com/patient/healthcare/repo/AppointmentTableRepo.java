package com.patient.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.healthcare.entity.Appointment;
@Repository
public interface AppointmentTableRepo extends JpaRepository<Appointment, Integer> {
	

}
