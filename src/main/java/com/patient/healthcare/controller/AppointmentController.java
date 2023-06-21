package com.patient.healthcare.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patient.healthcare.entity.Appointment;
import com.patient.healthcare.pojo.ApiResponse;
import com.patient.healthcare.repo.AppointmentTableRepo;
import com.patient.healthcare.repo.DoctorTableRepo;
import com.patient.healthcare.repo.PatientTableRepo;

@RestController
public class AppointmentController {
	@Autowired
	public PatientTableRepo patientTableRepo;
	@Autowired
	public DoctorTableRepo doctorTableRepo;
	@Autowired
	AppointmentTableRepo appointRepo;
	@RequestMapping(value="/appointment/{patientId}/{doctorId}",method= {RequestMethod.POST})
	public Appointment getAppointment(@RequestBody Appointment data,@PathVariable Integer patientId,@PathVariable Integer doctorId) {
			
		Appointment appoint = new Appointment();
		appoint.setPatientId(patientId);
		appoint.setDoctorId(doctorId);
		appoint.setAppointmentDate(data.getAppointmentDate());
		appoint.setTime(data.getTime());
		appoint.setStatus(data.getStatus());
		
		appointRepo.save(appoint);
	
		/*
		 * ApiResponse api = new ApiResponse(); api.setData(appoint);
		 * api.setValid(true);
		 */
		return appoint;      
      
		

		
}
}
