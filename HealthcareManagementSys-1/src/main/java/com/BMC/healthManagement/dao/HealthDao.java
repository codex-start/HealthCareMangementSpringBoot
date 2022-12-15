package com.BMC.healthManagement.dao;

import java.util.List;

import com.BMC.healthManagement.model.Patient;

public interface HealthDao {

	
	public abstract String addPatient(Patient patient);//persist

	public abstract String updatePatient(Patient patient);//merge

	public abstract String deletePatient(int patientId);//remove

	public abstract Patient getPatient(int patientId);//find

	public abstract List<Patient> getAllPatients();//JPQL

	public abstract List<Patient> getAllPatientsInBetween(int iage, int fage);//jpql

	public abstract List<Patient> getAllPatientsByname(String pname);//jpql
}
