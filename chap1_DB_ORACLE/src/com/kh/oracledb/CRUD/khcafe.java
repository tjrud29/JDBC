package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class khcafe {

	public static void main(String[] args) {
		insertkhcafe();

	}

	
	static void insertkhcafe() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2.����Ŭ �� ��ǻ�� ����
		//                              ���� ip�ּ� : port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("���� ����");
			
			String insertQuery = "INSERT INTO BOOK1 (BOOK_ID,TITLE,AUTHOR,PUBLICATION_YEAR,ISBN,GENRE,DESCRIPTION,PRICE,PUBLICATION_DATE,CREATED_DATE,UPDATED_DATE,IS_AVAILABLE)" 
							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
							
					
					
					
							
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1,213);
			insertState.setString(2,"��ġ");
			insertState.setString(3,"��ġ��");
			insertState.setInt(4,1977);
			insertState.setString(5,"����");
			insertState.setString(6,"genre");
			insertState.setString(7,"clob ��뷮");
			insertState.setInt(8,231);
			insertState.setDate(9,Date.valueOf("2023-10-18"));
			insertState.setDate(10,Date.valueOf("2022-12-11"));
			insertState.setDate(11,Date.valueOf("2022-11-22"));
			insertState.setString(12,"d");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}