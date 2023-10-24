package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe1";
	String password = "khcafe1";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<OrdersDTO> getALLProducts() {
		List<OrdersDTO> orders = new ArrayList<>();
		
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM products");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int orderid = result.getInt("order_id");
				int cafeid = result.getInt("cafe_id");
				int menuid = result.getInt("menu_id");
				Date orderdate = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				int totalprice = result.getInt("total_price");
				
				OrdersDTO order = new OrdersDTO(orderid,cafeid,menuid,orderdate,quantity,totalprice); 
				orders.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	
	
	
	
	
	
	
	
	
	
	
}
