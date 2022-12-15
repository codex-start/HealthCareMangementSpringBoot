package com.BMC.healthManagement.service;

import java.util.List;

import com.BMC.healthManagement.model.Doctor;

public interface DoctorService {
	
	public abstract String addDoctor(Doctor doctor);

	public abstract String updateDoctor(Doctor doctor);

	public abstract String deleteDoctor(int doctorId);

	public abstract Doctor getDoctor(int doctorId);

	public abstract List<Doctor> getAllDoctors();

	public abstract List<Doctor> getDoctorsInBetween(int iage, int fage);

	public abstract List<Doctor> getAllDoctorsByName(String pname);

}
