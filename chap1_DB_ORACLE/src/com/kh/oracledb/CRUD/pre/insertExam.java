package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert 작성해서 여러 카페 추가하기
public class insertExam {

	public static void main(String[] args) {
		
		
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl,userName,password);
			String insertSQL = "INSERT INTO MENU(MENU_ID,CAFE_ID,MENU_NAME,PRICE,DESCRIPTION)" 
			+"VALUES(?,?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertMenu(ps,27,1,"gkdlgk",23,"fda");
			System.out.println("성공");
			ps.close();
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void insertMenu(PreparedStatement ps,int menu_id,int cafe_id,
			String menu_name,int price,String description) throws SQLException{
		ps.setInt(1, menu_id);
		ps.setInt(2, cafe_id);
		ps.setString(3, menu_name);
		ps.setInt(4, price);
		ps.setString(5, description);
		
		ps.executeUpdate();

	}

}
