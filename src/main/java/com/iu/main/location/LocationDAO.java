package com.iu.main.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class LocationDAO {
	public ArrayList<LocationDTO> getFind(String search)throws Exception{
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			LocationDTO dto = new LocationDTO();
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(dto);
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
		
	}
	public LocationDTO getdetail(int location_id) throws Exception{
		LocationDTO locationDTO= null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID =?";
		PreparedStatement statement=  connection.prepareStatement(sql);
		statement.setInt(1, location_id);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		return locationDTO;
	}
	
	public ArrayList<LocationDTO> getList() throws Exception{
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		//		DBConnection dbconnection =new DBConnection();
		Connection connection = DBConnection.getConnection();
		//		//1. 접속 정보 준비
		//		String user = "hr";
		//		String password = "hr";
		//		String url = "jdbc:oracle:thin:@192.168.1.31:1521/XEPDB1";

		//		//2. db 접속
		//		Connection connection = DriverManager.getConnection(url, user, password);
		//3. query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		//4. 쿼리문 미리 전송
		PreparedStatement statement = connection.prepareStatement(sql);
		//5. 옵션 ? 값을 셋팅

		//6.최종 전송 
		ResultSet resultSet  = statement.executeQuery();
		//7. 결과 처리
		while(resultSet.next()) {
			LocationDTO dto = new LocationDTO();
			dto.setLocation_id(resultSet.getInt("LOCATION_ID"));
			dto.setStreet_address(resultSet.getString("STREET_ADDRESS"));
			dto.setPostal_code(resultSet.getString("POSTAL_CODE"));
			dto.setCity(resultSet.getString("CITY"));
			dto.setState_province(resultSet.getString("STATE_PROVINCE"));
			dto.setCountry_id(resultSet.getString("COUNTRY_ID"));
			ar.add(dto);

		}
		//8. 연결 해제
		DBConnection.disConnect(resultSet, statement, connection);
		return ar;
	}
}
