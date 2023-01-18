package com.iu.main.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	Scanner sc ;
	LocationDAO dao;
	LocationView view;
	public LocationController() {
		sc = new Scanner(System.in);
		dao = new LocationDAO();
		view = new LocationView();
		
	}
	public void start() throws Exception{
		boolean sw = true;
		while(sw) {
			System.out.println("번호를 입력하세요");
			System.out.println("1. 부서지역전체보기  2. 부서지역검색 3. 주소검색 4. 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				ArrayList<LocationDTO> ar= dao.getList();
				view.view(ar);
				break;
			case 2:
				System.out.println("지역ID 입력1000~3200");
				select = sc.nextInt();
				LocationDTO locationDTO= dao.getdetail(select);
				view.view(locationDTO);
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = sc.next();
				ar= dao.getFind(add);
			default:
				sw=false;
				break;
			}
		}
	}
}
