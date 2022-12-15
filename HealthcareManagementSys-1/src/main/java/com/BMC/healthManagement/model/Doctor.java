package com.BMC.healthManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_info")
public class Doctor {
	
	@Id
//	@GeneratedValue
	private int doctorId;
	private String doctorName;
	@Column(name = "description")
	private String doctorDesc;
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorDesc=" + doctorDesc + "]";
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDesc() {
		return doctorDesc;
	}
	public void setDoctorDesc(String doctorDesc) {
		this.doctorDesc = doctorDesc;
	}
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public Doctor(int doctorId, String doctorName, String doctorDesc) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorDesc = doctorDesc;
	}
	
	
	

}
