package com.kh.MVCexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class exampleDAO {

	
	Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe1";
	String userPassword = "khcafe1";
	
	public exampleDAO() {
	try {
		connection = DriverManager.getConnection(url,userName,userPassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	PreparedStatement st = 
}
