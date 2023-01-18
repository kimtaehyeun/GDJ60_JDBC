package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO dao;//의존성 선언 -> 의존성이 필요하다.
	private DepartmentView view;
	public DepartmentController() {
		this.sc = new Scanner(System.in);
		this.dao = new DepartmentDAO();//의존성 주입 -> 의존성을 넣는다.
		this.view = new DepartmentView();
	}
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서 리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				ArrayList<DepartmentDTO> ar =dao.getList();
				view.view(ar);
				break;
			case 2:
				System.out.println("부서번호를 입력하세요");
				select = sc.nextInt();
				DepartmentDTO departmentDTO=dao.getDetail(select);
				view.view(departmentDTO);
				break;

			case 3:
				System.out.println("종료");
				check = false;
				break;
			default:
				view.view("없음");
				
				break;
			}
			
		}
	}
	
	
}
