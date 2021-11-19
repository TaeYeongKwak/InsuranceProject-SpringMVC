package com.project.insurance.type;
public enum InsuranceProductType {
	ACTUALEXPENSE("실비보험"), CANCER("암보험"), 
	PENSION("연금보험"), LIFE("종신보험");

	private String insuranceName;

	InsuranceProductType(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
}