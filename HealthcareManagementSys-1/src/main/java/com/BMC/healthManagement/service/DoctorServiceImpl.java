package com.BMC.healthManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BMC.healthManagement.dao.DoctorDao;
import com.BMC.healthManagement.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorDao dao;

	@Override
	public String addDoctor(Doctor doctor) {

		return dao.addDoctor(doctor);
	}

	@Override
	public String updateDoctor(Doctor doctor) {

		return dao.updateDoctor(doctor);
	}

	@Override
	public String deleteDoctor(int doctorId) {
		 
		return dao.deleteDoctor(doctorId);
	}

	@Override
	public Doctor getDoctor(int doctorId) {
		
		return dao.getDoctor(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		
		return dao.getAllDoctors();
	}

	@Override
	public List<Doctor> getDoctorsInBetween(int iage, int fage) {
		
		return dao.getAllDoctorsInBetween(iage,fage);
	}

	@Override
	public List<Doctor> getAllDoctorsByName(String pname) {
		
		return dao.getAllDoctorsByname(pname);
	}

}
