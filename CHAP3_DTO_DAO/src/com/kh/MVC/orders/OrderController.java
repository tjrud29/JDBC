package com.kh.MVC.orders;

import java.util.List;

public class OrderController {
	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao = dao;
		
	}
	
	//�� ���� ��� �޼���
	public double calculateTotal(List<OrdersDTO> orders) {
		double totalPrice = 0;
		
		for(OrdersDTO totalo : orders) {
			totalPrice += totalo.getTotal_price();
			
		}
		return totalPrice;
		
	}
	public List<OrdersDTO> getAllProducts() {
		return dao.getALLProducts();
	}
}
