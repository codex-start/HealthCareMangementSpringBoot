package com.BMC.healthManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.BMC.healthManagement.model.Doctor;

@Repository
@Transactional
public class DoctorDaoImpl implements DoctorDao {
	
	@PersistenceContext
	EntityManager entityManager;// JPA

	@Override
	public String addDoctor(Doctor doctor) {
		
		entityManager.persist(doctor);
		return "Doctor Inserted Successfully";
	}

	@Override
	public String updateDoctor(Doctor doctor) {
		entityManager.merge(doctor);
		return "Doctor Update Successfully";
	}

	@Override
	public String deleteDoctor(int doctorId) {
		entityManager.remove(getDoctor(doctorId));
		return "Doctor Deleted Successfully";
	}

	@Override
	public Doctor getDoctor(int doctorId) {

		return entityManager.find(Doctor.class, doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		Query result = entityManager.createQuery("select e from Doctor e");
		return result.getResultList();
	}

//select * from doctors_info where doctor_price between 40000 and 50000;
	@Override
	public List<Doctor> getAllDoctorsInBetween(int iage, int fage) {

		Query result = entityManager.createQuery("select e from Doctor e where e.doctorPrice between ?1 and ?2");
		result.setParameter(1, iage);
		result.setParameter(2, fage);
		return result.getResultList();
	}

//select * from doctors_info where doctor_name='dell';
	@Override
	public List<Doctor> getAllDoctorsByname(String pname) {
		Query result = entityManager.createQuery("select e from Doctor e where e.doctorName=?1");
		result.setParameter(1, pname);
		return result.getResultList();
	}


}
