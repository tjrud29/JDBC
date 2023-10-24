package com.kh.MVC.orders;

import java.util.List;

public class OrderMain {

	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		List<OrdersDTO> orders = controller.getAllProducts();
		view.showOrderList(orders);
		
		
		
		double totalPrice = controller.calculateTotal(orders);
		view.showOrderList(orders);
	}

}
