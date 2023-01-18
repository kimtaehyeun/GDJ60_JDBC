package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.employees.EmployeesController;
import com.iu.main.location.LocationController;


public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		try {
			DepartmentController de = new DepartmentController();
			LocationController lo = new LocationController();
			EmployeesController ec = new EmployeesController();
//			de.start();
//			lo.start();
			ec.start();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		
		
		
		
//		DepartmentDAO dao = new DepartmentDAO();
//		try {
////			dao.getList();
//			dao.getDetail(20);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		LocationDAO dao = new LocationDAO();
//		try {
////			dao.getList();
//			dao.getdetail(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println("finish");
	}

}
