package com.BMC.healthManagement.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_info")
public class Patient {

	@Id
	@GeneratedValue
	private int patientId;
	private String patientName;
	private int patientAge;
	@Column(name = "description")
	private String patientDesc;
	private String patientAddr;
	private String appointDoc;
	
	
	
	
	
@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientDesc=" + patientDesc + ", patientAddr=" + patientAddr + ", appointDoc=" + appointDoc + "]";
	}
	//	@Override
//	public String toString() {
//		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
//				+ ", patientDesc=" + patientDesc + ", patientAddr=" + patientAddr + "]";
//	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientDesc() {
		return patientDesc;
	}
	public void setPatientDesc(String patientDesc) {
		this.patientDesc = patientDesc;
	}
	public String getPatientAddr() {
		return patientAddr;
	}
	public void setPatientAddr(String patientAddr) {
		this.patientAddr = patientAddr;
	}
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
//	public Patient(int patientId, String patientName, int patientAge, String patientDesc, String patientAddr) {
//		super();
//		this.patientId = patientId;
//		this.patientName = patientName;
//		this.patientAge = patientAge;
//		this.patientDesc = patientDesc;
//		this.patientAddr = patientAddr;
//	}
	public String getAppointDoc() {
		return appointDoc;
	}
	public void setAppointDoc(String appointDoc) {
		this.appointDoc = appointDoc;
	}
	public Patient(int patientId, String patientName, int patientAge, String patientDesc, String patientAddr,
			String appointDoc) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientDesc = patientDesc;
		this.patientAddr = patientAddr;
		this.appointDoc = appointDoc;
	}
	
	
	
}
