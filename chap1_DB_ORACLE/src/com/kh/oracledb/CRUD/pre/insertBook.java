package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertBook {

	public static void main(String[] args) throws SQLException {
		String jdbc = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe1";
		String password = "khcafe1";
		
		try {
		Connection con = DriverManager.getConnection(jdbc, userName, password);
		String insertSQL = "INSERT INTO BOOK(BOOK_ID,TITLE,AUTHOR,PUBLICATION_YEAR,ISBN,GENRE,DESCRIPTION,PRICE,PUBLICATION_DATE,CREATED_DATE,UPDATED_DATE,IS_AVAILABLE)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(insertSQL);
		insertBook(ps,15,"�ڵ�����Դ�!","����",1,"isbn","genre","des",123.00,Date.valueOf("2022-11-22")
				,Date.valueOf("2000-11-11"),Date.valueOf("1801-11-11"),"Y");
		System.out.println("����");
		ps.close();
		
		String selectQuery = "select * from book where book_id =?";
		PreparedStatement selectps = con.prepareStatement(selectQuery);
		
		selectps.setInt(1, 50);
		ResultSet rs = selectps.executeQuery();
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

	
	static void insertBook(PreparedStatement ps,int BOOK_ID,String TITLE,
			String AUTHOR,int PUBLICATION_YEAR,String ISBN,String GENRE,String DESCRIPTION,
			double PRICE, Date PUBLICATION_DATE,Date CREATED_DATE, Date StriUPDATED_DATE,
			String IS_AVAILABLE) throws SQLException {
		ps.setInt(1,BOOK_ID);
		ps.setString(2, TITLE);
		ps.setString(3, AUTHOR); 
		ps.setInt(4, PUBLICATION_YEAR);
		ps.setString(5, ISBN);
		ps.setString(6, GENRE);
		ps.setString(7,DESCRIPTION);
		ps.setDouble(8, PRICE);
		ps.setDate(9,PUBLICATION_DATE);
		ps.setDate(10,CREATED_DATE);
		ps.setDate(11, StriUPDATED_DATE);
		ps.setString(12, IS_AVAILABLE);
		
		ps.executeUpdate();
		
		
		 
		
		
		
	}

}