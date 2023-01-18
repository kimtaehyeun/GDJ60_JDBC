package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.location.LocationDTO;

public class DepartmentView {
	
	public void view(String str) {
		System.out.println(str);
	}
	public void view(DepartmentDTO dto) {
		System.out.println(dto.getDepartment_id());
		System.out.println(dto.getDepartment_name());
		System.out.println(dto.getManager_id());
		System.out.println(dto.getLocation_id());

	}
	public void view(ArrayList<DepartmentDTO> ar) {
		for(DepartmentDTO departmentDTO:ar) {
			this.view(departmentDTO);
		}
	}
}
