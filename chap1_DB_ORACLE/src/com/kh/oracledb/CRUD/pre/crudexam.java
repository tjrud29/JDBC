package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crudexam {

	public static void main(String[] args) { 
		
		exam8();
	}
	static void exam1() { 

		String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";	
		String userName = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, password);
			String selectQuery = "SELECT * FROM menu";
			PreparedStatement st1 = con.prepareStatement(selectQuery);
			ResultSet result1 = st1.executeQuery();
			
			while(result1.next()) {
				int menuid = result1.getInt("menu_id");
				int cafeid = result1.getInt("cafe_id");
				String menuname = result1.getString("menu_name");
				int price = result1.getInt("price");
				String description = result1.getString("description");
				
				System.out.print("menu_id : " + menuid);
				System.out.print("cafe_id : " + cafeid);
				System.out.print("menu_name : " + menuname);
				System.out.print("price : " + price);
				System.out.println("description : " + description);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	static void exam2() {    
		
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";	
		String userName = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl,userName,password);
			String selectQuery = "SELECT * FROM menu WHERE CAFE_ID = ?";
			PreparedStatement st2 = con.prepareStatement(selectQuery);
			
			ResultSet result = st2.executeQuery();
			
			result.getInt(1);
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	static void exam3() { 
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, username, password);
			
			String insertQuery = "INSERT INTO menu (MENU_ID,CAFE_ID,MENU_NAME,PRICE,DESCRIPTION)" 
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement st3 = con.prepareStatement(insertQuery);
			
			st3.setInt(1,28);
			st3.setInt(2,28);
			st3.setString(3,"아메리카노");
			st3.setInt(4,2);
			st3.setString(5,"콜드브루 아메리카노");
			
			
			int rowInsert = st3.executeUpdate();
			System.out.println(rowInsert + "로우행 생성");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	static void exam4() {  
		//4.특정 카페의 메뉴 가격 변경하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateQuery  = "UPDATE menu SET MENU_NAME = ? WHERE MENU_ID = ?  ";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			
			ps.setString(1, "맛좋은 커피");
			ps.setInt(2, 27);
			
			int rowsdate = ps.executeUpdate();
			System.out.println(rowsdate);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	static void exam5() {    
		//5.특정 카페의 정보 수정하기
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String updateQuery = "UPDATE products SET product_name = ? WHERE PRODUCT_ID = ?";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1, "맥북");
			ps.setInt(2, 3 );
			
			int rowsdate = ps.executeUpdate();	
			System.out.println(rowsdate);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				}
	static void exam6() {  
	//	6.특정 카페의 정보 삭제하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String deleteQuery = "delete FROM menu WHERE menu_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			
			
			
			deletePs.setInt(1, 1);
			int rowsdata = deletePs.executeUpdate();
			System.out.println(rowsdata);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	static void exam7() {

		 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		//7.특정 카페의 메뉴 수 가져오기
		
			try {
				Connection con = DriverManager.getConnection(url, user, password);
					String selectQuery = "SELECT MENU_NAME FROM MENU ";
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	static void exam8() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		//7.특정 카페의 메뉴 수 가져오기
		
			
				try {
					Connection con = DriverManager.getConnection(url, user, password);
					String selectQuery = "SELECT * FROM khcafe1 WHERE price bewteen ? and ?";
					PreparedStatement selectPs = con.prepareStatement(selectQuery);
					selectPs.setDouble(1,2.5);
					selectPs.setDouble(1,4.1);
					
					ResultSet result = selectPs.executeQuery();
					
					result.getInt("price");
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
