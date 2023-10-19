package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe1";
	String password = "khcafe1";
	
	public void insertCafe(String name,String address,String phone_number,String operationg_hours) { 
	try {
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "INSERT INTO cafes (name,address,phone_number,operationg_hours"
				+ "VALUES(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sql);
		ps.setString(2, address);
		ps.setString(3, phone_number);
		ps.setString(4, operationg_hours);
		
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	}

	public void	updateCafesModel(String operationghours,int cafeid ) { 
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String sql   = "UPDATE cafes SET operationg_hours = ? where cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, operationghours);  
			st.setInt(2, cafeid);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteCafe(int cafeId) { 
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteMenu(int menuid) {
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			String sql = "delete from menu where menu_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, menuid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
