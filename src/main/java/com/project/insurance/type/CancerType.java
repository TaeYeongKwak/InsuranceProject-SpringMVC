package com.project.insurance.type;
public enum CancerType {
	PANCREATIC("痍뚯옣�븫", 1.6), LUNG("�룓�븫", 1.5), STOMACH("�쐞�븫", 1.4), 
	COLORECTAL("���옣�븫", 1.3), LIVER("媛꾩븫", 1.2), ETC("湲고�", 1.1), 
	HEALTHY("�뾾�쓬", 1.0);
	
	private String cancerName;
	private double rate;
	
	CancerType(String cancerName, double rate){
		this.cancerName = cancerName;
		this.rate = rate;
	}
	public String getCancerName() {
		return cancerName;
	}
	public double getRate() {
		return rate;
	}
}