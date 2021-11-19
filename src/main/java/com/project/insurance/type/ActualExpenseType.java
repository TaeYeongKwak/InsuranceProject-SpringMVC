package com.project.insurance.type;
public enum ActualExpenseType {
	ADMISSION("�엯�썝"), HOSPITALTREATMENT("蹂묒썝吏꾨즺鍮�"), MEDICINEPRESCRIPTION("�빟泥섎갑鍮�");
	
	private String actualexpensename;
	
	ActualExpenseType(String actualexpensename){
		this.actualexpensename = actualexpensename;
	}
	public String getactualexpensename() {
		return actualexpensename;
	}
}