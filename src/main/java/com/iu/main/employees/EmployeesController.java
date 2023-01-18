package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {
	
	Scanner sc ;
	EmployeeDAO dao;
	EmployeeView view;
	public EmployeesController() throws Exception{
		sc = new Scanner(System.in);
		dao = new EmployeeDAO();
		view = new EmployeeView();
	}
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			System.out.println("번호를 고르시오");
			System.out.println("1. 사원정보 리스트");
			System.out.println("2. 개별사원 정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				ArrayList<EmployeeDTO> ar = dao.getList();
				view.view(ar);
				
				break;
			case 2:
				System.out.println("사원번호 입력");
				select = sc.nextInt();
				EmployeeDTO dto = dao.getDetail(select);
				view.view(dto);
				
				break;
			default:
				System.out.println("종료");
				check = false;
				break;
			}
		}
	}
	
}
