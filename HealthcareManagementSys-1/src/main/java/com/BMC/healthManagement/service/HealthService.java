package com.BMC.healthManagement.service;

import java.util.List;


import com.BMC.healthManagement.model.Patient;

public interface HealthService {
	public abstract String addPatient(Patient patient);

	public abstract String updatePatient(Patient patient);

	public abstract String deletePatient(int patientId);

	public abstract Patient getPatient(int patientId);

	public abstract List<Patient> getAllPatients();

	public abstract List<Patient> getPatientsInBetween(int iage, int fage);

	public abstract List<Patient> getAllPatientsByName(String pname);
}
