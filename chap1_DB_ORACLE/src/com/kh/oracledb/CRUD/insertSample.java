package com.kh.oracledb.CRUD;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.crypto.Data;  

public class insertSample {

	public static void main(String[] args) {  

		insertone();
		
	}
	
	static void insertone()  {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh1016";
		String password = "kh1016";
		
		
		
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"   
									 + "VALUES (?, ? , ?,?,?,?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				insertState.setInt(1, 13);
				insertState.setString(2, "32344");
				insertState.setString(3, "사아자");
				insertState.setDouble(4, 1500.00);
				insertState.setString(5, "kh");
				insertState.setDate(6,  Date.valueOf("2023-10-16"));
				
				int rowsInsert = insertState.executeUpdate();
				System.out.println(rowsInsert + "row 추가됨");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	

}
}
