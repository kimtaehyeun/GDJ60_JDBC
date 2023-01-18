package com.iu.main.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class DepartmentDAO {

	public DepartmentDTO getDetail(int department_id)throws Exception{
		
		DepartmentDTO departmentDTO =null;	//검색한 것이 없으면 null 리턴
		Connection connection = DBConnection.getConnection();

		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		//5. 옵션 ? 값을 셋팅
		st.setInt(1, department_id);

		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name("DEPARTMENT_NAME");
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return departmentDTO;
	}
	public ArrayList<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		//		DBConnection dbConnection = new DBConnection();
		Connection conn =DBConnection.getConnection();
		//1. 접속 정보 준비
		//		String user = "hr";
		//		String password = "hr";
		//		String url = "jdbc:oracle:thin:@192.168.1.31:1521/XEPDB1";
		//		
		//		//2. db 접속
		//		Connection conn= DriverManager.getConnection(url, user, password);
		//		System.out.println(conn);
		//3. query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		//4. 쿼리문 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		//5. 옵션 ? 값을 셋팅

		//6.최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name("DEPARTMENT_NAME");
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		//7. 연결 해제
		//		rs.close();
		//		st.close();
		//		conn.close();
		DBConnection.disConnect(rs, st, conn);
		return ar;
	}
}
