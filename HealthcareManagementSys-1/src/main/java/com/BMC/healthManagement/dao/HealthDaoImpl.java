package com.BMC.healthManagement.dao;

import java.util.List;

import com.BMC.healthManagement.model.Patient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class HealthDaoImpl implements HealthDao {
	
	@PersistenceContext
	EntityManager entityManager;// JPA

	@Override
	public String addPatient(Patient patient) {
		entityManager.persist(patient);
		return "Patient Inserted Successfully";
	}

	@Override
	public String updatePatient(Patient patient) {
		entityManager.merge(patient);
		return "Patient Update Successfully";
	}

	@Override
	public String deletePatient(int patientId) {
		entityManager.remove(getPatient(patientId));
		return "Patient Deleted Successfully";
	}

	@Override
	public Patient getPatient(int patientId) {

		return entityManager.find(Patient.class, patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		Query result = entityManager.createQuery("select e from Patient e");
		return result.getResultList();
	}

//select * from patients_info where patient_price between 40000 and 50000;
	@Override
	public List<Patient> getAllPatientsInBetween(int iage, int fage) {

		Query result = entityManager.createQuery("select e from Patient e where e.patientPrice between ?1 and ?2");
		result.setParameter(1, iage);
		result.setParameter(2, fage);
		return result.getResultList();
	}

//select * from patients_info where patient_name='dell';
	@Override
	public List<Patient> getAllPatientsByname(String pname) {
		Query result = entityManager.createQuery("select e from Patient e where e.patientName=?1");
		result.setParameter(1, pname);
		return result.getResultList();
	}


}
