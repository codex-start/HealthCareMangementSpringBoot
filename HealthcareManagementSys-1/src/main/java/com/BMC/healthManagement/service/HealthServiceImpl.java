package com.BMC.healthManagement.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BMC.healthManagement.dao.HealthDao;
import com.BMC.healthManagement.model.Patient;


@Service
public class HealthServiceImpl implements HealthService {
	@Autowired
	HealthDao dao;

	@Override
	public String addPatient(Patient patient) {

		return dao.addPatient(patient);
	}

	@Override
	public String updatePatient(Patient patient) {

		return dao.updatePatient(patient);
	}

	@Override
	public String deletePatient(int patientId) {
		 
		return dao.deletePatient(patientId);
	}

	@Override
	public Patient getPatient(int patientId) {
		
		return dao.getPatient(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return dao.getAllPatients();
	}

	@Override
	public List<Patient> getPatientsInBetween(int iage, int fage) {
		
		return dao.getAllPatientsInBetween(iage,fage);
	}

	@Override
	public List<Patient> getAllPatientsByName(String pname) {
		
		return dao.getAllPatientsByname(pname);
	}

}
