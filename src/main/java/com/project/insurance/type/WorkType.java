package com.project.insurance.type;

import java.util.ArrayList;

import com.project.insurance.model.Work;

public enum WorkType {
	
	IP(new String[]{"���� �����ϱ�", "�����ǰ �����ϱ�"}, new String[]{"/product/design/CANCER",""}),
	IPA(new String[]{"�����ǰ �����ϱ�", "�����ǰ �����ϱ�"}, new String[]{"/product/list/acceptance",""}),
	UW(new String[]{"�μ��ɻ��ϱ�"}, new String[]{"/contract/list/uw"}), 
	CM(new String[]{"������ �����ϱ�", "������ �����ϱ�"}, new String[]{"",""}), 
	CH(new String[]{"���ó��"}, new String[]{"/accident/list/CANCER"}), 
	SP(new String[]{"���� Ȱ�� ����", "��డ�� ������ȸ"}, new String[]{"","/product/list/salesperson"}),
	CLIENT(new String[]{"���� ���� ��ȸ"}, new String[]{"/contract/list/client"});
	
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