package com.BMC.healthManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BMC.healthManagement.model.Patient;
import com.BMC.healthManagement.service.HealthService;

@RestController
@RequestMapping("/patients")
public class HealthController {
	
	@Autowired
	HealthService service;

	@PostMapping("/insert") // http://localhost:5000/patients/insert
	public String insertPatient(@RequestBody Patient patient) {
		return service.addPatient(patient);
	}

	@PutMapping("/update") // http://localhost:5000/patients/update
	public String updatePatient(@RequestBody Patient patient) {
		return service.updatePatient(patient);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:5000/patients/delete/1
	public String deletePatient(@PathVariable("id") int patientId) {
		return service.deletePatient(patientId);
	}

	@GetMapping("/get/{id}") // http://localhost:5000/patients/delete/1
	public Patient getPatient(@PathVariable("id") int patientId) {
		return service.getPatient(patientId);
	}

	@GetMapping("/getAll") // http://localhost:5000/patients/getAll
	public List<Patient> getAllPatients() {
		return service.getAllPatients();
	}
	@GetMapping("/getAllInBetween/{intialage}/{finalage}") // http://localhost:5000/patients/getAllInBetween/20/30
	public List<Patient> getAllPatientsInBetween(@PathVariable("intialage") int iage,@PathVariable("finalage") int fage ) {
		return service.getPatientsInBetween(iage,fage);
	}
	@GetMapping("/getAllByname/{name}") // http://localhost:5000/patients/getAllByname/lenovo
	public List<Patient> getAllPatientsByname(@PathVariable("name") String pname) {
		return service.getAllPatientsByName(pname);
	}
	

}
