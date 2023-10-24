package com.kh.MVC.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bankDAO {

	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe1";
	String password = "khcafe1";
	
	
	public bankDAO() {
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<bankDTO> getAllbanks() {
		List<bankDTO> banks = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("UPDATE BANK SET balance = balance - ? where account_id = ?");
			st.setDouble(1, 300);
			st.setInt(2, 1);
			int rowsUpdate = st.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 완료!!!");
			
			bankDTO bank = new bankDTO(account_id,account_number,account_name
					,balance,branch_name,last_transaction_date);
			banks.add(bank);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
}
