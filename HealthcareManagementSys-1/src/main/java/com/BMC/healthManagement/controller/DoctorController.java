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

import com.BMC.healthManagement.model.Doctor;
import com.BMC.healthManagement.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	DoctorService service;

	@PostMapping("/insert") // http://localhost:5000/doctors/insert
	public String insertDoctor(@RequestBody Doctor doctor) {
		return service.addDoctor(doctor);
	}

	@PutMapping("/update") // http://localhost:5000/doctors/update
	public String updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:5000/doctors/delete/1
	public String deleteDoctor(@PathVariable("id") int doctorId) {
		return service.deleteDoctor(doctorId);
	}

	@GetMapping("/get/{id}") // http://localhost:5000/doctors/delete/1
	public Doctor getDoctor(@PathVariable("id") int doctorId) {
		return service.getDoctor(doctorId);
	}

	@GetMapping("/getAll") // http://localhost:5000/doctors/getAll
	public List<Doctor> getAllDoctors() {
		return service.getAllDoctors();
	}
	@GetMapping("/getAllInBetween/{intialage}/{finalage}") // http://localhost:5000/doctors/getAllInBetween/20/30
	public List<Doctor> getAllDoctorsInBetween(@PathVariable("intialage") int iage,@PathVariable("finalage") int fage ) {
		return service.getDoctorsInBetween(iage,fage);
	}
	@GetMapping("/getAllByname/{name}") // http://localhost:5000/doctors/getAllByname/lenovo
	public List<Doctor> getAllDoctorsByname(@PathVariable("name") String pname) {
		return service.getAllDoctorsByName(pname);
	}

}
