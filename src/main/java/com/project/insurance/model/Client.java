package com.project.insurance.model;

import com.project.insurance.type.CancerType;
import com.project.insurance.type.ClientJobType;

public class Client {

	// attributes
	private String address;
	private int age;
	private String bankAccountNumber;
	private String email;
	private boolean gender;
	private String id;
	private String name;
	private String password;
	private String phoneNumber;
	private String residentRegistrationNumber;
	private ClientJobType job;

	// composition
	private MedicalHistory medicalHistory;

	public Client() {
		this.medicalHistory = new MedicalHistory();
		this.medicalHistory.setClientCancerCareer(CancerType.HEALTHY);
		this.medicalHistory.setFamilyCancerCareer(CancerType.HEALTHY);
		this.medicalHistory.setNumberOfHospitalizations(0);
		this.medicalHistory.setNumberOfHospitalVisits(0);
	}

	// Getters & Setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getResidentRegistrationNumber() {
		return residentRegistrationNumber;
	}

	public void setResidentRegistrationNumber(
			String residentRegistrationNumber) {
		this.residentRegistrationNumber = residentRegistrationNumber;
	}

	public MedicalHistory getMedicalHistory() {
		return this.medicalHistory;
	}

	public ClientJobType getJob() {
		return job;
	}

	public void setJob(ClientJobType job) {
		this.job = job;
	}

}