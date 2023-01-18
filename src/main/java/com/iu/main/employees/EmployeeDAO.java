package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.departments.DepartmentDTO;
import com.iu.main.util.DBConnection;

public class EmployeeDAO {

	public ArrayList<EmployeeDTO> getList() throws Exception{
		Connection con= DBConnection.getConnection();
		String sql ="SELECT EMPLOYEE_ID ,LAST_NAME, FIRST_NAME,JOB_ID ,DEPARTMENT_ID  FROM EMPLOYEES ORDER BY HIRE_DATE DESC ";
		PreparedStatement st = con.prepareStatement(sql);
		//?없음
		ResultSet rs = st.executeQuery();
		ArrayList<EmployeeDTO> ar= new ArrayList<EmployeeDTO>();
		
		while(rs.next()) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			dto.setLast_name(rs.getString("LAST_NAME"));
			dto.setFirst_name(rs.getString("FIRST_NAME"));
			dto.setJob_id(rs.getString("JOB_ID"));
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(dto);
		}
		return ar;
	}
	public EmployeeDTO getDetail(int num) throws Exception{
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES e WHERE EMPLOYEE_ID =?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		EmployeeDTO dto = new EmployeeDTO();
		if(rs.next()) {
			
			dto.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			dto.setFirst_name(rs.getString("FIRST_NAME"));
			dto.setLast_name(rs.getString("LAST_NAME"));
			dto.setEmail(rs.getString("EMAIL"));
			dto.setPhone_number(rs.getString("PHONE_NUMBER"));
			dto.setJob_id(rs.getString("JOB_ID"));
			dto.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			dto.setManager_id(rs.getInt("MANAGER_ID"));
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			
		}
		return dto;
		
	}
}
