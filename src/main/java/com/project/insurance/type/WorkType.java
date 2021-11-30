package com.project.insurance.type;

import java.util.ArrayList;

import com.project.insurance.model.Work;

public enum WorkType {
	
	IP(new String[]{"보험 설계하기", "보험상품 관리하기"}, new String[]{"/product/design/CANCER","/product/list/manage"}),
	IPA(new String[]{"보험상품 승인하기", "보험상품 삭제하기"}, new String[]{"/product/list/acceptance","/product/list/delete"}),
	UW(new String[]{"인수심사하기"}, new String[]{"/contract/list/uw"}), 
	CM(new String[]{"보험계약 관리하기", "만기계약 관리하기"}, new String[]{"/contract/list/cm/ACTUALEXPENSE","/contract/list/cm/ACTUALEXPENSE"}), 
	CH(new String[]{"사고처리"}, new String[]{"/accident/list/CANCER"}), 
	SP(new String[]{"영업 활동 관리", "계약가능 보험조회"}, new String[]{"/contract/list/sp","/product/list/salesperson"}),
	CLIENT(new String[]{"가입 보험 조회"}, new String[]{"/contract/list/client"});
	
	private String[] names;
	private String[] urls;
	
	private WorkType(String[] names, String[] urls) {
		this.names = names;
		this.urls = urls;
	}

	public ArrayList<Work> getWorkList() {
		ArrayList<Work> list = new ArrayList<Work>();
		for(int i = 0; i < names.length; i++) {
			Work work = new Work(names[i], urls[i]);
			list.add(work);
		}
		return list;
	}
	
}
