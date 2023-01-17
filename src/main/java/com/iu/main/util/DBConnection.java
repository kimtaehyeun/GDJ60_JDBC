package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	public void getConnection() throws Exception{
		//1. id
		String username = "hr";
		//2. password
		String password = "hr";
		//3. url
		String url = "jdbc:oracle:thin:@192.168.1.31:1521/XEPDB1";
		//4. driver
		String dirver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(dirver);
		Connection connection = DriverManager.getConnection(url,username,password);
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=1";
		
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs =st.executeQuery();

		while(rs.next()) {
			System.out.println(rs.getString("REGION_ID"));
			System.out.println(" ");
			
		}
	}
}
