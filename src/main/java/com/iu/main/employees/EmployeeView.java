package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {

	public void view(String str) {
		System.out.println(str);
	}
	public void view(EmployeeDTO dto) {
		System.out.println(dto.getEmployee_id());
		System.out.println(dto.getFirst_name());
		System.out.println(dto.getLast_name());
		System.out.println(dto.getEmail());
		System.out.println(dto.getPhone_number());
		System.out.println(dto.getHire_date());
		System.out.println(dto.getJob_id());
		System.out.println(dto.getSalary());
		System.out.println(dto.getCommission_pct());
		System.out.println(dto.getManager_id());
		System.out.println(dto.getDepartment_id());
		
	}
	public void view(ArrayList<EmployeeDTO> ar) {
		for(int i =0; i<ar.size(); i++) {
			System.out.println(ar.get(i).getEmployee_id());
			System.out.println(ar.get(i).getLast_name());
			System.out.println(ar.get(i).getFirst_name());
			System.out.println(ar.get(i).getJob_id());
			System.out.println(ar.get(i).getDepartment_id());
			System.out.println("");
		}
	}
}
