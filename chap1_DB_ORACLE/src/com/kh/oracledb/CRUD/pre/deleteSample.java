package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "kh1016";
		String password = "kh1016";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String deleteQuery = "DELETE FROM BANK WHERE ACCOUNT_ID = ?" ;
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setInt(1, 13);
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + "���� �Ϸ�");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
