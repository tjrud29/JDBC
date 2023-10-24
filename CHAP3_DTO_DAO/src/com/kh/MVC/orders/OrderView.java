package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	
	public void showOrderList(List<OrdersDTO> orders) {
		for(OrdersDTO o : orders) {
			System.out.println("�ֹ� ���� : " + o.getCafe_id());
			System.out.println("���� :" +  o.getTotal_price());
			System.out.println("==================================");
		}
	}
	
	public void showOrderTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}
