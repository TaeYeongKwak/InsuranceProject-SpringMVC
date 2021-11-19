package com.project.insurance.type;

public enum ManagerType {
	IP("보험상품개발자"), IPA("보험상품승인자"), 
	UW("U/W"), CM("계약관리자"), 
	CH("보상처리자"), SP("영업사원");

	private String job;

	ManagerType(String job) {
		this.job = job;
	}
	public String getJob() {
		return job;
	}

}