package com.BMC.healthManagement.dao;

import java.util.List;

import com.BMC.healthManagement.model.Doctor;

public interface DoctorDao {

	public abstract String addDoctor(Doctor doctor);//persist

	public abstract String updateDoctor(Doctor doctor);//merge

	public abstract String deleteDoctor(int doctorId);//remove

	public abstract Doctor getDoctor(int doctorId);//find

	public abstract List<Doctor> getAllDoctors();//JPQL

	public abstract List<Doctor> getAllDoctorsInBetween(int iage, int fage);//jpql

	public abstract List<Doctor> getAllDoctorsByname(String pname);//jpql
}
