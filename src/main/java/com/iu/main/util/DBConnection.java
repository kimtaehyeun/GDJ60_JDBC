package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	public static Connection getConnection() throws Exception{
//		1. 접속 정보 준비
//		--------------------------------------------------------------------------------------------
		//1. id
		String username = "hr";
		//2. password
		String password = "hr";
		//3. url
		//String url = "jdbc:oracle:thin:@192.168.1.31:1521/ServiceName";
		//String url = "jdbc:oracle:thin:@192.168.1.31:1521:SID";
		
		String url = "jdbc:oracle:thin:@192.168.1.31:1521/XEPDB1";
		//4. driver
		String dirver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(dirver); 
//		---------------------------------------------------------------------------------------------------
//		2. db 접속 실행
		Connection connection = DriverManager.getConnection(url,username,password);
		
//		3.query문 생성
//		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=1";
		
//		4.query 문 db로 미리 전송(미완성)
//		PreparedStatement st = connection.prepareStatement(sql);
		
//		5. ?의 값을 세팅
		
//		6. 최종 전송 및 결고 처리
//		ResultSet rs =st.executeQuery();
//
//		while(rs.next()) {
//			System.out.println(rs.getString("REGION_ID"));
//			System.out.println(" ");
//			
//		}
//		7. 연결 해제
		return connection;
	}
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection) throws Exception{
		rs.close();
		st.close();
		connection.close();
	}
}
